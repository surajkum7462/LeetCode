class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int cnt=1;
        int l=1;
        if(nums.length==0)
        {
            return 0;
        }
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]==nums[i+1])
            {
                continue;
            }
            if(nums[i]+1 == nums[i+1])
            {
                cnt++;
               
            }
            else
            {
                l=Math.max(l,cnt);
                cnt=1;
            }
        }
        return Math.max(l,cnt);
    }
}