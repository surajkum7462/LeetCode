class Solution {
    public int numberOfSubstrings(String s) {

        int[] lastSeen = {-1,-1,-1};
        int result=0;
        for(int i=0;i<s.length();i++)
        {
            lastSeen[s.charAt(i)-'a']=i;


            int earliestSeen  = Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2]));

            if(earliestSeen!=-1)
            {
                result+=earliestSeen+1;
            }
        }
        return result;
        
    }
}