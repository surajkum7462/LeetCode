class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
       
     
        printSubset(nums,0,ans,temp);

        return ans;
        
    }

    public void printSubset(int[] arr , int i , List<List<Integer>> ans, List<Integer> temp)
    {
       if(i>=arr.length)
       {
          ans.add(new ArrayList<>(temp));
          return;
       }
       temp.add(arr[i]);
       printSubset(arr,i+1,ans,temp);
       temp.remove(temp.size()-1);
       printSubset(arr,i+1,ans,temp);
    }
}