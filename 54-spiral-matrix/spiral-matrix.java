class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        int minCol=0;
        int maxCol=matrix[0].length-1;
        int minRow=0;
        int maxRow=matrix.length-1;
        while(minRow<=maxRow && minCol<=maxCol)
        {
            for(int i=minCol;i<=maxCol;i++)
            {
                list.add(matrix[minRow][i]);
            }
            minRow++;
            for(int i=minRow;i<=maxRow;i++)
            {
                list.add(matrix[i][maxCol]);
            }
            maxCol--;
            if(minRow<=maxRow){
            for(int i=maxCol;i>=minCol;i--)
            {
                list.add(matrix[maxRow][i]);
            }
            maxRow--;
        }
       if(minCol<=maxCol)
       {
         for(int i=maxRow;i>=minRow;i--)
         {
            list.add(matrix[i][minCol]);
         }
         minCol++;
       }

        }
        return list;
    }
}