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
                    c++;
                    set = bfs(z,set);
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
    }
}
