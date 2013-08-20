package at.ac.tuwien.dsg.scu.model;

import java.util.ArrayList;

public class Task {
  
  private String type;
  private String title;
  private ArrayList<Job> jobSet;

  public Task() {
    this.jobSet = new ArrayList<Job>();
  }

  public Task(String type, String title) {
    this.type = type;
    this.title = title;
    this.jobSet = new ArrayList<Job>();
  }

  @Override
  public String toString() {
    String competence = "";
    for (Job j : jobSet) {
      FuzzyCompetence c = j.getCompetence(); 
      if (!competence.equals("")) competence += ",";
      //competence += c;
      competence += j;
    }
    return "Task [type=" + type + ", title=" + title + ", job=" + competence + "]";
  }

  public String getType() {
    return type;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }

  public ArrayList<Job> getJobSet() {
    return jobSet;
  }

  public void setJobSet(ArrayList<Job> jobSet) {
    this.jobSet = jobSet;
  }

}
