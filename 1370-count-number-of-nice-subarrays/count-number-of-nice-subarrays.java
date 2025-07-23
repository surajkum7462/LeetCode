class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        return atMost(nums,k)-atMost(nums,k-1);
        
    }

    public int atMost(int[] nums,int k)
    {
        int l=0;
        int r=0;
        int n=nums.length;
        int oddcnt=0;
        int cnt=0;
        while(r<n)
        {
            if(nums[r]%2!=0)
            {
                oddcnt++;
            }
            while(oddcnt>k)
            {
                if(nums[l]%2!=0)
                {
                    oddcnt--;
                }
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
}