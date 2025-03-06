class Solution {
    public void combine(int[] arr , int indx , int target , List<List<Integer>> ans , List<Integer> ds)
    {

            if(target==0)
            {
                ans.add(new ArrayList<>(ds));
            }


        for(int i=indx;i<arr.length;i++)
        {
            if(i>indx && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            ds.add(arr[i]);
            combine(arr,i+1,target-arr[i],ans,ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        combine(candidates,0,target,ans,temp);
        return ans;
        
    }
}