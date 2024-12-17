class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        long val=(long) m*k;
        int n=bloomDay.length;
        int ans=-1;
        if(val>n)
        {
            return -1;

        }

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
        int l=min;
        int r=max;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(possible(bloomDay,mid,m,k)==true)
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
    private boolean possible(int[] arr,int day,int m,int k)
    {
        int n=arr.length;
        int cnt=0;
        int noOfB=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]<=day)
            {
                cnt++;
            }
            else
            {
                noOfB+=(cnt/k);
                cnt=0;
            }
        }
        noOfB+=(cnt/k);
        return noOfB>=m;
    }
}