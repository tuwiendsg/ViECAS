package at.ac.tuwien.dsg.scu.model;

import java.util.ArrayList;

public class FuzzyCompetence {

  private ArrayList<FuzzyAptitude> aptitudeSet;

  public FuzzyCompetence() {
    aptitudeSet = new ArrayList<FuzzyAptitude>();
  }

  public String toString() {
    String result = "";
    for (FuzzyAptitude a : aptitudeSet) {
      if (!result.equals("")) result += ",";
      result += a;
    }
    result = "{" + result + "}";
    return result;
  }

  public ArrayList<FuzzyAptitude> getAptitudeSet() {
    return aptitudeSet;
  }

  public void setAptitudeSet(ArrayList<FuzzyAptitude> aptitudeSet) {
    this.aptitudeSet = aptitudeSet;
  }

}
