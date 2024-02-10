package Graph;

import java.util.*;
class graph
{
    int n=0;
    public LinkedList<Integer> adj[];
    graph(int n)
    {
        this.n=n;
        adj=new LinkedList[n];
        for(int i=0;i<n;i++)
        {
            adj[i]=new LinkedList<Integer>();
        }
    }
    public void addedge(int v,int e)
    {
        adj[v].add(e);
    }

    // BFS
    public void bfs(int v)
    {
        Queue<Integer> q=new LinkedList<Integer>();
        boolean vis[]=new boolean[n];
        q.add(v);
        vis[v]=true;
        System.out.print(v+" ");
        while(!q.isEmpty())
        {
            v=q.poll();
            for(int i=0;i<adj[v].size();i++)
            {
                if(!vis[adj[v].get(i)])
                {
                    System.out.print(adj[v].get(i)+" ");
                    q.add(adj[v].get(i));
                    vis[adj[v].get(i)]=true;
                }
            }
        }
        System.out.println();
    }

    // DFS
    public void dfs(int v)
    {
        Stack<Integer> s=new Stack<Integer>();
        boolean vis[]=new boolean[n];
        s.push(v);
        vis[v]=true;
        while(!s.isEmpty())
        {
            v=s.pop();
            for(int i=0;i<adj[v].size();i++)
            {
                if(!vis[adj[v].get(i)])
                {
                    s.push(adj[v].get(i));
                    vis[adj[v].get(i)]=true;
                }
            }
            System.out.print(v+" ");
        }
        System.out.println();
    }
}
 class Main 
{
    public static void main(String[] args)
    {
        graph g=new graph(5);
        g.addedge(0,1);
        g.addedge(0,2);
        g.addedge(1,2);
        g.addedge(2,0);
        g.addedge(2,3);
        g.addedge(3,3);
        g.addedge(4,2);     
        g.bfs(2);
        g.dfs(2);
 }
}
