class Solution {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int maxCnt=0;
        int maxLen=0;
        int left=0;
        for(int right=0;right<s.length();right++)
        {
            cnt[s.charAt(right)-'A']++;
            maxCnt=Math.max(maxCnt,cnt[s.charAt(right)-'A']);

            if((right-left+1)-maxCnt>k)
            {
                cnt[s.charAt(left)-'A']--;
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;
        
    }
}