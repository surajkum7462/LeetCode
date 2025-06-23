class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> ans = new ArrayList<>();
       List<Integer> temp = new ArrayList<>();

       combinationHelp(candidates,0,ans,temp,target);
       return ans;
    }

    public void combinationHelp(int[] arr,int i,List<List<Integer>> ans , List<Integer> temp,int target)
    {
        if(i==arr.length)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(temp));
            }
            return ;
        }

        if(arr[i]<=target)
        {
            temp.add(arr[i]);
            combinationHelp(arr,i,ans,temp,target-arr[i]);
            temp.remove(temp.size()-1);
        }
        combinationHelp(arr,i+1,ans,temp,target);
    }
}