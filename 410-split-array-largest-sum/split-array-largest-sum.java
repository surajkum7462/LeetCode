class Solution {
    public int sum(int[] arr)
    {
        int sum=0;
        for(int n:arr)
        {
            sum+=n;
        }
        return sum;
    }
    public int max(int[] arr)
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            max=Math.max(arr[i],max);
        }
        return max;
    }
    public int count(int arr[] , int sum)
    {
        int sub=1;
        int noSum=0;
        for(int i=0;i<arr.length;i++)
        {
            if(noSum+arr[i]<=sum)
            {
                noSum+=arr[i];
            }
            else
            {
                sub++;
                noSum=arr[i];
            }
        }
        return sub;
    }
    public int splitArray(int[] nums, int k) {
        int low=max(nums);
        int high=sum(nums);
        if(nums.length<k)
        {
            return -1;
        }
        while(low<=high)
        {
            int mid=(low+high)/2;
            int sum=count(nums,mid);
            if(sum>k)
            {
                low=mid+1;

            }
            else
            {
                high=mid-1;
            }
        }
        return low;
        
    }
}