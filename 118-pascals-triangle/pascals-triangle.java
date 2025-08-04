class Solution {

    public List<Integer> findRow(int num)
    {
        int ans=1;
        List<Integer> list = new ArrayList<>();
        list.add(ans);
        for(int i=1;i<num;i++)
        {
           ans = ans*(num-i);
           ans=ans/i;
           list.add(ans);
        }
        return list;
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