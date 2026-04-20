class Solution {


    public static List<Integer> findRow(int num)
    {
        List<Integer> list = new ArrayList<>();
        int ans=1;
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
            List<Integer> list  = findRow(i);
            ans.add(list);
        }
        return ans;
      
    }
}