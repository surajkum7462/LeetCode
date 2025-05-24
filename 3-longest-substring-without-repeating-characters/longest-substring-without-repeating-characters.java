class Solution {
    public int lengthOfLongestSubstring(String s) {
       int max=0;
       int n=s.length();
       int left=0;
       int right=0;
       Map<Character,Integer> map = new HashMap<>();
          
       while(right<n)
       {
         if(map.containsKey(s.charAt(right)))
         {
            left = Math.max(left,map.get(s.charAt(right))+1);
         }
         map.put(s.charAt(right),right);
          int len=right-left+1;
          max=Math.max(len,max);
          right++;
       }
        return max;
    }
}