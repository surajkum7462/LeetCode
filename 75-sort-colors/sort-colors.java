class Solution {
    public void sortColors(int[] nums) {
        int mid = 0;
        int low=0;

        int r=nums.length-1;
        while(mid<=r)
        {
            if(nums[mid]==0)
            {
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(nums[mid]==1)
            {
                mid++;
            }
            else

            {
                swap(nums,mid,r);
                r--;
            }
        }

      

    }

    public void swap(int[] nums,int low,int high)
    {
        int temp=nums[low];
        nums[low]=nums[high];
        nums[high]=temp;
    }

    
}