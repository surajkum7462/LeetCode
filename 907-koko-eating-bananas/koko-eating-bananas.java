class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int l=1;
        int r=max(piles);
        int ans=-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            int totalHours=ceil(piles,mid);
            if(totalHours<=h)
            {
                ans=mid;
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return ans;
    }
    private int max(int[] arr)
    {
        int n=arr.length;
        int max=arr[0];
        for(int i=0;i<n;i++)
        {
            if(arr[i]>=max)
            {
                max=arr[i];
            }
        }
        return max;
    }
    private int ceil(int[] piles,int h)
    {
        int totalH=0;
        int n=piles.length;
        for(int i=0;i<n;i++)
        {
            totalH+=Math.ceil((double)(piles[i])/(double)(h));
        }
        return totalH;
    }
}