class Solution {
    public int max(int[] arr)
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            max=Math.max(arr[i],max);
        }
        return max;
    }
    public int findCeil(int[] arr,int hourly)
    {
        int totalHour=0;
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            totalHour+=Math.ceil((double)(arr[i])/(double)(hourly));
        }
        return totalHour;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=max(piles);
        while(l<=r)
        {
            int mid=(l+r)/2;
            int totalHour=findCeil(piles,mid);
            if(totalHour<=h)
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return l;
    }
}