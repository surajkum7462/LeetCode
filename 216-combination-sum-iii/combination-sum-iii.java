class Solution {
      public void findCombination(int indx, int target, int k, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0 && ds.size() == k) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (ds.size() > k) return;
        for (int i = indx; i <= 9; i++) {
            if (i > target) break;
            ds.add(i);
            findCombination(i + 1, target - i, k, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(1, n, k, ans, new ArrayList<>());
        return ans;
        
    }
}