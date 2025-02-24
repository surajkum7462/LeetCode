class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int i = s.length()-1;
        while(i>=0)
        {
            while(i>=0 && s.charAt(i)==' ')
            {
                i--;
            }
            int end = i;
            while(i>=0 && s.charAt(i)!=' ')
            {
                i--;
            }
            if(end>=0)
            {
                ans.append(s.substring(i+1,end+1)).append(" ");
            }
            
        }
        return ans.toString().trim();
    }
}