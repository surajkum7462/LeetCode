class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        printSub(nums,0,ans,temp);
        return ans;
    }
    public void printSub(int[] arr , int i ,  List<List<Integer>> ans , List<Integer> temp)
    {
        if(i>=arr.length)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(arr[i]);
        printSub(arr,i+1,ans,temp);
        temp.remove(temp.size()-1);
        printSub(arr,i+1,ans,temp);

    }
}