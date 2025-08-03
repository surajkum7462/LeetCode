class Solution {
    public void rotate(int[][] matrix) {
       int n=matrix.length;
       int m=matrix[0].length;
       for(int i=0;i<n;i++)
       {
          for(int j=i+1;j<m;j++)
          {
             int temp=matrix[i][j];
             matrix[i][j]=matrix[j][i];
             matrix[j][i]=temp;
          }
       }

       for(int i=0;i<n;i++)
       {
         reverse(matrix[i]);
       }
    }

    public void reverse(int[] matrix)
    {
        int l=0;
        int r=matrix.length-1;
        while(l<=r)
        {
            int temp=matrix[l];
            matrix[l]=matrix[r];
            matrix[r]=temp;
            l++;
            r--;
        }
    }
}