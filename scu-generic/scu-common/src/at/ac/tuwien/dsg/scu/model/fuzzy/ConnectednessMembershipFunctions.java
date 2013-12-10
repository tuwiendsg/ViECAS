package at.ac.tuwien.dsg.scu.model.fuzzy;

import at.ac.tuwien.dsg.scu.model.Quality;

public class ConnectednessMembershipFunctions implements MembershipFunctions {

  private static ConnectednessMembershipFunctions functions;
  
  private InfinityTrapezoidalMembershipFunction fPoor = new InfinityTrapezoidalMembershipFunction(Double.MIN_VALUE, Double.MIN_VALUE, 0.5, 1.0); 
  private InfinityTrapezoidalMembershipFunction fFair = new InfinityTrapezoidalMembershipFunction(0.50, 0.61, 0.69, 1.0); 
  private InfinityTrapezoidalMembershipFunction fGood = new InfinityTrapezoidalMembershipFunction(0.69, 0.76, 0.84, 1.0); 
  private InfinityTrapezoidalMembershipFunction fVGood = new InfinityTrapezoidalMembershipFunction(0.84, 0.90, Double.MAX_VALUE, Double.MAX_VALUE); 
  
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
  
  public static ConnectednessMembershipFunctions getInstance() {
    if (functions==null) functions = new ConnectednessMembershipFunctions();
    return functions;
  }

}
