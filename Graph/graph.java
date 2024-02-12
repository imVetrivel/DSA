package Graph;
import java.util.*;
public class Graph {
    
   public ArrayList<Integer> l[];
    public Graph(int n)
    {
        l=new ArrayList[n];
        for(int i=0;i<n;i++)
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
    public void bfs(int node){
        
    }

    // Depth first search
    public void dfs(int node){

    }
}
