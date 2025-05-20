class Solution {
    public List<String> stringMatching(String[] words) {

        List<String> ans = new ArrayList<>();
        
        for(int i=0;i<words.length;i++)
        {
            String words1 = words[i];
            for(int j=0;j<words.length;j++)
            {
               
               if(i!=j && words[j].contains(words1))
               {
                 ans.add(words1);
                 break;
               }
            }
        }
        return ans;
    }
}