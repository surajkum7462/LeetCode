class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
       List<List<Integer>> ans = new ArrayList<>();
       List<Integer> temp = new ArrayList<>();
       helpCombination(1,k,n,ans,temp);
       return ans;
    }

    public void helpCombination(int start , int k, int n , List<List<Integer>> ans , List<Integer> temp)
    {

        if(k<0 || n<0)
        {
            return;
        }

        if(k==0 && n==0)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }




       for(int i=start;i<=9;i++)
       {
          temp.add(i);
          helpCombination(i+1,k-1,n-i,ans,temp);
          temp.remove(temp.size()-1);
       }

    }
}