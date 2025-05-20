class Solution {
    public int[] sortedSquares(int[] nums) {

        int n=nums.length;
        int l=0;
        int r=n-1;
        int[] res = new int[n];
        int pos=n-1;
        while(l<=r)
        {
            int leftSum=nums[l]*nums[l];
            int rightSum=nums[r]*nums[r];
            if(leftSum>rightSum)
            {
                res[pos--]=leftSum;
                l++;
            }
            else
            {
                res[pos--]=rightSum;
                r--;
            }
        }
        return res;
    }
}