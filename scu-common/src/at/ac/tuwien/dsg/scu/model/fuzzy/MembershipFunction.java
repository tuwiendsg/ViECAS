package at.ac.tuwien.dsg.scu.model.fuzzy;

public interface MembershipFunction {

  public double lowerBound();
  public double upperBound();
  public double grade(double numericQuality);
  
}
