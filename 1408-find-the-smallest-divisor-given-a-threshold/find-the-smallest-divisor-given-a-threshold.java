class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l=1;
        int r=max(nums);

        while(l<=r)
        {
            int mid=(l+r)/2;
            if(sumOfD(nums,mid)<=threshold)
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
    private int max(int[] arr)
    {
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            maxi=Math.max(maxi,arr[i]);
        }
        return maxi;
    }
    private int sumOfD(int[] arr,int mid)
    {
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
          sum+=Math.ceil((double)(arr[i])/(double)mid);
        }
        return sum;
    }
}