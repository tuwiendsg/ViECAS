package at.ac.tuwien.dsg.scu.model;

public class Queue {
  
  private String sequence;

  public Queue() {
  }
  public Queue(String sequence) {
    this.sequence = sequence;
  }
  public String getSequence() {
    return sequence;
  }
  public void setSequence(String queue) {
    this.sequence = queue;
  }
  @Override
  public String toString() {
    //return "Queue [sequence=" + sequence + "]";
    return sequence;
  }
  
}
