package at.ac.tuwien.dsg.scu.model;

import at.ac.tuwien.dsg.scu.model.fuzzy.MembershipFunction;

public class Fuzzifier {

  public static double grade(MembershipFunction f, double numericQuality) {
    return f.grade(numericQuality);
  }
}
