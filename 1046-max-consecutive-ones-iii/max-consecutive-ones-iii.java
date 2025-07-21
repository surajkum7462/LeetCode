class Solution {
    public int longestOnes(int[] nums, int k) {
        int r=0;
        int l=0;
        int max=0;
        int zero=0;
        int n=nums.length;
        while(r<n)
        {
            if(nums[r]==0)
            {
                zero++;
            }
            if(zero>k)
            {
                if(nums[l]==0)
                {
                    zero--;
                }
                l++;
            }
            if(zero<=k)
            {
                int len = r-l+1;
                max=Math.max(len,max);
               
            }
             r++;
        }
      return max;
    }
}