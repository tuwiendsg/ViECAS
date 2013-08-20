package at.ac.tuwien.dsg.scu.model.fuzzy;

import at.ac.tuwien.dsg.scu.model.Quality;

public class AptitudeMembershipFunctions implements MembershipFunctions {

  private static AptitudeMembershipFunctions functions;
  
  private TrapezoidalMembershipFunction fPoor = new TrapezoidalMembershipFunction(Double.MIN_VALUE, Double.MIN_VALUE, 0.5, 1.0); 
  private TrapezoidalMembershipFunction fFair = new TrapezoidalMembershipFunction(0.50, 0.61, 0.69, 1.0); 
  private TrapezoidalMembershipFunction fGood = new TrapezoidalMembershipFunction(0.69, 0.76, 0.84, 1.0); 
  private TrapezoidalMembershipFunction fVGood = new TrapezoidalMembershipFunction(0.84, 0.90, Double.MAX_VALUE, Double.MAX_VALUE); 
  
  @Override
  public MembershipFunction getMembershipFunction(Quality quality) {
    switch (quality) {
      case POOR: return fPoor;
      case FAIR: return fFair;
      case GOOD: return fGood;
      case VERY_GOOD: return fVGood;
      default: return null; 
    }
  }
  
  public static AptitudeMembershipFunctions getInstance() {
    if (functions==null) functions = new AptitudeMembershipFunctions();
    return functions;
  }

}
