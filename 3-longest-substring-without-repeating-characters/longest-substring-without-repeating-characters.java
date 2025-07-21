class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n = s.length();
       int l=0;
       int r=0;
       int max=0;
       Map<Character,Integer> map = new HashMap<>();
       while(r<n)
       {
         if(map.containsKey(s.charAt(r)))
         {
            l=Math.max(l,map.get(s.charAt(r))+1);
         }

         map.put(s.charAt(r),r);
         int len = r-l+1;
         max=Math.max(len,max);
         r++;
       }
       return max;
    }
}