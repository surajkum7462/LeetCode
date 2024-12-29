class Solution {
    public int divide(int dividend, int divisor) {
          if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Handle overflow case
        }

        boolean isPositive = (dividend < 0) == (divisor < 0);

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long ans = 0;

        while (n >= d) {
            long cnt = 0;
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }
            ans += 1L << cnt;
            n -= d << cnt;
        }

        return isPositive ? (int) ans : (int) -ans;
        
    }
}