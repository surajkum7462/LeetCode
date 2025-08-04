class Solution {
    public List<Integer> majorityElement(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int n=nums.length;
        for(int num:nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            int key=entry.getKey();
            int val = entry.getValue();
            if(val>n/3)
            {
                ans.add(key);
            }
        }
        return ans;
    }
}