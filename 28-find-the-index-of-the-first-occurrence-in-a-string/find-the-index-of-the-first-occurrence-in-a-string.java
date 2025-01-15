class Solution {
    public int strStr(String text, String pat) {
        int cnt=0;
        for(int i=0;i<=text.length()-pat.length();i++)
        {
            
            int j=0;
            while(j<pat.length() && text.charAt(i+j)==pat.charAt(j))
            {
                j++;
            }
              if (j == pat.length()) {
                return i;
            }
        }
        return -1;
    }
}