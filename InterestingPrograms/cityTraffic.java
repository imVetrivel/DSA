package InterestingPrograms;

import java.util.*;

public class cityTraffic {
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
		if(!nodes.containsKey(n))
		{
        nodes.putIfAbsent(n, newnode);
        adjlist.putIfAbsent(newnode, new ArrayList<>());
		}

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

	public int bfs(int n)
	{
		ArrayList<Integer> l = new ArrayList<>();

		Node t = nodes.get(n);

		for(Node r:adjlist.get(t))
		{
			l.add(bfs(r,t));
		}
		// System.out.println(l);
		return Collections.max(l);
	}

	public int bfs(Node st,Node t)
	{
		Queue<Node> q = new LinkedList<>();
		Set<Node> set = new HashSet<>(adjlist.get(t));
		q.add(st);
		set.add(st);
		q.add(t);
		set.add(t);
		int sum = st.n;

		while(!q.isEmpty())
		{
			Node x = q.poll();
			for(Node r:adjlist.get(x))
			{
				if(!set.contains(r))
				{
					sum+=r.n;
					set.add(r);
					q.add(r);
				}
			}
		}
		return sum;
	}

	public static void main(String[] args)
	{
		cityTraffic c = new cityTraffic();

		c.addNode(1);
		c.addNode(2);
		c.addNode(3);
		c.addNode(4);
		c.addNode(5);

		c.addEdge(1, 5);
		c.addEdge(2, 5);
		c.addEdge(3, 5);
		c.addEdge(4, 5);
		c.addEdge(5, 1);
		c.addEdge(5, 2);
		c.addEdge(5, 3);
		c.addEdge(5, 4);

		for(int i = 1;i<6;i++)
		System.out.println(i+" "+c.bfs(i));

		// System.out.println(c.nodes.size());
	}
}
