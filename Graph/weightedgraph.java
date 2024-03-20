package Graph;

import java.util.*;

public class weightedgraph {

   class Node
   {
    int n;
    List<Edge> edges = new ArrayList<>();
    Node(int n)
    {
        this.n = n;
    }

    public void addEdge(Node t,int weight)
    {
      edges.add(new Edge(this,t,weight));
    }

    public List<Edge> getEdges()
    {
      return edges;
    }
   }

   public Map<Integer,Node> nodes = new HashMap<>();
   
   class Edge
   {
    Node from;
    Node to;
    int weight;
    Edge(Node from,Node to,int weight)
    {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
   }

   public void addNode(int n)
   {
     nodes.putIfAbsent(n,new Node(n));
   }

   public void addEdge(int from, int to, int weight)
   {
    Node f = nodes.get(from);
    Node t = nodes.get(to);

    if(f == null)
    return;
    if(t == null)
    return;

    f.addEdge(t, weight);

   }

   public static void main(String[] args){
    Scanner ab=new Scanner(System.in);
    weightedgraph w = new weightedgraph();
    System.out.println(w.nodes);
    ab.close();
   }

}
