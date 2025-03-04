class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        return checkPalindrome(0,str);
    }

    public boolean checkPalindrome(int i , String str)
    {
        if(i >= str.length()/2)
        {
            return true;
        }
        if(str.charAt(i)!=str.charAt(str.length()-i-1))
        {
            return false;
        }
        return checkPalindrome(i+1,str);
    }
}