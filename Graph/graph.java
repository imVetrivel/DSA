package Graph;

import java.util.*;

public class Graph {

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node,List<Node>> adjacencylist = new HashMap<>();

    public class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        // @Override
        public String toString() {
            return label;
        }                
    }

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencylist.putIfAbsent(node,new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode == null) {
            System.out.println("Node does not exists");
            return;
        }
        if (toNode == null) {
            System.out.println("Node does not exists");
            return;
        }
        // directed graph
        adjacencylist.get(fromNode).add(toNode);
    }

    public void print()
    {
        for(Node source:adjacencylist.keySet())
        {
           if( !adjacencylist.get(source).isEmpty())          
        System.out.println(source.label+" is connected to "+adjacencylist.get(source));
            
        }
    }

    public static void main(String[] args){
    // Scanner ab = new Scanner(System.in);

    Graph w = new Graph();
    w.addNode("A");
    w.addNode("B");
    w.addNode("C");
    w.addNode("D");
    w.addNode("E");
    w.addNode("F");

    w.addEdge("A", "C");
    w.addEdge("A", "B");
    w.addEdge("B", "C");
    w.addEdge("E", "F");
    w.addEdge("D", "F");
    w.addEdge("A", "D");
    w.addEdge("A", "F");
    // w.addEdge("A", "A");
    // w.print();
    w.dfs("D");
    System.out.println();
    w.bfs("D");
    }


    // DepthFirst Search
    public void dfs(String n)
    {
        Node node = nodes.get(n);
        if(node == null)
        return;
        dfs(node,new HashSet<>());
    }

    public void dfs(Node n,Set<Node> node)
    {
        System.out.print(n+" ");
        node.add(n);

        for(Node a: adjacencylist.get(n))
        {
            if(! node.contains(a))
            {
                dfs(a,node);
            }
        }
    }
    
    // BreadthFirst Search
    public void bfs(String s)
    {
        Node temp = nodes.get(s);

        if(temp == null)
        {
            return;
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(temp);
        visited.add(temp);
        System.out.print(temp.label+" ");
        while(!q.isEmpty())
        {
            Node x = q.poll();
            for(Node r:adjacencylist.get(x))
            {
                if(!visited.contains(r))
                {
                    System.out.print(r.label+" ");
                    q.add(r);
                    visited.add(r);
                }
                // System.out.println(visited);
            }
        }
    }

}
