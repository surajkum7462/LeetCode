class Solution {
    public double myPow(double x, int n) {
      if(n==0) return 1;
      return powHelper(x,n);
    }
    public double powHelper(double x , int n)
    {
        if(n==0) return 1;

        double half = powHelper(x,n/2);

        if(n%2==0)
        {
            return half*half;
        }
        else
        {
            return (n>0) ? half*half*x : half * half/x;
        }
    }
}