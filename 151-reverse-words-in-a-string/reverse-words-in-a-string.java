class Solution {
    public String reverseWords(String s) {
        String rev=reverse(s);
        String ans="";
        for(int i=0;i<rev.length();i++)
        {
            String word="";
          while(i<rev.length() && rev.charAt(i)!=' ')
          {
              word+=rev.charAt(i);
              i++;
          }
          String x=reverse(word);
          if(x.length()>0)
          {
            ans+=" "+x;
          }
        }
        return ans.substring(1);
    }
    private String reverse(String s)
    {
        StringBuilder sb = new StringBuilder(s);

       
        return sb.reverse().toString();
    }
}