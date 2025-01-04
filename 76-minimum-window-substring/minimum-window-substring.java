class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Step 1: Store frequency of characters in t using an array
        int[] targetFreq = new int[128]; // Assuming ASCII characters
        for (char c : t.toCharArray()) {
            targetFreq[c]++;
        }

        // Step 2: Initialize variables for the sliding window
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0; // To store the starting index of the minimum window
        int required = t.length(); // Total characters to match

        // Step 3: Slide the window
        while (right < s.length()) {
            // Add character at right pointer to the window
            char c = s.charAt(right);

            // Decrease required count only if character is part of t
            if (targetFreq[c] > 0) {
                required--;
            }
            targetFreq[c]--; // Reduce frequency in the current window

            // Try to shrink the window from the left
            while (required == 0) {
                // Update minimum window size and starting index
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Remove the character at the left pointer
                char leftChar = s.charAt(left);
                targetFreq[leftChar]++; // Restore frequency for the left character

                // If it is a required character and frequency becomes positive, increase `required`
                if (targetFreq[leftChar] > 0) {
                    required++;
                }

                left++; // Contract the window
            }

            right++; // Expand the window
        }

        // Step 4: Return the result
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

    
}