class Solution {
    public int findNumbers(int[] nums) {
        int cnt=0;
        for(int num:nums)
        {
           
           int digit=(int) Math.log10(num)+1;
           if(digit%2==0)
           {
             cnt++;
           }
            
        }
        return cnt;
    }
}