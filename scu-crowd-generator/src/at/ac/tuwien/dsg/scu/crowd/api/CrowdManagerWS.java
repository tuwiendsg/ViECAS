package at.ac.tuwien.dsg.scu.crowd.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.jws.WebService;

import at.ac.tuwien.dsg.scu.crowd.JobHandler;
import at.ac.tuwien.dsg.scu.crowd.WorkerHandler;
import at.ac.tuwien.dsg.scu.model.Job;
import at.ac.tuwien.dsg.scu.model.JobAssignment;
import at.ac.tuwien.dsg.scu.model.Worker;
import at.ac.tuwien.dsg.scu.model.WorkerRelation;

@WebService
public class CrowdManagerWS {

  private static Logger logger = Logger.getLogger("MetaCrowdLogger");

  public boolean assignJob(JobAssignment assignment) {
    logger.info("[API] assignJobBatch: " + assignment);    
    return JobHandler.assignJob(assignment);
  }
  
  public boolean assignJobBatch(List<JobAssignment> jobBatch) {
    String sjob = "";
    for (JobAssignment a: jobBatch) sjob += a + "; ";
    logger.info("[API] assignJobBatch: " + sjob);    
    return JobHandler.assignJobBatch(jobBatch);
  }
  
  public ArrayList<Worker> getWorkers(Job job, long submissionTime, long deadline) {
    ArrayList<Worker> workers = WorkerHandler.getWorkers(job, submissionTime, deadline);
    logger.info("[API] getWorkers: " + job + ", deadline: " + deadline + ". Found: " + workers.size());    
    return workers;
  }
  
  public ArrayList<WorkerRelation> getWorkerRelations(ArrayList<Worker> workers) {
    logger.info("[API] getWorkerRelations: " + workers);
    logger.info("retrieving... ");
    ArrayList<WorkerRelation> relations = WorkerHandler.getWorkerRelations(workers);
    logger.info("getWorkerRelations DONE");
    return relations;
  }
  
  public int getResponseTime(Worker worker, Job job, long submissionTime) {
    logger.info("[API] getResponseTime: " + worker);
    return WorkerHandler.getResponseTime(worker, job, submissionTime);
  }
  
}
