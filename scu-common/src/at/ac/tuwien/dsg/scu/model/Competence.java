package at.ac.tuwien.dsg.scu.model;

import java.util.ArrayList;

public class Competence {
  
  private ArrayList<Aptitude> aptitudeSet;

  public Competence() {
    aptitudeSet = new ArrayList<Aptitude>();
  }

  public ArrayList<Aptitude> getAptitudeSet() {
    return aptitudeSet;
  }

  public void setAptitudeSet(ArrayList<Aptitude> aptitudeSet) {
    this.aptitudeSet = aptitudeSet;
  }
  
  public String toString() {
    String result = "";
    for (Aptitude a : aptitudeSet) {
      if (!result.equals("")) result += ",";
      result += a;
    }
    result = "{" + result + "}";
    return result;
  }
  
  public Aptitude getAptitudeForType(String type) {
    Aptitude found = null;
    int i = 0;
    while (i<aptitudeSet.size() && found==null) {
      Aptitude a = aptitudeSet.get(i);
      if (a.getType().equals(type)) found = a;
      else i++;
    }
  return found;
  }
  
}
