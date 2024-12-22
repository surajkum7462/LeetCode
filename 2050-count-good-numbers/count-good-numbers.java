class Solution {
    long mod=1_000_000_007;
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;

        long first=pow(5,even)%mod;
        long second=pow(4,odd)%mod;

        return (int)((first*second)%mod);
    }

    public long pow(long x,long n)
    {
        long ans=1;
       while(n>0)
       {
         if(n%2==1)
         {
            ans=(ans*x)%mod;
         }
         x=(x*x)%mod;
         n=n/2;
       }
       return ans;
    }
}