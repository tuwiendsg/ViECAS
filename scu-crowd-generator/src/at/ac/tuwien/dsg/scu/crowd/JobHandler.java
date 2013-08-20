package at.ac.tuwien.dsg.scu.crowd;

import java.util.List;

import at.ac.tuwien.dsg.scu.common.Util;
import at.ac.tuwien.dsg.scu.model.JobAssignment;
import at.ac.tuwien.dsg.scu.model.Queue;

public class JobHandler {

  /**
   * Assign a job to a single worker at the requested time slot. 
   * Time slot index starts at 0.
   * @param workerId
   * @param start
   * @param length
   * @return true if the allocated slot is available, false otherwise.
   */
  public static boolean assignJob(JobAssignment assignment) {

    int start = assignment.getStart();
    int duration = assignment.getJob().getDuration();
    String sequence = assignment.getWorker().getQueue().getSequence();
    
    if (start<0 || duration<1) return false;
    
    // if not enough queue length, extend
    // TODO: use an interface of availability extender, so that availability can be generated with real availability data
    if (sequence.length()<start+duration) sequence += CrowdGenerator.generateAvailability((duration>30?duration:30), sequence);
    
    String block = sequence.substring(start, start+duration);
    if (block.equals(Util.stringRepeat("1", duration))) {
      sequence = sequence.substring(0, start) + Util.stringRepeat("2", duration) + sequence.substring(start+duration);
      WorkerHandler.updateQueue(assignment.getWorker(), new Queue(sequence));
      return true;
    } else {
      // worker not available at the requested time slot
      return false;
    }
  }

  /**
   * Assign a batch of jobs
   * @param assignment
   * @return
   */
  public static boolean assignJobBatch(List<JobAssignment> assignment) {
    boolean allSuccessful = true;
    for (JobAssignment a : assignment) {
      boolean result = assignJob(a);
      if (!result) allSuccessful = false;
    }
    return allSuccessful;
  }
}
