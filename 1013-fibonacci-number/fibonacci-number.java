class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
       
        return  computeFibo(n,dp);
        
    }
    public int computeFibo(int n,int[] dp)
    {
        if(n<=1)
        {
            return n;
        }
        if(dp[n]!=0)
        {
            return dp[n];
        }
        return dp[n]=computeFibo(n-1,dp)+computeFibo(n-2,dp);
    }
}