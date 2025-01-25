class Solution {
    public void nextPermutation(int[] nums) {
        int indx=-1;
        int n = nums.length;

        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                indx=i;
                break;
            }
        }
        if(indx==-1)
        {
            reverse(nums,0,n-1);
            return;
            
        }
        for(int i=n-1;i>indx;i--)
        {
            if(nums[i]>nums[indx])
            {
                swap(nums,i,indx);
                break;
            }
        }
        reverse(nums,indx+1,n-1);
    }
    public void swap(int[] arr , int l , int r)
    {
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
    public void reverse(int[] nums ,int l , int r)
    {
        
        while(l<=r)
        {
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
}