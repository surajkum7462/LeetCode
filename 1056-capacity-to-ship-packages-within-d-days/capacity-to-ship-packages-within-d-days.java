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
    public int sum(int arr[])
    {
        int ans=0;
        for(int i=0;i<arr.length;i++)
        {
            ans+=arr[i];
        }
        return ans;
    }
    public int possible(int arr[] , int cap)
    {
        int days=1;
        int load=0;
        for(int i=0;i<arr.length;i++)
        {
            if(load+arr[i]>cap)
            {
                days++;
                load=arr[i];
            }
            else
            {
                load+=arr[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=max(weights);
        int high = sum(weights);
        while(low<=high)
        {
            int mid=(low+high)/2;
            int dayRe=possible(weights,mid);
            if(dayRe<=days)
            {
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