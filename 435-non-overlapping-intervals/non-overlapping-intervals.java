class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
          Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
         int n=intervals.length;
        int nonOverlappingCount = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // Check if the current interval overlaps with the last non-overlapping interval
            if (intervals[i][0] >= lastEnd) {
                // No overlap; update the end time of the last interval
                lastEnd = intervals[i][1];
            } else {
                // Overlap detected; increment count of intervals to remove
                nonOverlappingCount++;
            }
        }

        return nonOverlappingCount;
    }
}