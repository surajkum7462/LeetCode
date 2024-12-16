class Solution {
    public int findMin(int[] nums) {
       int min=Integer.MAX_VALUE;
       int l=0;
       int r=nums.length-1;

       while(l<=r)
       {
         if(nums[l]<min)
         {
            min=nums[l];
         }
         l++;
       }
        return min;
    }
}