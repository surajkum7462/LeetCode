class Solution {
    public List<String> stringMatching(String[] words) {

        Set<String> ans = new HashSet<>();
        Arrays.sort(words,(a,b) -> Integer.compare(a.length(),b.length()));
        for(int i=0;i<words.length;i++)
        {
            String str = words[i];
            for(int j=i+1;j<words.length;j++)
            {
               String mainStr = words[j];
               if(mainStr.contains(str))
               {
                 ans.add(str);
                 continue;
               }
            }
        }
        return new ArrayList<>(ans);
    }
}