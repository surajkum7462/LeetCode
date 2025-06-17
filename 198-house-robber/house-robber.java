class Solution {
    public int rob(int[] arr) {
        int prev1=arr[0];
        int prev2=0;
        for(int i=1;i<arr.length;i++)
        {
            int take = arr[i];
            if(i>1)
            {
                take+=prev2;
            }
            int notTake=0+prev1;
            int curr=Math.max(take,notTake);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
        
    }
}