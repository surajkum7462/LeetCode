class Solution {
    public int findCondidate(int nums[])
    {
        Integer condidate=null;
        int count=0;
        for(int num:nums)
        {
            if(count==0)
            {
               condidate=num;
               count=1;
            }else if(condidate==num)
            {
                count++;
            }else{
                count--;
            }
        }
        return condidate;
    }

    public boolean isMajority(int num,int[] nums)
    {
        int cnt=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(num==nums[i])
            {
                cnt++;
            }
        }
        return cnt>n/2;
    }
    public int majorityElement(int[] nums) {
      int condidate = findCondidate(nums);
      if(isMajority(condidate,nums))
      {
         return condidate;
      }
      return -1;
    }
}