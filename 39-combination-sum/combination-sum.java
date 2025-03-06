class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp  = new ArrayList<>();
        combination(candidates,0,target,ans,temp);
        return ans;
       
    }
    public void combination(int[] arr , int i , int target ,  List<List<Integer>> ans , List<Integer> temp)
    {
        if(i==arr.length)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(temp));
                
            }
            return;
        }

            if(arr[i] <= target)
            {
                temp.add(arr[i]);
                combination(arr,i,target-arr[i],ans,temp);
                temp.remove(temp.size()-1);
            }
            combination(arr,i+1,target,ans,temp);
        
    }
}