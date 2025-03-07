class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        int n=nums.length;
        helpSubset(0,n,nums,ans,temp);
       List<List<Integer>> answ = new ArrayList<>(ans);
        return answ;
        
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