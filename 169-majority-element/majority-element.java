class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int k=n/2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int x:nums)
        {
            map.put(x,map.getOrDefault(x,0)+1);
        }
       
       for(Map.Entry<Integer, Integer> entry : map.entrySet())
       {
           if(entry.getValue()>k)
           {
            return entry.getKey();
           }
       }
        return -1;
    }
}