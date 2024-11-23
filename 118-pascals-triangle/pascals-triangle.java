class Solution {
    public List<Integer> findRow(int r)
    {
        List<Integer> row=new ArrayList<>();
        row.add(1);
        int ans=1;
        for(int i=1;i<r;i++)
        {
          ans=ans*(r-i);
          ans=ans/i;
          row.add(ans);
        }
        return row;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();


        for(int i=1;i<=numRows;i++)
        {
            ans.add(findRow(i));
        }
        return ans;
    }
}