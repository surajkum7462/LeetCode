class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return sumOfSub(nums,goal)-sumOfSub(nums,goal-1);
        
    }
    public int sumOfSub(int[] arr , int goal)
    {
          if (goal < 0) return 0;
        int n=arr.length;
        int l=0;
        int r=0;
        int cnt=0;
        int sum=0;
        while(r<n)
        {
            sum+=arr[r];
            while(sum>goal)
            {
                sum-=arr[l];
                l++;
            }
            cnt+=(r-l+1);
            r++;

        }
        return cnt;
    }
}