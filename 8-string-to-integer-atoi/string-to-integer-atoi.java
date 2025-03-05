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
        int i=0;
        int sign=1;

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
        return atoiHelper(s,i,0,sign);
    }
    public int atoiHelper(String s , int i, int ans , int sign)
    {
        if(i>=s.length() || !Character.isDigit(s.charAt(i)))
        {
            return (int)(ans*sign);
        }
       
       int digit = s.charAt(i) - '0';

        // Correct overflow check BEFORE updating ans
        if (ans > (Integer.MAX_VALUE - digit) / 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        ans = ans * 10 + digit;

        return atoiHelper(s,i+1,ans,sign);
    }

}