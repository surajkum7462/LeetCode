class Solution {
    public int[] sortedSquares(int[] nums) {

     int n=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=nums[i]*nums[i];
        }

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(nums[j]<nums[i])
                {
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        return nums;
    }
}