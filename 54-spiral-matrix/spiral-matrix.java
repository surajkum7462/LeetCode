class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int minCol=0;
        int maxCol=n-1;
        int minRow=0;
        int maxRow=m-1;
        List<Integer> ans = new ArrayList<>();
        while(minCol<=maxCol && minRow<=maxRow)
        {
           for(int i=minCol;i<=maxCol;i++)
           {
              ans.add(matrix[minRow][i]);
           }
           minRow++;
           for(int i=minRow;i<=maxRow;i++)
           {
              ans.add(matrix[i][maxCol]);
           }
           maxCol--;
           if(minRow<=maxRow)
           {
             for(int i=maxCol;i>=minCol;i--)
             {
                 ans.add(matrix[maxRow][i]);
             }
             maxRow--;
           }
           if(minCol<=maxCol)
           {
             for(int i=maxRow;i>=minRow;i--)
             {
                 ans.add(matrix[i][minCol]);
             }
             minCol++;
           }
        }
        return ans;
    }
}