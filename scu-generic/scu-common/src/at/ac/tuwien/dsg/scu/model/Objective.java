package at.ac.tuwien.dsg.scu.model;

import java.util.Hashtable;

public class Objective { 

  private double competencyWeight;
  private double connectednessWeight;
  private double costWeight;
  private double responseTimeWeight;
  
  public Objective() {
  }
  
  public Objective(double competencyWeight, double connectednessWeight, double costWeight, double completionTimeWeight) {
    this.competencyWeight = competencyWeight;
    this.connectednessWeight = connectednessWeight;
    this.responseTimeWeight = completionTimeWeight;
    this.costWeight = costWeight;
  }

  public double getCompetencyWeight() {
    return competencyWeight;
  }

  public void setCompetencyWeight(double competencyWeight) {
    this.competencyWeight = competencyWeight;
  }

  public double getConnectednessWeight() {
    return connectednessWeight;
  }

  public void setConnectednessWeight(double connectednessWeight) {
    this.connectednessWeight = connectednessWeight;
  }

  public double getCostWeight() {
    return costWeight;
  }

  public void setCostWeight(double costWeight) {
    this.costWeight = costWeight;
  }

  public double getResponseTimeWeight() {
    return responseTimeWeight;
  }

  public void setResponseTimeWeight(double responseTimeWeight) {
    this.responseTimeWeight = responseTimeWeight;
  }

  @Override
  public String toString() {
    return "Objective [competencyWeight=" + competencyWeight
        + ", connectednessWeight=" + connectednessWeight + ", costWeight="
        + costWeight + ", responseTimeWeight=" + responseTimeWeight + "]";
  }


}
