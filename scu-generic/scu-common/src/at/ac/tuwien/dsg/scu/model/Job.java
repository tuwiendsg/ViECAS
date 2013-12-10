package at.ac.tuwien.dsg.scu.model;

import java.rmi.server.UID;

public class Job {

  private FuzzyCompetence competence;
  private String title;
  private int duration;
  private UID id;
  
  public Job() {
    this.id = new UID();
  }

  public Job(FuzzyCompetence competence) {
    this.competence = competence;
    this.id = new UID();
  }

  public Job(String title, FuzzyCompetence competence, int duration) {
    this.competence = competence;
    this.title = title;
    this.duration = duration;
    this.id = new UID();
  }

  public Job(String title, FuzzyCompetence competence) {
    this.title = title;
    this.competence = competence;
    this.id = new UID();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public FuzzyCompetence getCompetence() {
    return competence;
  }

  public void setCompetence(FuzzyCompetence competence) {
    this.competence = competence;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  @Override
  public String toString() {
    return "Job [duration=" + duration + ",competence=" + competence + "]";
    //if (this.title==null) return "Job [competence=" + competence + "]";
    //else return this.title;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Job other = (Job) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  
  
  
}
