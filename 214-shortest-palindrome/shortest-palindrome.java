class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        String combined=s+"#"+rev;
        int[] lps = getLps(combined);
         int palin =lps[combined.length()-1];

         String suffix = rev.substring(0,rev.length()-palin);

         return suffix+s;
    }
    public int[] getLps(String str)
    {
        int n=str.length();
        int[] lps = new int[n];
        int i=1;
        int len=0;
        while(i<n)
        {
            if(str.charAt(i)==str.charAt(len))
            {
                len++;
                lps[i]=len;
                i++;
            }
        else
        {
            if(len!=0)
            {
                len=lps[len-1];
            }
            else
            {
                lps[len]=0;
                i++;
            }
        }
        }
        return lps;
    }
}