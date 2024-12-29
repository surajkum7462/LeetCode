class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     generateSubsets(nums, 0, new ArrayList<>(), result);
    //     return result;
    // }

    // private void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
    //     if (index == nums.length) {
    //         result.add(new ArrayList<>(current));
    //         return;
    //     }
        
    //     current.add(nums[index]);
    //     generateSubsets(nums, index + 1, current, result);
        
    //     current.remove(current.size() - 1);
    //     generateSubsets(nums, index + 1, current, result);

      int n=nums.length;
      int subsets=1<<n;
      List<List<Integer>> ans = new ArrayList<>();

      for(int num=0;num<=subsets-1;num++)
      {
         List<Integer> list = new ArrayList<>();
          for(int i=0;i<=n-1;i++)
          {
            if((num & (1<<i))!=0)
            {
                list.add(nums[i]);
            }
          }
          ans.add(list);

      }
      return ans;
    
    }
}