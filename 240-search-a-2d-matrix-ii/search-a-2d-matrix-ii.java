class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
            int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++)
        {
            if(isPresent(matrix[i],target))
            {
                return true;
            }
        }
        return false;
    }
    public boolean isPresent(int[] arr,int x)
    {
        int l=0;
        int r=arr.length-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(arr[mid]==x)
            {
                return true;
            }
            else if(arr[mid]<x)
            {
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
        }
        return false;
    }
}