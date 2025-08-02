class Solution {
    public int[] rearrangeArray(int[] nums) {
       int n=nums.length;
       int[] ans= new int[n];
       int posIndx=0;
       int negIndx=1;
       for(int num:nums)
       {
         if(num>0)
         {
            ans[posIndx]=num;
            posIndx+=2;
         }
         else{
            ans[negIndx]=num;
            negIndx+=2;
         }
       }
       return ans;
    }
}