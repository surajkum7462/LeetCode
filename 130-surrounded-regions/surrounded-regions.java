class Solution {
    public void dfs(int row,int col,int[] delrow,int[] delcol,char[][] board,int[][] vis)
    {
        vis[row][col]=1;
        int n=board.length;
        int m = board[0].length;
        for(int i=0;i<4;i++)
        {
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && board[nrow][ncol]=='O')
            {
                dfs(nrow,ncol,delrow,delcol,board,vis);
            }
        }
    }


    public void solve(char[][] board) {

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        int n=board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];
        for(int j=0;j<m;j++)
        {
            // First Row
            if(board[0][j]=='O' && vis[0][j]==0)
            {
                dfs(0,j,delrow,delcol,board,vis);
            }

            // Last Row
             if(board[n-1][j]=='O' && vis[n-1][j]==0)
            {
                dfs(n-1,j,delrow,delcol,board,vis);
            }



        }

        for(int i=0;i<n;i++)
        {
            if(board[i][0]=='O' && vis[i][0]==0)
            {
                dfs(i,0,delrow,delcol,board,vis);
            }

             if(board[i][m-1]=='O' && vis[i][m-1]==0)
            {
                dfs(i,m-1,delrow,delcol,board,vis);
            }

        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='O' && vis[i][j]==0)
                {
                    board[i][j]='X';
                }
            }
        }
        
    }
}