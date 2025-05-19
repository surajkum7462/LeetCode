class Solution {
    public int findNumbers(int[] nums) {
        int cnt=0;
        for(int num:nums)
        {
           
           if(num>=10 && num<100)
            {
                cnt++;
            }
            else if(num>=1000 && num<10000)
            {
                cnt++;
            }
            else if(num==100000){
                cnt=1;
            }
            
        }
        return cnt;
    }
}