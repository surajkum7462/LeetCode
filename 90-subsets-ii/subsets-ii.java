class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       Arrays.sort(nums);
       Set<List<Integer>> ans   = new HashSet<>();
       List<Integer> temp = new ArrayList<>();
       helpSubset(0,nums.length,nums,ans,temp);
       List<List<Integer>> newAns = new ArrayList<>(ans);
       return newAns;
        
    }
    public void helpSubset(int i , int n , int[] arr , Set<List<Integer>> ans , List<Integer> temp)
    {
        if(i==n)
        {
            
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(arr[i]);
        helpSubset(i+1,n,arr,ans,temp);
        temp.remove(temp.size()-1);
        helpSubset(i+1,n,arr,ans,temp);
    }
}