class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n=nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int k:nums)
        {
            map.put(k,map.getOrDefault(k,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
           int key = entry.getKey();
           int value=entry.getValue();
           if(value>(n/3))
           {
             ans.add(key);
           }
        }
        return ans;
    }
}