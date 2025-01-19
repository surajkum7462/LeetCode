class Solution {
    public boolean isPalindrome(int x) {
       
        int n=x;
        int sum=0;
        while(x!=0)
        {
            int r=x%10;
            sum=sum*10+r;
            x=x/10;
        }
        if(n<0)
        {
            return false;
        }
        else if(sum==n)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}