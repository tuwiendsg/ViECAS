package at.ac.tuwien.dsg.scu.model;

public class Aptitude {
  private String type;
  private double score;
  public Aptitude() {
  }
  public Aptitude(String type, double score) {
    this.type = type;
    this.score = score;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public double getScore() {
    return score;
  }
  public void setScore(double score) {
    this.score = score;
  }
  @Override
  public String toString() {
    return "[type=" + type + ", score=" + score
        + "]";
  }
  
}
