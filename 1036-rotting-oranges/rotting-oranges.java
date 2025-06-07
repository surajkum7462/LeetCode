class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0)
        {
            return 0;
        }

        Queue<int[]> q = new LinkedList<>();
        int row=grid.length;
        int col=grid[0].length;
        int cnt_fresh=0;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]==2)
                {
                   q.offer(new int[]{i,j});
                }else if(grid[i][j]==1)
                {
                    cnt_fresh++;
                }
                
            }
        }

        if(cnt_fresh==0)
        {
            return 0;
        }
        int cntMin=0;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        while(!q.isEmpty())
        {
            int size=q.size();
           boolean freshcntInThisRound=false;
           for(int i=0;i<size;i++)
           {
              int[] point = q.poll();
              for(int j=0;j<4;j++)
              {
                 int x = point[0]+dx[j];
                 int y = point[1]+dy[j];
                 if(x<0 || y<0 || x>=row || y>=col || grid[x][y]!=1)
                 {
                    continue;
                 }
                 grid[x][y]=2;
                 cnt_fresh--;
                 q.offer(new int[]{x,y});
                 freshcntInThisRound=true;
              }
              
           }
           if(freshcntInThisRound)
              {
                cntMin++;
              }
        }
        return cnt_fresh==0?cntMin:-1;
        
    }
}