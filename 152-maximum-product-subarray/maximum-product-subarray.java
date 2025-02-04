class Solution {
    public int maxProduct(int[] nums) {
        int mul=1;
        int max=Integer.MIN_VALUE;

        int n=nums.length;

        for(int i=0;i<n;i++)
        {
            mul=1;
            for(int j=i;j<n;j++)
            {
                mul*=nums[j];
                max=Math.max(mul,max);
            }
        }
        return max;
        
    }
}