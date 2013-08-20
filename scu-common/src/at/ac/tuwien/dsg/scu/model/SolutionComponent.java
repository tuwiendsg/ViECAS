package at.ac.tuwien.dsg.scu.model;

import at.ac.tuwien.dsg.scu.model.fuzzy.AptitudeMembershipFunctions;
import at.ac.tuwien.dsg.scu.model.fuzzy.ConnectednessMembershipFunctions;
import at.ac.tuwien.dsg.scu.model.fuzzy.MembershipFunction;

public class SolutionComponent extends JobAssignment {

  private int level;
  private double pheromone;
  private long estimatedResponseTime;
  
  public SolutionComponent() {
    super();
  }

  public SolutionComponent(int level) {
    super();
    this.level = level;
  }

  public SolutionComponent(int level, Job job, Worker worker) {
    super(worker, job, 0);
    this.level = level;
  }
  
  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  @Override
  public String toString() {
    //if (worker==null || job==null) return "SolutionComponent [level=" + level + "]";
    //else return "SolutionComponent [level=" + level + ", job=" + job + ", worker=" + worker.getId() + "]";
    if (getWorker()==null || getJob()==null) return "Comp [" + level + "]";
    else return "[" + level + ", " + getJob() + ", W#" + getWorker().getId() + "," + pheromone + "]";
  }

  public String trace() {
    return level + "," + getJob() + ",W#" + getWorker().getId() + "," + pheromone;
  }
  
  public double getGradeOfCompetency() {
    AptitudeMembershipFunctions functions = new AptitudeMembershipFunctions();
    double minGrade = Double.MAX_VALUE;
    for (FuzzyAptitude aptitude: getJob().getCompetence().getAptitudeSet()) {
      MembershipFunction f = functions.getMembershipFunction(aptitude.getQuality());
      Aptitude workerAptitude = getWorker().getCompetence().getAptitudeForType(aptitude.getType());
      double grade = Fuzzifier.grade(f, workerAptitude.getScore());
      if (grade<minGrade) minGrade = grade;
    }
    if (minGrade>Double.MAX_VALUE-1) return 0; 
    else return minGrade;
  }
  
  public static double getGradeOfConnectedness(double connectednessScore, Quality quality) {
    ConnectednessMembershipFunctions functions = new ConnectednessMembershipFunctions();
    MembershipFunction f = functions.getMembershipFunction(quality);
    return Fuzzifier.grade(f, connectednessScore);
  }

  public double getPheromone() {
    return pheromone;
  }

  public void setPheromone(double pheromone) {
    this.pheromone = pheromone;
  }

  public long getEstimatedResponseTime() {
    return estimatedResponseTime;
  }

  public void setEstimatedResponseTime(long estimatedResponseTime) {
    this.estimatedResponseTime = estimatedResponseTime;
  }
}
