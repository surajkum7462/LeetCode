class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert wordDict into a HashSet for fast lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, Boolean> memo = new HashMap<>(); // Memoization map
        return wordBreakHelper(s, wordSet, memo);
    }

    private boolean wordBreakHelper(String s, Set<String> wordSet, Map<String, Boolean> memo) {
        // Base case: If the string is empty, it can be segmented
        if (s.isEmpty()) return true;

        // If already computed, return the memoized result
        if (memo.containsKey(s)) return memo.get(s);

        // Try all prefixes of the current string
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i); // Prefix
            String suffix = s.substring(i);   // Suffix

            // If prefix exists in the dictionary and suffix is segmentable
            if (wordSet.contains(prefix) && wordBreakHelper(suffix, wordSet, memo)) {
                memo.put(s, true); // Store result in memo
                return true;
            }
        }

        // If no segmentation works, store and return false
        memo.put(s, false);
        return false;
    }
}
