class Solution {
     public void dfs(int row,int col,int[] delrow,int[] delcol,int[][] grid,int[][] vis)
    {
        vis[row][col]=1;
        int n=grid.length;
        int m = grid[0].length;
        for(int i=0;i<4;i++)
        {
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1)
            {
                dfs(nrow,ncol,delrow,delcol,grid,vis);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        int n=grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        for(int j=0;j<m;j++)
        {
            // First Row
            if(grid[0][j]==1 && vis[0][j]==0)
            {
                dfs(0,j,delrow,delcol,grid,vis);
            }

            // Last Row
             if(grid[n-1][j]==1 && vis[n-1][j]==0)
            {
                dfs(n-1,j,delrow,delcol,grid,vis);
            }



        }

        for(int i=0;i<n;i++)
        {
            if(grid[i][0]==1 && vis[i][0]==0)
            {
                dfs(i,0,delrow,delcol,grid,vis);
            }

             if(grid[i][m-1]==1 && vis[i][m-1]==0)
            {
                dfs(i,m-1,delrow,delcol,grid,vis);
            }

        }
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                {
                    cnt++;
                }
            }
        }
        return cnt;
        
    }
}