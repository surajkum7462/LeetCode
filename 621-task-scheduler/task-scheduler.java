class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char task:tasks)
        {
            freq[task-'A']++;
        }
        int maxFreq=0;
        for(int f:freq)
        {
            maxFreq=Math.max(f,maxFreq);
        }
        int maxFreqTask=0;
        for(int f:freq)
        {
            if(f==maxFreq)
            {
                maxFreqTask++;
            }
        }
        int idleTime=(maxFreq-1)*(n+1)+maxFreqTask;
        return Math.max(idleTime,tasks.length);
        
    }
}