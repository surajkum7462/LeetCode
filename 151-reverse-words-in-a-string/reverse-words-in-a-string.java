class Solution {
    public String reverseWords(String s) {

       String rev=reverse(s.trim());
         StringBuilder ans = new StringBuilder();
       int i=0;
       while(i<rev.length())
       {
        StringBuilder word = new StringBuilder();
          while(i<rev.length() && rev.charAt(i)!=' ')
          {
             word.append(rev.charAt(i));
             i++;
          }
          if(word.length()>0)
          {
            ans.append(reverse(word.toString())).append(" ");
          }
          i++;
       }
       return ans.toString().trim();
    }

    private String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }
}