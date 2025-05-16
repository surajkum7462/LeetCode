class Solution {

    public List<Integer> findRow(int num)
    {
        List<Integer> res=  new ArrayList<>();
        res.add(1);
        int ans=1;
        for(int i=1;i<num;i++)
        {
            ans=ans*(num-i);
            ans=ans/i;
            res.add(ans);
        }
        return res;
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