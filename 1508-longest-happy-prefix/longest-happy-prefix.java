class Solution {
    public String longestPrefix(String s) {
        int n = s.length();

        int[] lps=new int[n];
        int i=1;
        int len=0;
        while(i<n)
        {
            if(s.charAt(i)==s.charAt(len))
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
        int happylen=lps[n-1];
        return s.substring(0,happylen);
    }
}