class Solution {
    public int countBinarySubstrings(String s) {
     int prevCnt = 0;
     int currCnt = 1;
     int res = 0;
     for(int i=1;i<s.length();i++)
     {
        if(s.charAt(i)==s.charAt(i-1))
        {
            currCnt++;
        }
        else
        {
            res+=Math.min(prevCnt,currCnt);
            prevCnt=currCnt;
            currCnt=1;
        }
     }
     res+=Math.min(prevCnt,currCnt);
     return res;
        
    }
}