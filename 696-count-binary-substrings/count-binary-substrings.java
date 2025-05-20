class Solution {
    public int countBinarySubstrings(String s) {

        int prevCnt=0;
        int currCnt=1;
        int result=0;
        for(int i=1;i<s.length();i++)
        {
            
            if(s.charAt(i)==s.charAt(i-1))
            {
                currCnt++;
            }
            else
            {
                result+=Math.min(prevCnt,currCnt);
                prevCnt=currCnt;
                currCnt=1;
            }
        }
        result+=Math.min(prevCnt,currCnt);
        return result;
        
    }
}