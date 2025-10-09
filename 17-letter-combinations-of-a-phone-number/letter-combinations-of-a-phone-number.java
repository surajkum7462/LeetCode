class Solution {

    public void helpCombine(int indx,String digits,String[] mapping,StringBuilder sb,List<String> ans)
    {
        if(indx==digits.length())
        {
            ans.add(sb.toString());
            return;
        }




        String words = mapping[digits.charAt(indx)-'0'];
        for(char ch : words.toCharArray())
        {
            sb.append(ch);
            helpCombine(indx+1,digits,mapping,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    
    public List<String> letterCombinations(String digits) {
       List<String> ans = new ArrayList<>();

       if(digits.isEmpty())
       {
         return ans;
       }

       String[] mapping = {
                      "",
                      "",
                      "abc",
                      "def",
                      "ghi",
                      "jkl",
                      "mno",
                      "pqrs",
                      "tuv",
                      "wxyz"
       };

       helpCombine(0,digits,mapping,new StringBuilder(),ans);
       return ans;
    }
}