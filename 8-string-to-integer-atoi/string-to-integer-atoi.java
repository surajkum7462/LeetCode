class Solution {
    public int myAtoi(String s) {

     if(s==null || s.isEmpty())
     {
        return 0;
     }
     s=s.trim();
     if(s.isEmpty())
     {
        return 0;
     }
     int sign=+1;
     long ans=0;
     int i=0;
     if(s.charAt(i)=='-')
      {
         sign=-1;
         i++;
      } 
        else if(s.charAt(i)=='+')
      {
         sign=+1;
         i++;
      } 
        

      while(i<s.length() && Character.isDigit(s.charAt(i)))
      {
        char ch = s.charAt(i);
         ans=ans*10+ch-'0';
         if(sign==1 && ans>Integer.MAX_VALUE)
         {
            return Integer.MAX_VALUE;
         }

         if(sign==-1 && -ans<Integer.MIN_VALUE)
         {
            return Integer.MIN_VALUE;
         }
         i++;
      }
      return (int)(ans)*(sign);
    }
}