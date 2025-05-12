class Solution {
    public int majorityElement(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        int major = nums.length/2;
        for(int num:nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int ele=0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            if(entry.getValue()>major)
            {
                ele=entry.getKey();
            }
        }
        return ele;
    }
}