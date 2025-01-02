class Solution {
    public int numberOfSubstrings(String s) {
          int[] lastSeen = {-1, -1, -1}; // Tracks the last seen indices of 'a', 'b', 'c'
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Update the last seen index of the current character
            lastSeen[s.charAt(i) - 'a'] = i;
            
            // Find the smallest index among the last seen indices
            int earliestLastSeen = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            
            // If all characters have been seen at least once
            if (earliestLastSeen != -1) {
                result += earliestLastSeen + 1;
            }
        }
        
        return result;
    }
}