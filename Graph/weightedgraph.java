package Graph;

import java.util.*;

public class weightedgraph {

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

    weightedgraph w = new weightedgraph();
    w.addNode("A");
    w.addNode("B");
    w.addNode("C");

    w.addEdge("A", "C");
    w.addEdge("A", "B");
    w.addEdge("A", "A");
    // w.print();
    w.dfs("A");
    }


    // depthfirst search
    public void dfs(String n)
    {
        Node node = nodes.get(n);
        if(node == null)
        return;
        dfs(node,new HashSet<>());
    }

    public void dfs(Node n,Set<Node> node)
    {
        System.out.println(n);
        node.add(n);

        for(Node a: adjacencylist.get(n))
        {
            if(! node.contains(a))
            {
                dfs(a,node);
            }
        }
    }


    //  public void bfs(int v){
    //     Queue<Integer> q = new LinkedList<>();
    //     boolean visited[]=new boolean[n];
    //     visited[v]=true;
    //     q.add(v);
    //     System.out.println(v);
    //     while(!q.isEmpty())
    //     {
    //         v=q.poll();
    //         for(int i=0;i<l[v].size();i++)
    //         {
    //             if(!visited[l[v].get(i)]){
    //                 System.out.println(l[v].get(i));
    //                 visited[l[v].get(i)]=true;
    //                 q.add(l[v].get(i));
    //             }
    //         }
    //     }
    // }

}
