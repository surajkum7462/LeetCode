class Solution {
    public List<Integer> majorityElement(int[] nums) {

        Map<Integer,Integer>  map = new HashMap<>();
        int n=nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int num:nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            int value=entry.getValue();
            int key= entry.getKey();
            if(value>n/3)
            {
                ans.add(key);
            }
        }
        return ans;
       
    }
}