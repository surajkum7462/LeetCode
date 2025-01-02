class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lSum = 0;
        int rSum = 0;
        int maxSum = 0;
        int n = cardPoints.length;
        
        // Sum the first 'k' elements in lSum (left sum)
        for (int i = 0; i < k; i++) {
            lSum += cardPoints[i];
        }
         maxSum=lSum;
        // Start the rInd from the last element of the array
        int rInd = n - 1;
        
        // Iterate backwards from k-1 down to 0
        for (int i = k - 1; i >= 0; i--) {
            lSum -= cardPoints[i];      // Subtract the leftmost card in the window
            rSum += cardPoints[rInd];   // Add the rightmost card
            rInd--;                     // Move the right pointer leftwards
            
            // Track the maximum score after each iteration
            maxSum = Math.max(maxSum, lSum + rSum);
        }
        
        return maxSum;
    }
}