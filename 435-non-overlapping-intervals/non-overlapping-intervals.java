class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
          Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
         int n=intervals.length;
        int nonOverlappingCount = 0;
        int lastEnd = Integer.MIN_VALUE;

       for(int i=0;i<n;i++)
       {
         if(intervals[i][0]>=lastEnd)
         {
            lastEnd=intervals[i][1];
         }
         else
         {
            nonOverlappingCount++;
         }
       }

        return nonOverlappingCount;
    }
}