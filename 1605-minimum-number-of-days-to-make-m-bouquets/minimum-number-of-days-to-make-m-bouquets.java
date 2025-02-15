class Solution {
    public int min(int arr[])
    {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            min=Math.min(arr[i],min);
        }
        return min;
    }
     public int max(int arr[])
    {
        int min=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            min=Math.max(arr[i],min);
        }
        return min;
    }
    public boolean possible(int[] arr,int day,int m,int k)
    {
        int cnt=0;
        int noOfBucket=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<=day)
            {
                cnt++;
            }
            else
            {
                noOfBucket+=cnt/k;
                cnt=0;
            }
        }
        noOfBucket+=cnt/k;
        return noOfBucket>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low = min(bloomDay);
        int high=max(bloomDay);
        int n=bloomDay.length;
        long val=(long)m*k;
        int ans=high;
        if(n<val)
        {
            return -1;
        }
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(possible(bloomDay,mid,m,k)==true)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
}