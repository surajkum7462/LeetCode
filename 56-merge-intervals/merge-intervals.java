class Solution {
    public int[][] merge(int[][] intervals) {
       int n=intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(res.isEmpty() || intervals[i][0]>res.get(res.size()-1)[1])
            {
                res.add(intervals[i]);
            }
           else
           {
             res.get(res.size()-1)[1]=Math.max(intervals[i][1],res.get(res.size()-1)[1]);
           }
        }
        return res.toArray(new int[res.size()][]);
    }
}