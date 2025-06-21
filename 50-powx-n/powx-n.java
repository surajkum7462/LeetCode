class Solution {
    public double myPow(double x, int n) {
       if(n==0) return 1;
      return  powhelp(x,n);
    }
    public double powhelp(double x , int n)
    {
        if(n==0) return 1;
        double half = powhelp(x,n/2);

        if(n%2==0)
        {
            return half*half;
        }
        else
        {
            return n>0?half*half*x:half*half/x;
        }
    }
}