class Solution {
    public boolean isHappy(int n) {
    Set<Integer> st = new HashSet<>();
    while(n!=1 && !st.contains(n))
    {
        st.add(n);
        n=squareSum(n);
    }
return n==1;
   }
   public static int squareSum(int n)
   {
     int sum=0;
     while(n>0)
     {
        int rem = n%10;
        sum+=rem*rem;
        n/=10;
     }
     return sum;
   }
}