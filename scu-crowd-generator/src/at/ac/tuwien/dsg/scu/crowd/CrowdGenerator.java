package at.ac.tuwien.dsg.scu.crowd;

import java.sql.SQLException;
import java.util.logging.Logger;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.UniformIntegerDistribution;
import org.apache.commons.math3.distribution.UniformRealDistribution;
import org.apache.commons.math3.random.MersenneTwister;

import at.ac.tuwien.dsg.scu.common.Util;
import at.ac.tuwien.dsg.scu.model.Aptitude;
import at.ac.tuwien.dsg.scu.model.Worker;

public class CrowdGenerator {

  public static final String PROP_FILE = "scu-crowd-generator.properties";
  private static Logger logger = Logger.getLogger("CrowdGeneratorLogger");
  
  // seeds
  private static final int INITIAL_SEED = Integer.parseInt(Util.getProperty(PROP_FILE, "random_seed"));
  private static final int SEED_APTITUDE_TYPE = INITIAL_SEED + 1;
  private static final int SEED_APTITUDE_NUMBER = INITIAL_SEED + 2;
  private static final int SEED_APTITUDE_SCORE = INITIAL_SEED + 3;
  private static final int SEED_APTITUDE_COST = INITIAL_SEED + 4;
  private static final int SEED_CONNECTION = INITIAL_SEED + 5;
  private static final int SEED_WEIGHT = INITIAL_SEED + 6;
  private static final int SEED_AVAIL = INITIAL_SEED + 7;
  private static final int SEED_UNAVAIL = INITIAL_SEED + 8;
  private static final int SEED_START_STATE = INITIAL_SEED + 9;
  
  // reusable generator
  private static UniformIntegerDistribution distAvail = null;
  private static UniformIntegerDistribution distUnavail = null;
  private static UniformRealDistribution distStartState = null;


  public static void generate() {
    CrowdDatabase db = CrowdDatabase.getInstance();

    // set autocommit to false, otherwise it will be extremely slow
    try {
        db.getStatement().getConnection().setAutoCommit(false);
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // initialize database
    try {
        logger.info("Initialize crowd database.");
        // drop tables
        db.getStatement().executeUpdate("DROP TABLE IF EXISTS worker");
        db.getStatement().executeUpdate("DROP TABLE IF EXISTS worker_aptitude");
        db.getStatement().executeUpdate("DROP TABLE IF EXISTS worker_relation");
        // create tables
        db.getStatement().executeUpdate("CREATE TABLE worker (id INTEGER PRIMARY KEY, cost NUMERIC, queue TEXT);");
        db.getStatement().executeUpdate("CREATE TABLE worker_aptitude (worker_id INTEGER, type TEXT, score NUMERIC);");
        db.getStatement().executeUpdate("CREATE TABLE worker_relation (worker_id_1 INTEGER, worker_id_2 INTEGER, weight NUMERIC)");
        
        db.getStatement().getConnection().commit();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    try {

      // generate workers
      int nWorker = Integer.parseInt(Util.getProperty(PROP_FILE, "number_of_worker"));
      logger.info("Generating " + nWorker + " workers.");
      for (int i=1; i<=nWorker; i++) {
        WorkerHandler.createWorker(i);
      }

      db.getStatement().getConnection().commit();

      // initiate the distribution for the types of aptitude assigned to each worker
      int nAptituteType = Integer.parseInt(Util.getProperty(PROP_FILE, "number_of_skill_type"));
      UniformIntegerDistribution distAptType = new UniformIntegerDistribution(new MersenneTwister(SEED_APTITUDE_TYPE), 
          1, nAptituteType);      
      // initiate the distribution for the number of aptitude assigned to each worker
      double nAptitudeAvg = Double.parseDouble(Util.getProperty(PROP_FILE, "average_number_of_skill_per_worker"));
      double nAptitudeSd = Double.parseDouble(Util.getProperty(PROP_FILE, "sd_number_of_skill_per_worker"));
      NormalDistribution distApt = new NormalDistribution(new MersenneTwister(SEED_APTITUDE_NUMBER), 
          nAptitudeAvg, nAptitudeSd, NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
      // initiate the distribution for the score of aptitude assigned to each worker
      double nScoreAvg = Double.parseDouble(Util.getProperty(PROP_FILE, "average_skill_score"));
      double nScoreSd = Double.parseDouble(Util.getProperty(PROP_FILE, "sd_skill_score"));
      NormalDistribution distScore = new NormalDistribution(new MersenneTwister(SEED_APTITUDE_SCORE), 
          nScoreAvg, nScoreSd, NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
      // populating workers' aptitudes
      logger.info("Generating workers' aptitude (navg="+nAptitudeAvg+",scoreavg="+nScoreAvg+").");
      for (int i=1; i<=nWorker; i++) {
        long nApt = Math.round(distApt.sample());
        for (int j=0; j<nApt; j++) {
          int aptType = distAptType.sample();
          double score = distScore.sample();
          if (score<0.0) score = 0.0;
          else if (score>1.0) score = 1.0;
          WorkerHandler.updateAptitude(new Worker(i), new Aptitude(Integer.toString(aptType), score));
        }
      }

      db.getStatement().getConnection().commit();

      // initiate the distribution for the worker cost
      double costAvg = Double.parseDouble(Util.getProperty(PROP_FILE, "average_cost"));
      double costSd = Double.parseDouble(Util.getProperty(PROP_FILE, "sd_cost"));
      NormalDistribution distCost = new NormalDistribution(new MersenneTwister(SEED_APTITUDE_COST), 
          costAvg, costSd, NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
      // populating workers' aptitudes
      logger.info("Generating workers' cost (avg="+costAvg+").");
      for (int i=1; i<=nWorker; i++) {
        WorkerHandler.updateCost(new Worker(i), distCost.sample());
      }

      db.getStatement().getConnection().commit();

      // initiate the distribution for the worker relation
      double pConnect = Double.parseDouble(Util.getProperty(PROP_FILE, "probability_of_connectivity"));
      UniformRealDistribution distConnect = new UniformRealDistribution(new MersenneTwister(SEED_CONNECTION), 
          0, 1);      
      double weightAvg = Double.parseDouble(Util.getProperty(PROP_FILE, "average_relation_weight"));
      double weightSd = Double.parseDouble(Util.getProperty(PROP_FILE, "sd_relation_weight"));
      NormalDistribution distWeight = new NormalDistribution(new MersenneTwister(SEED_WEIGHT), 
          weightAvg, weightSd, NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);      
      // populating workers' relation, this is undirected and no loop. so, we always use edge (i,j) where i<j
      logger.info("Generating workers' relation (pconnect="+pConnect+",weightavg="+weightAvg+").");
      for (int i=1; i<=nWorker; i++) {
        for (int j=i+1; j<=nWorker; j++) {
          if (i!=j) {
            if (distConnect.sample()<=pConnect) {
              long weight = Math.round(distWeight.sample());
              WorkerHandler.updateRelation(new Worker(i), new Worker(j), weight);
            }
          }
        }
      }

      logger.info("Generating workers' availability");
      for (int i=1; i<=nWorker; i++) {
        String block = generateAvailability(30, "");
        WorkerHandler.addAvailability(new Worker(i), block);
      }
      
      logger.info("Crowd generation DONE.");
      db.getStatement().getConnection().commit();
      db.getStatement().getConnection().setAutoCommit(true);
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public static String generateAvailability(int minLength, String currentQueue) {
    
    String result = "";
    
    if (distAvail==null) {
      // get param
      int minAvail = Integer.parseInt(Util.getProperty(PROP_FILE, "min_avail_block"));
      int maxAvail = Integer.parseInt(Util.getProperty(PROP_FILE, "max_avail_block"));
      int minUnavail = Integer.parseInt(Util.getProperty(PROP_FILE, "min_unavail_block"));
      int maxUnavail = Integer.parseInt(Util.getProperty(PROP_FILE, "max_unavail_block"));
      distAvail = new UniformIntegerDistribution(new MersenneTwister(SEED_AVAIL), 
          minAvail, maxAvail); 
      distUnavail = new UniformIntegerDistribution(new MersenneTwister(SEED_UNAVAIL), 
          minUnavail, maxUnavail); 
      distStartState = new UniformRealDistribution(new MersenneTwister(SEED_START_STATE), 0, 1);          
    }
    
    // get next state
    char lastState;
    if (currentQueue.length()>0) {
      lastState = currentQueue.charAt(currentQueue.length()-1);
    } else {
      lastState = Double.toString(Math.round(distStartState.sample())).charAt(0);
    }
    int nextState = 1;
    if (lastState=='1' || lastState=='2') nextState = 0;
    
    int nextLength = 0; 
    while (result.length()<minLength) {
      if (nextState==1) {
        nextLength = distAvail.sample();
      } else {
        nextLength = distUnavail.sample();
      }
      String block = Util.stringRepeat(Integer.toString(nextState), nextLength);
      nextState = (nextState+1) % 2;
      result += block;
    }
    
    return result;
  }

}
