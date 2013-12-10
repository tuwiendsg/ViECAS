package at.ac.tuwien.dsg.scu.crowd;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.xml.ws.Endpoint;

import at.ac.tuwien.dsg.scu.common.Util;
import at.ac.tuwien.dsg.scu.crowd.api.CrowdManagerWS;
import at.ac.tuwien.dsg.scu.model.Worker;
import at.ac.tuwien.dsg.scu.model.WorkerRelation;

public class CrowdMain {

  private static final String PROP_FILE = CrowdGenerator.PROP_FILE;
  private static Logger logger = Logger.getLogger("CrowdManagerLogger");

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    boolean generateCrowd = Boolean.parseBoolean(Util.getProperty(PROP_FILE, "generate_crowd"));
    if (generateCrowd) {
      logger.info("Generating crowd.");
      CrowdGenerator.generate();
    }

    //test();
    
    logger.info("Caching workers.");
    WorkerHandler.loadWorkers();

    logger.info("Caching workers connectedness.");
    WorkerHandler.loadWorkerRelations();

    String endpointURL = Util.getProperty(PROP_FILE, "service_endpoint");
    Endpoint.publish(endpointURL, new CrowdManagerWS());
    logger.info("CrowdManager Service started.");
    
    //CrowdDatabase.closeInstance();
  }
  
  private static void test() {
    /*
    // test assignJobBatch
    ArrayList<JobAssignment> jobBatch = new ArrayList<JobAssignment>();
    jobBatch.add(new JobAssignment(2, 3, 7));
    jobBatch.add(new JobAssignment(1, 2, 5));
    JobHandler.assignJobBatch(jobBatch);
    */
    
    /*
    // test filtering workers
    FuzzyCompetence fc = new FuzzyCompetence();
    fc.getAptitudeSet().add(new FuzzyAptitude("1", Quality.POOR));
    fc.getAptitudeSet().add(new FuzzyAptitude("10", Quality.POOR));
    Job job = new Job(fc, "J1", 10);
    System.out.println();
    ArrayList<Worker> workers = WorkerHandler.getWorkers(job, 10); 
    System.out.println("Workers found: " + workers.size());
    for (Worker w: workers) {
      System.out.println(w);
    }
    */
    
    // test get relationship
    ArrayList<Worker> workers = new ArrayList<Worker>();
    workers.add(new Worker(1));
    workers.add(new Worker(2));
    workers.add(new Worker(3));
    workers.add(new Worker(4));
    ArrayList<WorkerRelation> relations = WorkerHandler.getWorkerRelations(workers);
    for (WorkerRelation r: relations) {
      System.out.println(r);
    }
    
    
  }

}
