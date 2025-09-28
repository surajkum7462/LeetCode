class Solution {
    long mod = 1_000_000_007;
    public long power(long base  , long exp)
    {
        long ans = 1;

        while(exp>0)
        {
            if(exp%2==1)
            {
                ans=(ans*base)%mod;
                exp-=1;
            }
            else
            {
                base = (base*base)%mod;
                exp/=2;
            }
        }
        return  ans;
    }
    public int countGoodNumbers(long n) {
        long evenPos = (n+1)/2;
        long oddPos = n/2;

        long pow5 = power(5,evenPos);
        long pow4 = power(4,oddPos);

        return (int) ((pow5*pow4)%mod);
    
    }
}