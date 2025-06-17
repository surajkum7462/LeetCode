class Solution {
    public int robFind(int[] arr) {
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
    public int rob(int[] arr) {
        int n=arr.length;
        if(n==1)
        {
            return arr[0];
        }
        int[] temp1=new int[n];
        int[] temp2=new int[n];
        for(int i=0;i<n;i++)
        {
            if(i!=0)
            {
                temp1[i]=arr[i];
            }
            if(i!=n-1)
            {
                temp2[i]=arr[i];
            }
        }
        return Math.max(robFind(temp1),robFind(temp2));
        
    }
}