class Solution {
    public void helperCombine(int indx , String digits , StringBuilder sb , List<String> ans,String[] map)
    {
        if(indx==digits.length())
        {
            ans.add(sb.toString());
            return;
        }
        String letters = map[digits.charAt(indx)-'0'];//2->"abc";again "cde"
        for(char c:letters.toCharArray())
        {
            sb.append(c);
            helperCombine(indx+1,digits,sb,ans,map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty())
        {
            return ans;
        }
        String[] mapping ={

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
        helperCombine(0,digits,new StringBuilder(),ans,mapping);
        return ans;
    }
}