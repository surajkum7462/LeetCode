class Solution {
    
     public int max(int arr[])
    {
        int min=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            min=Math.max(arr[i],min);
        }
        return min;
    }
    public int findCeil(int[] arr,int val)
    {
        int ans=0;
        for(int i=0;i<arr.length;i++)
        {
             ans+=Math.ceil((double)arr[i]/(double)val);
           
        }
        return ans;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=max(nums);
        while(low<=high)
        {
            int mid=(low+high)/2;
            int result=findCeil(nums,mid);
            if(result<=threshold)
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