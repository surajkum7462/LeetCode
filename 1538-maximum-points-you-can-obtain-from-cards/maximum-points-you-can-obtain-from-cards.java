class Solution {
    public int maxScore(int[] nums, int k) {
   int n=nums.length;
        int total=0;
        for(int i=0;i<k;i++)
        {
            total+=nums[i];
        }
        int maxScore=total;

        for(int i=1;i<=k;i++)
        {
            total-=nums[k-i];
            total+=nums[n-i];
            maxScore=Math.max(total,maxScore);
        }
        return maxScore;
    }
}