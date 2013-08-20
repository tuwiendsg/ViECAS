package at.ac.tuwien.dsg.scu.model;

public class FuzzyAptitude {
  
  private String type;
  private Quality quality;
  public FuzzyAptitude() {
  }
  public FuzzyAptitude(String type, Quality quality) {
    this.setType(type);
    this.quality = quality;
  }
  public Quality getQuality() {
    return quality;
  }
  public void setQuality(Quality quality) {
    this.quality = quality;
  }
  @Override
  public String toString() {
    return "[type=" + getType() + ", quality=" + quality
        + "]";
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  
}
