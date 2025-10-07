class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> ans  = new ArrayList<>();
      List<Integer> temp = new ArrayList<>();

      generateSubsets(nums,0,ans,temp);

      return ans;
    }

    public void generateSubsets(int[] nums,int i,List<List<Integer>> ans , List<Integer> temp)
    {
        if(i>=nums.length)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        generateSubsets(nums,i+1,ans,temp);
        temp.remove(temp.size()-1);
         generateSubsets(nums,i+1,ans,temp);
    }
}