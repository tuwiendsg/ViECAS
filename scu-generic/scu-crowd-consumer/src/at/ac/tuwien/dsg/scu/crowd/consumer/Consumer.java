package at.ac.tuwien.dsg.scu.crowd.consumer;

import java.util.ArrayList;
import java.util.logging.Logger;

import at.ac.tuwien.dsg.scu.model.FuzzyAptitude;
import at.ac.tuwien.dsg.scu.model.FuzzyCompetence;
import at.ac.tuwien.dsg.scu.model.Job;
import at.ac.tuwien.dsg.scu.model.Quality;
import at.ac.tuwien.dsg.scu.model.Worker;


public class Consumer {

  public static final String PROP_FILE = "consumer.properties";
  private static Logger logger = Logger.getLogger("ConsumerLogger");

  /**
   * @param args
   */
  public static void main(String[] args) {
    logger.info("TESTING CONSUMING CROWDMANAGER");
    
    // test request
    FuzzyCompetence fc = new FuzzyCompetence();
    fc.getAptitudeSet().add(new FuzzyAptitude("1", Quality.POOR));
    fc.getAptitudeSet().add(new FuzzyAptitude("2", Quality.POOR));
    Job job = new Job("J1", fc, 5);
    System.out.println();
    ArrayList<Worker> workers = (ArrayList<Worker>) APIClient.crowdManager().getWorkers(job, 0, 30); 
    System.out.println("Workers found: " + workers.size());
    for (Worker w: workers) {
      System.out.println(w);
    }
    
  }


}
