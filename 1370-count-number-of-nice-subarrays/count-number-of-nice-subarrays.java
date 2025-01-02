class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
        
    }
    public int atMost(int[] arr , int k)
    {
        int l=0;
        int r=0;
        int cnt=0;
        int oddCnt=0;
        int n=arr.length;
        while(r<n)
        {
            if(arr[r]%2!=0)
            {
                oddCnt++;
            }
            while(oddCnt>k)
            {
                if(arr[l]%2!=0)
                {
                    oddCnt--;
                }
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
}