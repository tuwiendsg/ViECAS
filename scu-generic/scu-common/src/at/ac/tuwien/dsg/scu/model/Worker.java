package at.ac.tuwien.dsg.scu.model;

public class Worker {

  private long id;
  private Competence competence;
  private Queue queue;
  private double cost;
  
  public Worker() {
  }
  public Worker(long id) {
    this.id = id;
  }

  public Worker(long id, Competence competence, Queue queue, double cost) {
    this.id = id;
    this.competence = competence;
    this.queue = queue;
    this.cost = cost;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Competence getCompetence() {
    return competence;
  }

  public void setCompetence(Competence competence) {
    this.competence = competence;
  }

  public Queue getQueue() {
    return queue;
  }

  public void setQueue(Queue queue) {
    this.queue = queue;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  @Override
  public String toString() {
    return "Worker [id=" + id + ", competence=" + competence + ", queue=" + queue + ", cost=" + cost + "]";
    //return "W[" + id + "]";
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
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
    Worker other = (Worker) obj;
    if (id != other.id)
      return false;
    return true;
  }
  
  
  
}
