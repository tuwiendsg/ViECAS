package at.ac.tuwien.dsg.scu.model;

public class WorkerRelation {
  
  private Worker worker1; // worker1.id<worker2
  private Worker worker2;
  private int weight;
  
  
  public WorkerRelation() {
  }
  
  public WorkerRelation(Worker worker1) {
    this.worker1 = worker1;
    this.worker2 = null;
    this.weight = Integer.MAX_VALUE; // TODO: this max value will depend on our conectedness membership function
  }

  public WorkerRelation(Worker worker1, Worker worker2, int weight) {
    if (worker1.getId()<worker2.getId()) {
      this.worker1 = worker1;
      this.worker2 = worker2;
    } else {
      this.worker1 = worker2;
      this.worker2 = worker1;      
    }
    this.weight = weight;
  }

  public void setWorker1(Worker worker1) {
    this.worker1 = worker1;
  }

  public void setWorker2(Worker worker2) {
    this.worker2 = worker2;
  }

  public Worker getWorker1() {
    return worker1;
  }
  public Worker getWorker2() {
    return worker2;
  }
  public int getWeight() {
    return weight;
  }
  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "WorkerRelation [worker1=" + worker1 + ", worker2=" + worker2
        + ", weight=" + weight + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((worker1 == null) ? 0 : worker1.hashCode());
    result = prime * result + ((worker2 == null) ? 0 : worker2.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    WorkerRelation other = (WorkerRelation) obj;
    if (worker1 == null) {
      if (other.worker1 != null)
        return false;
    } else if (!worker1.equals(other.worker1))
      return false;
    if (worker2 == null) {
      if (other.worker2 != null)
        return false;
    } else if (!worker2.equals(other.worker2))
      return false;
    return true;
  }
  
  
  
}
