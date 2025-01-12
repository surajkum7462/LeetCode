class Solution {
    public void dfs(int i, ArrayList<ArrayList<Integer>> ans,boolean[] vis)
    {
        vis[i]=true;
       
        for(Integer it:ans.get(i))
        {
            if(vis[it]==false)
            {
                dfs(it,ans,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> ans  = new ArrayList<>();
        for(int i=0;i<isConnected.length;i++)
        {
            ans.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++)
        {
            for(int j=0;j<isConnected[0].length;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                {
                  ans.get(i).add(j);
                  ans.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[isConnected.length+1];
        int cnt = 0;
        for(int i=0;i<isConnected.length;i++)
        {
            if(vis[i]==false)
            {
                cnt++;
                dfs(i,ans,vis);
            }
        }
        return cnt;
    }
}