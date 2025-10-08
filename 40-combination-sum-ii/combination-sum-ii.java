class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       List<List<Integer>> ans = new ArrayList<>();
       List<Integer> temp  = new ArrayList<>();

       Arrays.sort(candidates);

       helpCombination(candidates,0,ans,temp,target);
       return ans;
    }

    public void helpCombination(int[] nums , int start ,  List<List<Integer>> ans , List<Integer> temp , int target)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=start;i<nums.length;i++)
        {
            if(i>start && nums[i]==nums[i-1])
            {
                continue;
            }

            if(nums[i]>target)
            {
                break;
            }

            temp.add(nums[i]);

            helpCombination(nums,i+1,ans,temp,target-nums[i]);

            temp.remove(temp.size()-1);
        }
    }
}