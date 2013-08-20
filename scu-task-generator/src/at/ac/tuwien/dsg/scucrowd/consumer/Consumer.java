package at.ac.tuwien.dsg.scucrowd.consumer;

import java.util.logging.Logger;

import at.ac.tuwien.dsg.scucrowd.common.Util;
import at.ac.tuwien.dsg.scucrowd.model.FuzzyAptitude;
import at.ac.tuwien.dsg.scucrowd.model.FuzzyCompetence;
import at.ac.tuwien.dsg.scucrowd.model.Job;
import at.ac.tuwien.dsg.scucrowd.model.Objective;
import at.ac.tuwien.dsg.scucrowd.model.Quality;
import at.ac.tuwien.dsg.scucrowd.model.Task;
import at.ac.tuwien.dsg.scucrowd.model.TaskRequest;


public class Consumer {

  private static final String PROP_FILE = "consumer.properties";
  private static Logger logger = Logger.getLogger("ConsumerLogger");

  /**
   * @param args
   */
  public static void main(String[] args) {
    logger.info("START");
    
    // test request
    //sendGeneratedRequests();
    //sendSingleRequest();
    
    // request for finding aco param
    //sendIncreasingRequests();
    
    // request for measuring performance
    sendSingleSizeRequests(100);
    
    // request for measuring weight sensitivity
    //sendWcpSensitiveRequests();
    //sendWcnSensitiveRequests();
    //sendWcSensitiveRequests();
    //sendWtSensitiveRequests();
  }

  public static void sendWcpSensitiveRequests() {
    sendSingleSizeRequestsWithObjective("wcp=0.25", new Objective(0.25, 1, 1, 1));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wcp=0.5", new Objective(0.5, 1, 1, 1));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wcp=1", new Objective(1, 1, 1, 1));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wcp=2", new Objective(2, 1, 1, 1));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wcp=4", new Objective(4, 1, 1, 1));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wcp=8", new Objective(8, 1, 1, 1));    
  }
  
  public static void sendWcnSensitiveRequests() {
    sendSingleSizeRequestsWithObjective("wcn=0.25", new Objective(1, 0.25, 1, 1));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wcn=0.5", new Objective(1, 0.5, 1, 1));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wcn=1", new Objective(1, 1, 1, 1));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wcn=2", new Objective(1, 2, 1, 1));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wcn=4", new Objective(1, 4, 1, 1));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wcn=8", new Objective(1, 8, 1, 1));    
  }

  public static void sendWcSensitiveRequests() {
    sendSingleSizeRequestsWithObjective("wc=0.25", new Objective(1, 1, 0.25, 1));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wc=0.5", new Objective(1, 1, 0.5, 1));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wc=1", new Objective(1, 1, 1, 1));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wc=2", new Objective(1, 1, 2, 1));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wc=4", new Objective(1, 1, 4, 1));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wc=8", new Objective(1, 1, 8, 1));    
  }

  public static void sendWtSensitiveRequests() {
    sendSingleSizeRequestsWithObjective("wt=0.25", new Objective(1, 1, 1, 0.25));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wt=0.5", new Objective(1, 1, 1, 0.5));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wt=1", new Objective(1, 1, 1, 1));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wt=2", new Objective(1, 1, 1, 2));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wt=4", new Objective(1, 1, 1, 4));
    TaskGenerator.resetRandomGenerator();
    sendSingleSizeRequestsWithObjective("wt=8", new Objective(1, 1, 1, 8));    
  }

  public static void sendIncreasingRequests() {
    // generate request
    int nJobSize = 10;
    int nRequests = Integer.parseInt(Util.getProperty(PROP_FILE, "number_of_request"));
    int nApt= Integer.parseInt(Util.getProperty(PROP_FILE, "average_number_of_skill_per_job"));
    for (int i=2; i<=nJobSize; i++) {
      for (int j=0; j<nRequests; j++) {
        TaskRequest request = TaskGenerator.generate("Task #" + i + "/" + j, "t" + i, i, nApt, 0);
        System.out.println(request);
        if (i>1) { // checkpointing
          String result = APIClient.middleware().submitRequest(request);
          logger.info("Got response from middleware: " + result);
        }
      }
    }
  }
  
  public static void sendSingleSizeRequests() {
    int nRequests = Integer.parseInt(Util.getProperty(PROP_FILE, "number_of_request"));
    sendSingleSizeRequests(nRequests);
  }

  public static void sendSingleSizeRequests(int nRequests) {
    // generate request
    int jobSize = Integer.parseInt(Util.getProperty(PROP_FILE, "average_number_of_job_per_task"));
    int nApt= Integer.parseInt(Util.getProperty(PROP_FILE, "average_number_of_skill_per_job"));
    for (int j=0; j<nRequests; j++) {
      TaskRequest request = TaskGenerator.generate("Task #" + jobSize + "/" + j, "t" + jobSize, jobSize, nApt, 0);
      System.out.println(request);
      if (j>=0) { // checkpointing
        String result = APIClient.middleware().submitRequest(request);
        logger.info("Got response from middleware: " + result);
      }
    }
  }

  public static void sendSingleSizeRequestsWithObjective(String type, Objective objective) {
    // get param
    int nRequests = Integer.parseInt(Util.getProperty(PROP_FILE, "number_of_request"));
    int jobSize = Integer.parseInt(Util.getProperty(PROP_FILE, "average_number_of_job_per_task"));
    int nApt= Integer.parseInt(Util.getProperty(PROP_FILE, "average_number_of_skill_per_job"));
    double costAvg = Double.parseDouble(Util.getProperty(PROP_FILE, "average_cost_per_job"));
    double costSd = Double.parseDouble(Util.getProperty(PROP_FILE, "sd_cost_per_job"));
    //long durationAvg = Math.round(Double.parseDouble(Util.getProperty(PROP_FILE, "average_duration")));
    long durationAvg = 10;
    long submissionTime = 0;
    long deadline = submissionTime + (durationAvg * 3);
    // generate request
    for (int j=0; j<nRequests; j++) {
      TaskRequest request = TaskGenerator.generate("Task #" + jobSize + "/" + j, type, jobSize, nApt, (int)durationAvg);
      request.setObjective(objective);
      request.setCostLimit((costAvg+costSd) * jobSize);
      request.setSubmissionTime(submissionTime);
      request.setDeadline(deadline);
      request.setConnectedness(Quality.GOOD);
      System.out.println(request);
      if (j>=0) { // checkpointing
        String result = APIClient.middleware().submitRequest(request);
        logger.info("Got response from middleware: " + result);
      }
    }
  }

  public static void sendGeneratedRequests() {
    // generate request
    int nRequests = Integer.parseInt(Util.getProperty(PROP_FILE, "number_of_request"));
    for (int i=0; i<nRequests; i++) {
      TaskRequest request = TaskGenerator.generate("Task #" + i, "t" + i);
      System.out.println(request);
      String result = APIClient.middleware().submitRequest(request);
      logger.info("Got response from middleware: " + result);
    }
  }

  public static void sendSingleRequest() {
    TaskRequest request = TaskGenerator.createBuggyTaskRequest();
    System.out.println(request);
    String result = APIClient.middleware().submitRequest(request);
    logger.info("Got response from middleware: " + result);    
  }
  
  public static TaskRequest createTaskRequest() {
    Task t = new Task();
    t.setTitle("First task");
    t.setType("T1");

    // job 1
    FuzzyCompetence competence = new FuzzyCompetence();
    competence.getAptitudeSet().add(new FuzzyAptitude("1", Quality.POOR));
    //competence.getAptitudeSet().add(new FuzzyAptitude("2", Quality.POOR));
    //competence.getAptitudeSet().add(new FuzzyAptitude("3", Quality.POOR));
    t.getJobSet().add(new Job("J1", competence, 5));
/*
    // job 2
    competence = new FuzzyCompetence();
    competence.getAptitudeSet().add(new FuzzyAptitude("4", Quality.POOR));
    competence.getAptitudeSet().add(new FuzzyAptitude("5", Quality.POOR));
    competence.getAptitudeSet().add(new FuzzyAptitude("7", Quality.POOR));
    t.getJobSet().add(new Job("J2", competence, 5));

    // job 3
    competence = new FuzzyCompetence();
    competence.getAptitudeSet().add(new FuzzyAptitude("8", Quality.POOR));
    competence.getAptitudeSet().add(new FuzzyAptitude("9", Quality.POOR));
    t.getJobSet().add(new Job("J3", competence, 8));
    
    // job 4
    competence = new FuzzyCompetence();
    competence.getAptitudeSet().add(new FuzzyAptitude("10", Quality.POOR));
    competence.getAptitudeSet().add(new FuzzyAptitude("11", Quality.POOR));
    t.getJobSet().add(new Job("J4", competence, 12));

    // job 5
    competence = new FuzzyCompetence();
    competence.getAptitudeSet().add(new FuzzyAptitude("12", Quality.POOR));
    competence.getAptitudeSet().add(new FuzzyAptitude("13", Quality.POOR));
    t.getJobSet().add(new Job("J5", competence, 12));
*/
    
    TaskRequest request = new TaskRequest(t, 0, 40, Quality.POOR, 20, new Objective(1, 1, 1, 1));
    
    return request;
  }


}
