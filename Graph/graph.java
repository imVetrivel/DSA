package Graph;
import java.util.*;

public class Graph {
    
   public ArrayList<Integer> l[];
   int n=0;
    public Graph(int n)
    {
        this.n=n+1;
        l=new ArrayList[n+1];
        for(int i=0;i<=n;i++)
        {
            l[i]=new ArrayList<Integer>();
        }
    }

    // insertion
    public void add(int vertex,int edge)
    {
        l[vertex].add(edge);
        l[edge].add(vertex);
    }

    // Breadth first search
    public void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[]=new boolean[n];
        visited[v]=true;
        q.add(v);
        System.out.println(v);
        while(!q.isEmpty())
        {
            v=q.poll();
            for(int i=0;i<l[v].size();i++)
            {
                if(!visited[l[v].get(i)]){
                    System.out.println(l[v].get(i));
                    visited[l[v].get(i)]=true;
                    q.add(l[v].get(i));
                }
            }
        }
    }

    // Depth first search
    public void dfs(int v){
       Stack<Integer> s =new Stack<Integer>();
       boolean visited[]=new boolean[n];
        s.push(v);
        visited[v]=true;
        while(!s.isEmpty())
        {
            v=s.pop();
            for(int i=0;i<l[v].size();i++)
            {
                if(!visited[l[v].get(i)])
                {
                    s.push(l[v].get(i));
                    visited[l[v].get(i)]=true;
                }
            }
            System.out.println(v);
        }
    }

    public static void main(String[] args){
        Scanner ab=new Scanner(System.in);
        int n=ab.nextInt();
        int edge=ab.nextInt();

        Graph g = new Graph(n);
        for(int i=0;i<edge;i++)
        {
           g.add(ab.nextInt(),ab.nextInt());
        }
        
        g.bfs(2);
        g.dfs(2);
        ab.close();
    }
}
