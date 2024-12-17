class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int l=0;
        int r=m-1;

        while(l<=r)
        {
            int mid=(l+r)/2;
            int maxRowIndex=findMaxIndex(mat,n,m,mid);
            int left=mid-1>=0 ? mat[maxRowIndex][mid-1]:-1;
            int right=mid+1<m ? mat[maxRowIndex][mid+1]:-1;

            if(mat[maxRowIndex][mid]>left && mat[maxRowIndex][mid]>right)
            {
                return new int[]{maxRowIndex,mid};
            }
            else if(mat[maxRowIndex][mid]<left)
            {
                r=mid-1;

            }
            else
            {
                l=mid+1;
            }
        }

        return new int[]{-1,-1};
    }
    private int findMaxIndex(int[][] mat,int n,int m,int col)
    {
        int maxVal=-1;
        int index=-1;
        for(int i=0;i<n;i++)
        {
            if(mat[i][col]>maxVal)
            {
                maxVal=mat[i][col];
                index=i;
            }
        }
        return index;
    }
}