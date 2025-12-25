class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1;
        int cnt=0;
        nums[cnt++]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]!=nums[i])
            {
                nums[cnt++]=nums[i];
                k++;
            }
        }
        return k;
    }
}