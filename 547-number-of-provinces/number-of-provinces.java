class Solution {
    public  void dfs(int node,ArrayList<ArrayList<Integer>> adjL,int[] vis)
    {
        vis[node]=1;
        for(int it:adjL.get(node))
        {
            if(vis[it]==0)
            {
                vis[it]=1;
                dfs(it,adjL,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {

       

     int V=isConnected.length;

        ArrayList<ArrayList<Integer>> adjL = new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            adjL.add(new ArrayList<>());
        }
        
        
        
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                {
                    adjL.get(i).add(j);
                    adjL.get(j).add(i);
                }
            }
        }
        
        int cnt=0;
        int[] vis = new int[V];
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                cnt++; 
                dfs(i,adjL,vis);
            }
        }
        return cnt;

        
    }
}