class Solution {
    public String reverseWords(String s) {
       String rev = reverse(s.trim());
       StringBuilder ans = new StringBuilder();

       int i=0;
       while(i<rev.length())
       {
          StringBuilder sb = new StringBuilder();
          while(i<rev.length() && rev.charAt(i)!=' ')
          {
            sb.append(rev.charAt(i));
            i++;
          }
          if(sb.length()>0)
          {
             ans.append(sb.reverse().toString()).append(" ");
          }
          i++;
       }
     return ans.toString().trim();
    }

    public String reverse(String s)
    {
        return new StringBuilder(s).reverse().toString();
    }
}