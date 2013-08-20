package at.ac.tuwien.dsg.scu.crowd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import at.ac.tuwien.dsg.scu.common.Util;
import at.ac.tuwien.dsg.scu.model.Aptitude;
import at.ac.tuwien.dsg.scu.model.Competence;
import at.ac.tuwien.dsg.scu.model.FuzzyAptitude;
import at.ac.tuwien.dsg.scu.model.Job;
import at.ac.tuwien.dsg.scu.model.Queue;
import at.ac.tuwien.dsg.scu.model.Worker;
import at.ac.tuwien.dsg.scu.model.WorkerRelation;
import at.ac.tuwien.dsg.scu.model.fuzzy.AptitudeMembershipFunctions;

public class WorkerHandler {
  
  private static CrowdDatabase db = CrowdDatabase.getInstance();
  
  // cache
  private static ArrayList<Worker> workerCache; 
  private static ArrayList<WorkerRelation> workerRelationCache; 
  
  public static Worker createWorker(long id) {
    try {
      db.getStatement().executeUpdate("insert into worker(id) values(" + id + ")");
      return new Worker(id);
    } catch (SQLException e) {
      return null;
    }
  }

  public static boolean updateAptitude(Worker worker, Aptitude aptitude) {
    try {
      // try to update first
      int result = db.getStatement().executeUpdate("update worker_aptitude set score=" + aptitude.getScore() + " where worker_id=" + worker.getId() + " and type='" + aptitude.getType() + "'");
      // if no update, do insert
      if (result==0) {
        db.getStatement().executeUpdate("insert into worker_aptitude(worker_id, type, score) values(" + worker.getId() + ", " + aptitude.getType() + ", " + aptitude.getScore() + ")");
      }
      return true;
    } catch (SQLException e) {
      return false;
    }
  }

  public static boolean updateRelation(Worker w1, Worker w2, long weight) {
    try {
      // try to update first
      int result = db.getStatement().executeUpdate("update worker_relation set weight=" + weight + " where worker_id_1=" + w1.getId() + " and worker_id_2=" + w2.getId());
      // if no update, do insert
      if (result==0) {
        db.getStatement().executeUpdate("insert into worker_relation(worker_id_1, worker_id_2, weight) values(" + w1.getId() + ", " + w2.getId() + ", " + weight + ")");
      }
      return true;
    } catch (SQLException e) {
      return false;
    }
  }

  public static boolean addAvailability(Worker worker, String availability) {
    try {
      db.getStatement().executeUpdate("update worker set queue=ifnull(queue, '')||'"+availability+"' where id="+worker.getId());
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
  
  public static boolean updateQueue(Worker worker, Queue queue) {
    try {
      db.getStatement().executeUpdate("update worker set queue='"+queue.getSequence()+"' where id="+worker.getId());
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static boolean updateCost(Worker worker, double cost) {
    try {
      db.getStatement().executeUpdate("update worker set cost="+cost+" where id="+worker.getId());
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static String getQueueSequence(Worker worker) {
    try {
      if (worker.getQueue()!=null && worker.getQueue().getSequence()!=null) return worker.getQueue().getSequence(); 
      ResultSet rs = db.getStatement().executeQuery("select ifnull(queue, '') from worker where id="+worker.getId());
      if (rs.next()) return rs.getString(1);
      else return "";
    } catch (SQLException e) {
      e.printStackTrace();
      return "";
    }
  }
  
  public static ArrayList<Worker> _getWorkers(Job job, long submissionTime, long deadline) {
    ArrayList<Worker> workers = new ArrayList<Worker>();
    String sql = "";
    try {
      String where1 = "";
      String where2 = "";
      for (FuzzyAptitude a: job.getCompetence().getAptitudeSet()) {
        double lowerBound = AptitudeMembershipFunctions.getInstance().getMembershipFunction(a.getQuality()).lowerBound();
        double upperBound = AptitudeMembershipFunctions.getInstance().getMembershipFunction(a.getQuality()).upperBound();
        if (!where1.equals("")) where1 += " or ";
        if (!where2.equals("")) where2 += " or ";
        where1 += "(worker_aptitude.type='" + a.getType() + "' and score>=" + lowerBound + " and score<=" + upperBound + ")";
        where2 += "worker_aptitude.type='" + a.getType() + "'";
      }
      where1 = " where " + where1;
      sql = "select id, cost, queue from worker left join worker_aptitude on worker.id=worker_aptitude.worker_id " + where1 +
          " group by id, cost, queue having count(*)>=" + job.getCompetence().getAptitudeSet().size();
      ResultSet rs1 = db.getStatement().executeQuery(sql);

      System.out.println(sql);      
      while (rs1.next()) {
        
        long workerId = rs1.getLong("id");
        String sequence = rs1.getString("queue");
        double cost = rs1.getDouble("cost");
        
        // check deadline based on the queue sequence
        boolean isQueueUpdated = false;
        int duration = job.getDuration();
        String block = Util.stringRepeat("1", duration);
        int pos = sequence.indexOf(block, (int)submissionTime);
        
        // TODO: we need a better way to auto extend the queue in a more generic way
        int maxExtension = 5;
        int i = 0;
        while (pos==-1 && i<maxExtension) {
          sequence += CrowdGenerator.generateAvailability((duration>30?duration:30), sequence);
          pos = sequence.indexOf(block, (int)submissionTime);
          isQueueUpdated = true;
          i++;
        }
        if (isQueueUpdated) {
          WorkerHandler.updateQueue(new Worker(workerId), new Queue(sequence));
        }
        
        if (pos==-1 || pos+duration>deadline) continue; // deadline will be violated if we assign to this worker
        
        // get list of competence which is relevant with the request
        String whereWorker = " where worker_id=" + rs1.getString("id");
        String where = "";
        if (where2.equals("")) where = whereWorker;
        else where = whereWorker + " and (" + where2 + ")";
        sql = "select type, score from worker_aptitude " + where;
        ResultSet rs2 = db.getStatement().executeQuery(sql);
        Competence c = new Competence(); 
        while (rs2.next()) {
          c.getAptitudeSet().add(new Aptitude(rs2.getString("type"), rs2.getDouble("score") ));
        }
        
        workers.add(new Worker(workerId, c, new Queue(sequence), cost));
        
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return workers;
  }
  
  public static ArrayList<Worker> getWorkers(Job job, long submissionTime, long deadline) {
    ArrayList<Worker> workers = new ArrayList<Worker>();
    for (Worker worker: workerCache) {
      boolean match = true;

      // check competence
      for (FuzzyAptitude a: job.getCompetence().getAptitudeSet()) {
        double lowerBound = AptitudeMembershipFunctions.getInstance().getMembershipFunction(a.getQuality()).lowerBound();
        double upperBound = AptitudeMembershipFunctions.getInstance().getMembershipFunction(a.getQuality()).upperBound();
        Aptitude apt = worker.getCompetence().getAptitudeForType(a.getType());
        if (apt==null || (apt.getScore()<=lowerBound || apt.getScore()>=upperBound)) {
          match = false;
          break;
        }
      }
      
      // check job queue
      if (match) {
        // check deadline based on the queue sequence
        String sequence = worker.getQueue().getSequence();
        boolean isQueueUpdated = false;
        int duration = job.getDuration();
        String block = Util.stringRepeat("1", duration);
        int pos = sequence.indexOf(block, (int)submissionTime);
        
        // TODO: we need a better way to auto extend the queue in a more generic way
        int maxExtension = 5;
        int i = 0;
        while (pos==-1 && i<maxExtension) {
          sequence += CrowdGenerator.generateAvailability((duration>30?duration:30), sequence);
          pos = sequence.indexOf(block, (int)submissionTime);
          isQueueUpdated = true;
          i++;
        }
        if (isQueueUpdated) {
          worker.getQueue().setSequence(sequence);
          //WorkerHandler.updateQueue(new Worker(workerId), new Queue(sequence));
        }
        
        if (pos==-1 || pos+duration>deadline) {
          // deadline will be violated if we assign to this worker
          match = false;
        }
      }
      
      if (match) workers.add(worker);
    }
    
    return workers;
  }

  public static ArrayList<WorkerRelation> _getWorkerRelations(ArrayList<Worker> workers) {
    ArrayList<WorkerRelation> relations = new ArrayList<WorkerRelation>();
    
    // special case for single worker
    if (workers.size()==1) {
      relations.add(new WorkerRelation(workers.get(0)));
    }
      
    // iterate to get the relations
    for (int i=0; i<workers.size(); i++) {
      Worker worker1 = workers.get(i);
      for (int j=i+1; j<workers.size(); j++) {
        Worker worker2 = workers.get(j);
        WorkerRelation relation = new WorkerRelation(worker1, worker2, 0);
        // get from db
        String sql = "select * from worker_relation where worker_id_1='"+relation.getWorker1().getId()+"' and worker_id_2='"+relation.getWorker2().getId()+"'";
        ResultSet rs;
        try {
          rs = db.getStatement().executeQuery(sql);
          if (rs.next()) relation.setWeight(rs.getInt("weight"));
        } catch (SQLException e) {
          e.printStackTrace();
        }
        relations.add(relation);
      }
    }
    
    return relations;
  }
  
  public static ArrayList<WorkerRelation> getWorkerRelations(ArrayList<Worker> workers) {
    ArrayList<WorkerRelation> relations = new ArrayList<WorkerRelation>();
    
    // special case for single worker
    if (workers.size()==1) {
      relations.add(new WorkerRelation(workers.get(0)));
    }
      
    // iterate to get the relations
    for (int i=0; i<workers.size(); i++) {
      Worker worker1 = workers.get(i);
      for (int j=i+1; j<workers.size(); j++) {
        Worker worker2 = workers.get(j);
        WorkerRelation relation = new WorkerRelation(worker1, worker2, 0);
        int index = workerRelationCache.indexOf(relation);
        if (index>=0) relation = workerRelationCache.get(index);
        relations.add(relation);
      }
    }
    
    return relations;
  }

  public static int _getResponseTime(Worker worker, Job job, long submissionTime) {

    // init
    boolean isQueueUpdated = false;
    int duration = job.getDuration();
    String block = Util.stringRepeat("1", duration);
    String sequence = getQueueSequence(worker);
    int pos = sequence.indexOf(block, (int)submissionTime);
    
    // TODO: we need a better way to auto extend the queue in a more generic way
    int maxExtension = 5;
    int i = 0;
    while (pos==-1 && i<maxExtension) {
      sequence += CrowdGenerator.generateAvailability((duration>30?duration:30), sequence);
      pos = sequence.indexOf(block, (int)submissionTime);
      isQueueUpdated = true;
      i++;
    }
    if (isQueueUpdated) {
      WorkerHandler.updateQueue(worker, new Queue(sequence));
    }
    
    return pos + duration;
    
  }
  
  public static int getResponseTime(Worker worker, Job job, long submissionTime) {

    // get worker from cache
    int index = workerCache.indexOf(worker);
    worker = workerCache.get(index);
    
    // init
    boolean isQueueUpdated = false;
    int duration = job.getDuration();
    String block = Util.stringRepeat("1", duration);
    String sequence = worker.getQueue().getSequence();
    int pos = sequence.indexOf(block, (int)submissionTime);
    
    // TODO: we need a better way to auto extend the queue in a more generic way
    int maxExtension = 10;
    int i = 0;
    while (pos==-1 && i<maxExtension) {
      sequence += CrowdGenerator.generateAvailability((duration>30?duration:30), sequence);
      pos = sequence.indexOf(block, (int)submissionTime);
      isQueueUpdated = true;
      i++;
    }
    if (isQueueUpdated) {
      worker.getQueue().setSequence(sequence);
      //WorkerHandler.updateQueue(worker, new Queue(sequence));
    }
    
    return pos + duration;
    
  }

  public static void loadWorkerRelations() {
    workerRelationCache = new ArrayList<WorkerRelation>(); 
    String sql = "select * from worker_relation";
    ResultSet rs;
    try {
      rs = db.getStatement().executeQuery(sql);
      while (rs.next()) {
        long workerId1 = rs.getLong("worker_id_1");
        long workerId2 = rs.getLong("worker_id_2");
        int weight = rs.getInt("weight");
        WorkerRelation relation = new WorkerRelation(new Worker(workerId1), new Worker(workerId2), weight);
        workerRelationCache.add(relation);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
  
  public static void loadWorkers() {
    workerCache = new ArrayList<Worker>();
    String sql = "select * from worker";
    try {
      ResultSet rsw = db.getStatement().executeQuery(sql);
      while (rsw.next()) {
        long workerId = rsw.getLong("id");
        double cost = rsw.getDouble("cost");
        String queue = rsw.getString("queue");
        sql = "select * from worker_aptitude where worker_id=" + workerId;
        ResultSet rsa = db.getStatement().executeQuery(sql);
        Competence competence = new Competence();
        while (rsa.next()) {
          String type = rsa.getString("type");
          double score = rsa.getDouble("score");
          competence.getAptitudeSet().add(new Aptitude(type, score));
        }
        Worker worker = new Worker(workerId, competence, new Queue(queue), cost);
        workerCache.add(worker);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
}
