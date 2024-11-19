class Solution {
    public void rotate(int[][] matrix) {
       int r=matrix.length-1;
       int c=matrix[0].length-1;
       int[][] arr=new int[r+1][c+1];

       for(int i=0;i<=r;i++)
       {
         for(int j=0;j<=c;j++)
         {
            arr[i][j]=matrix[i][j];
         }
       }
       for(int i=0;i<=c;i++)
       {
         for(int j=r;j>=0;j--)
         {
            matrix[i][r-j]=arr[j][i];
         }
       }
        
    }
}