class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int poIndx=0;
        int negIndx=1;
        int[] ans = new int[n];
        for(int num:nums)
        {
            if(num>0)
            {
                ans[poIndx]=num;
                poIndx+=2;
            }
            else
            {
                ans[negIndx]=num;
                negIndx+=2;
            }
        }
        return ans;
    }
}