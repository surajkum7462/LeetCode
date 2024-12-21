class Solution {
    public double myPow(double x, int n) {
     double ans = 1.0;
        long nn = n; // Use long to safely handle Integer.MIN_VALUE
        if (nn < 0) {
            nn = -nn; // Convert nn to positive
            x = 1 / x; // Adjust x for negative exponent
        }

        while (nn > 0) {
            if (nn % 2 == 1) { // If nn is odd
                ans *= x;
            }
            x *= x; // Square x
            nn /= 2; // Halve nn
        }

        return ans;
    }
}