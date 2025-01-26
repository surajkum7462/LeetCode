class Solution {
    public void rotate(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {  // FIXED: j starts from i+1
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<m;i++)
        {
            reverse(matrix[i]);
        }
    }
    public void reverse(int[] arr)
    {
        int l=0;
        int r=arr.length-1;
        while(l<r)
        {
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }
}