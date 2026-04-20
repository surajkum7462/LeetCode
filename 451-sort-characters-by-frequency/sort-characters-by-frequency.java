class Solution {
    public String frequencySort(String s) {
       StringBuilder sb  = new StringBuilder();
       Map<Character,Integer> map  = new HashMap<>();
       for(int i=0;i<s.length();i++)
       {
         char ch = s.charAt(i);
         map.put(ch,map.getOrDefault(ch,0)+1);
       }
      List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
      list.sort((a,b) -> b.getValue() - a.getValue());
       for(Map.Entry<Character,Integer> entry:list)
       {
          char ch = entry.getKey();
          int n=entry.getValue();
          for(int i=0;i<n;i++)
          {
            sb.append(ch);
          }
       }
       return sb.toString();
    }
}