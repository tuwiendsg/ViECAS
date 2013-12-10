package at.ac.tuwien.dsg.scu.model;


public class TaskRequest {
  
  private Task task;
  private long submissionTime;
  private long deadline;
  private double costLimit;
  private Quality connectedness;
  private Objective objective;

  public TaskRequest() {
  }

  @Override
  public String toString() {
    return "TaskRequest [task=" + task + ", submissionTime=" + submissionTime
        + ", deadline=" + deadline + ", costLimit=" + costLimit
        + ", connectedness=" + connectedness + ", objective=" + objective + "]";
  }

  public TaskRequest(Task task, long submissionTime, long deadline,
      Quality connectedness, double costLimit, Objective objective) {
    this.task = task;
    this.submissionTime = submissionTime;
    this.deadline = deadline;
    this.connectedness = connectedness;
    this.costLimit = costLimit;
    this.objective = objective;
  }

  public Task getTask() {
    return task;
  }
  public void setTask(Task task) {
    this.task = task;
  }
  public long getDeadline() {
    return deadline;
  }
  public void setDeadline(long deadline) {
    this.deadline = deadline;
  }
  public double getCostLimit() {
    return costLimit;
  }
  public void setCostLimit(double costLimit) {
    this.costLimit = costLimit;
  }

  public Objective getObjective() {
    return objective;
  }

  public void setObjective(Objective objective) {
    this.objective = objective;
  }

  public long getSubmissionTime() {
    return submissionTime;
  }

  public void setSubmissionTime(long submissionTime) {
    this.submissionTime = submissionTime;
  }

  public Quality getConnectedness() {
    return connectedness;
  }

  public void setConnectedness(Quality connectedness) {
    this.connectedness = connectedness;
  }
  
  public boolean isSolutionFeasible(Solution s) {
    if (objective.getConnectednessWeight()>0 && s.getList().size()>1 && s.getFuzzyConnectedness()==0.0) return false;
    else if (objective.getCostWeight()>0 && s.getCost()>this.costLimit) return false;
    
    // the following two should not happen because we have prune the construction graph
    else if (objective.getCompetencyWeight()>0 && s.getCompetency()==0.0) return false;
    else if (objective.getResponseTimeWeight()>0 && s.getTime()>this.deadline) return false;
    
    else return true;
  }
  
}
