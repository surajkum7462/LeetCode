class Solution {
    public void findCombination(int indx , int[] arr , int target , List<List<Integer>> ans , List<Integer> ds)
    {
        if(indx==arr.length)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(ds));
            }
            return ;
        }
        if(arr[indx]<=target)
        {
            ds.add(arr[indx]);
            findCombination(indx,arr,target-arr[indx],ans,ds);
            ds.remove(ds.size()-1);
        }

        findCombination(indx+1,arr,target,ans,ds);
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        findCombination(0,candidates,target,ans,new ArrayList<>());

        return ans;
        
    }
}