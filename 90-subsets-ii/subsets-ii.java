class Solution {
     public static void fun(int[] nums, int index, List<Integer> ds, Set<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[index]);
        fun(nums, index + 1, ds, res); // Include nums[index]
        ds.remove(ds.size() - 1);
        fun(nums, index + 1, ds, res); // Exclude nums[index]
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort to handle duplicates
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> ds = new ArrayList<>();
        fun(nums, 0, ds, res);
        return new ArrayList<>(res); // Convert to List
    }

        
    
}