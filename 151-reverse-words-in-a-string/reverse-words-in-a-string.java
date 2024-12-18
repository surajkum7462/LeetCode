class Solution {
    public String reverseWords(String s) {
    //     String rev=reverse(s);
    //     String ans="";
    //     for(int i=0;i<rev.length();i++)
    //     {
    //         String word="";
    //       while(i<rev.length() && rev.charAt(i)!=' ')
    //       {
    //           word+=rev.charAt(i);
    //           i++;
    //       }
    //       String x=reverse(word);
    //       if(x.length()>0)
    //       {
    //         ans+=" "+x;
    //       }
    //     }
    //     return ans.substring(1);
    // }
    // private String reverse(String s)
    // {
    //     StringBuilder sb = new StringBuilder(s);

       
    //     return sb.reverse().toString();
    // }


     String rev = reverse(s.trim());
        StringBuilder ans = new StringBuilder();

        int i = 0;
        while (i < rev.length()) {
            StringBuilder word = new StringBuilder();
            while (i < rev.length() && rev.charAt(i) != ' ') {
                word.append(rev.charAt(i));
                i++;
            }
            if (word.length() > 0) {
                ans.append(reverse(word.toString())).append(" ");
            }
            i++; // Skip space
        }

        return ans.toString().trim();
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}