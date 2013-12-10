package at.ac.tuwien.dsg.scu.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import org.jgrapht.graph.ListenableUndirectedWeightedGraph;
import org.jgrapht.graph.Subgraph;

public class ConnectednessGraph extends ListenableUndirectedWeightedGraph<Worker, RelationEdge> {

  private static final long serialVersionUID = 6477319124372736025L;

  Hashtable<Long, Worker> workers;
  
  public ConnectednessGraph() {
    super(RelationEdge.class);
  }
  
  public ConnectednessGraph(Class<? extends RelationEdge> arg0) {
    super(arg0);
  }

  public Hashtable<Long, Worker> getWorkers() {
    return workers;
  }

  public void setWorkers(Hashtable<Long, Worker> workers) {
    this.workers = workers;
  }
  
  public static ConnectednessGraph generate(ArrayList<WorkerRelation> relations) {

    ConnectednessGraph cg = new ConnectednessGraph();
    cg.setWorkers(new Hashtable<Long, Worker>());
    
    for (WorkerRelation r: relations) {
    
      Worker w1;
      Worker w2;
      
      // worker 1
      if (cg.getWorkers().containsKey(r.getWorker1().getId())) {
        w1 = cg.getWorkers().get(r.getWorker1().getId());
      } else {
        w1 = new Worker(r.getWorker1().getId());
        cg.getWorkers().put(r.getWorker1().getId(), w1);
        cg.addVertex(w1);
      }

      if (r.getWorker2()!=null) {
        
        // worker 2
        if (cg.getWorkers().containsKey(r.getWorker2().getId())) {
          w2 = cg.getWorkers().get(r.getWorker2().getId());
        } else {
          w2 = new Worker(r.getWorker2().getId());
          cg.getWorkers().put(r.getWorker2().getId(), w2);
          cg.addVertex(w2);
        }

        // define edge
        double weight = 0;
        RelationEdge edge = cg.getEdge(w1, w2);
        if (edge==null) edge = cg.addEdge(w1, w2);
        else weight = cg.getEdgeWeight(edge);
        cg.setEdgeWeight(edge, weight + r.getWeight()); // *ADD* if already exists
        
      }
      
      // else, only vertex w1 is added
    }
    
    return cg;
  }
  
  public Subgraph<Worker, RelationEdge, ConnectednessGraph> getSubgraphFromWorker(ArrayList<Worker> workers) {
    
    // generate vertex set
    HashSet<Worker> workerSet = new HashSet<Worker>();
    for (Worker w: workers) {
      if (getWorkers().containsKey(w.getId())) {
        workerSet.add(getWorkers().get(w.getId()));
      }
    }

    // return subgraph
    return new Subgraph<Worker, RelationEdge, ConnectednessGraph>(this, workerSet);
    
  }
  
  public Subgraph<Worker, RelationEdge, ConnectednessGraph> getSubgraphFromSolution(Solution solution) {
    
    // generate vertex set
    HashSet<Worker> workerSet = new HashSet<Worker>();
    for (SolutionComponent s: solution.getList()) {
      if (getWorkers().containsKey(s.getWorker().getId())) {
        workerSet.add(getWorkers().get(s.getWorker().getId()));
      }
    }

    // return subgraph
    return new Subgraph<Worker, RelationEdge, ConnectednessGraph>(this, workerSet);
    
  }

  public double _getConnectedness() {
    double sum = 0;
    Set<RelationEdge> edges = edgeSet();
    for (RelationEdge e: edges) {
      sum += getEdgeWeight(e);
    }
    return sum;
  }
  
  public double _getConnectedness(Subgraph<Worker, RelationEdge, ConnectednessGraph> subgraph) {
    double sum = 0;
    Set<RelationEdge> edges = subgraph.edgeSet();
    for (RelationEdge e: edges) {
      sum += subgraph.getEdgeWeight(e);
    }
    return sum;
  }
  
  public double getConnectedness(Solution solution) {
    // get worker id set
    HashSet<Long> workerSet = new HashSet<Long>();
    for (SolutionComponent s: solution.getList()) {
      if (getWorkers().containsKey(s.getWorker().getId())) {
        workerSet.add(s.getWorker().getId());
      }
    }
    // iterate all edges
    double sum = 0;
    Set<RelationEdge> edges = edgeSet();
    for (RelationEdge e: edges) {
      if (workerSet.contains(getEdgeSource(e).getId()) && workerSet.contains(getEdgeTarget(e).getId())) {
        sum += getEdgeWeight(e);
      }      
    }
    return sum / solution.getList().size();
  }
  
  public double getConnectedness(ArrayList<Worker> workers) {
    // iterate all edges
    double sum = 0;
    Set<RelationEdge> edges = edgeSet();
    for (RelationEdge e: edges) {
      if (workers.contains(getEdgeSource(e)) && workers.contains(getEdgeTarget(e))) {
        sum += getEdgeWeight(e);
      }      
    }
    return sum / workers.size();
    
  }
  
  public double getDeltaConnectedness(Solution solution, Worker worker) {
    // iterate all edges
    double sum = 0;
    for (SolutionComponent comp: solution.getList()) {
      RelationEdge edge = getEdge(worker, comp.getWorker());
      if (edge!=null) {
        sum += getEdgeWeight(edge);
      }
    }
    return sum / (solution.getList().size()+1);
  }
}
