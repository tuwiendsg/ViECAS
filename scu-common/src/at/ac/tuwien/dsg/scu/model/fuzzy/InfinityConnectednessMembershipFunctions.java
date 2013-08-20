package at.ac.tuwien.dsg.scu.model.fuzzy;

import at.ac.tuwien.dsg.scu.model.Quality;

public class InfinityConnectednessMembershipFunctions implements MembershipFunctions {

  private static InfinityConnectednessMembershipFunctions functions;
  
  private InfinityTrapezoidalMembershipFunction fPoor = new InfinityTrapezoidalMembershipFunction(Double.MIN_VALUE, Double.MIN_VALUE, 2, 4); 
  private InfinityTrapezoidalMembershipFunction fFair = new InfinityTrapezoidalMembershipFunction(2, 4, 8, 4); 
  private InfinityTrapezoidalMembershipFunction fGood = new InfinityTrapezoidalMembershipFunction(8, 10, 14, 4); 
  private InfinityTrapezoidalMembershipFunction fVGood = new InfinityTrapezoidalMembershipFunction(14, 16, Double.MAX_VALUE, Double.MAX_VALUE); 
  
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
  
  public static InfinityConnectednessMembershipFunctions getInstance() {
    if (functions==null) functions = new InfinityConnectednessMembershipFunctions();
    return functions;
  }

}
