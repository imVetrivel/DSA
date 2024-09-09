package Graph;

import java.util.*;

public class ConnectedComponent {

    public Map<Integer, Node> nodes = new HashMap<>();
    public Map<Node, List<Node>> adjlist = new HashMap<>();

    class Node {

        int n;

        Node(int n) {
            this.n = n;
        }

    }

    public void addNode(int n) {

        Node newnode = new Node(n);
        nodes.putIfAbsent(n, newnode);
        adjlist.putIfAbsent(newnode, new ArrayList<>());

    }

    public void addEdge(int m, int n) {

        Node from = nodes.get(m);
        Node to = nodes.get(n);

        if (from == null)
            return;

        if (to == null)
            return;

        adjlist.get(from).add(to);

    }
   
    public int connect()
    {
        int c = 0;
        Set<Node> set = new HashSet<>();
        for(Node z:adjlist.keySet())
        {
            if(set.containsAll(adjlist.keySet()))
            return c;
            else
            {
                if(!set.contains(z))
                {
                    set = bfs(z,set);
                    c++;
                }
            }
        }
        return c;
    }

    public Set<Node> bfs(Node a,Set<Node> node)
    {

        Queue<Node> q = new LinkedList<>();
        q.add(a);
        while(!q.isEmpty())
        {
            Node x = q.poll();
            for(Node s:adjlist.get(x))
            {
                if(!node.contains(s))
                {
                    node.add(s);
                    q.add(s);
                }
            }
        }
        return node;
    }

    //  find ShortestPath Between two Vertex
    public int ShortestPath(int a,int b)
    {
        Node start = nodes.get(a);
        Node end = nodes.get(b);
        
        int path = Integer.MAX_VALUE;
        
        Set<Node> set = new HashSet<>();
        for(Node z:adjlist.get(start))
        {
            set = bfs(z,end);
            if(set!=null)
            {
            if(set.size() < path)
            path=set.size();
            }
        }
        return path;
    }
    
    public Set<Node> bfs(Node a,Node end)
    {
        Set<Node> set = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        
        set.add(a);
        q.add(a);
        
        if(set.contains(end))
        return set;
        
        while(!q.isEmpty())
        {
            Node z = q.poll();
            for(Node x:adjlist.get(z))
            {
                if(!set.contains(x))
                {
                    set.add(x);
                    q.add(x);
                    if(set.contains(end))
                    return set;
                }
            }
        }
        return null;
    }

    public static void main(String[] args){

        ConnectedComponent c = new ConnectedComponent();

        c.addNode(1);
        c.addNode(2);
        c.addNode(3);
        c.addNode(4);
        c.addNode(5);

        c.addEdge(1,2);
        c.addEdge(2,3);
        c.addEdge(4,5);

        System.out.println(c.connect());

        int path = c.ShortestPath(1, 5);
        if(path == Integer.MAX_VALUE)
            System.out.println("Path Does Not Exists");
        else
            System.out.println(path);
    }



    
}