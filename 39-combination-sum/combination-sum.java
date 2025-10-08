class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     List<List<Integer>> ans = new ArrayList<>();
     List<Integer> temp = new ArrayList<>();

     helpCombination(candidates,0,ans,temp,target);
     return ans;
    }

    public void helpCombination(int[] nums , int indx ,  List<List<Integer>> ans , List<Integer> temp , int target)
    {

        if(indx==nums.length)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }



        if(nums[indx]<=target)
        {
            temp.add(nums[indx]);
            helpCombination(nums,indx,ans,temp,target-nums[indx]);
            temp.remove(temp.size()-1);
        }
        helpCombination(nums,indx+1,ans,temp,target);
    }
}