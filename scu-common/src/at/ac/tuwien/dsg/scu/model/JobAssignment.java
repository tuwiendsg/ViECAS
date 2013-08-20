package at.ac.tuwien.dsg.scu.model;


public class JobAssignment {
  
  private Worker worker;
  private Job job;
  private int start;
  
  public JobAssignment() {
  }

  public JobAssignment(Worker worker, Job job, int start) {
    this.worker = worker;
    this.job = job;
    this.start = start; // index start at 0
  }

  public Worker getWorker() {
    return worker;
  }

  public void setWorker(Worker worker) {
    this.worker = worker;
  }

  public Job getJob() {
    return job;
  }

  public void setJob(Job job) {
    this.job = job;
  }

  public int getStart() {
    return start;
  }

  public void setStart(int start) {
    this.start = start;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    JobAssignment other = (JobAssignment) obj;
    if (job == null) {
      if (other.job != null)
        return false;
    } else if (!job.equals(other.job))
      return false;
    if (start != other.start)
      return false;
    if (worker == null) {
      if (other.worker != null)
        return false;
    } else if (!worker.equals(other.worker))
      return false;
    return true;
  }
  
  

}
