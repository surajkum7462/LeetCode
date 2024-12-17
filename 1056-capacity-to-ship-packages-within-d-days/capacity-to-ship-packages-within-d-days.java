class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int l=max(weights);
        int r=sum(weights);

        while(l<=r)
        {
            int mid=(l+r)/2;
            int cap=dayReq(weights,mid);
            if(cap<=days)
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
    private int dayReq(int[] arr,int cap)
    {
        int days=1;
      int  load=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]+load>cap)
            {
                days=days+1;
                load=arr[i];
            }
            else
            {
                load+=arr[i];
            }
        }
        return days;
    }
    private int max(int[] arr)
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            max=Math.max(max,arr[i]);
        }
        return max;
    }
    private int sum(int[] arr)
    {
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        return sum;
    }

}