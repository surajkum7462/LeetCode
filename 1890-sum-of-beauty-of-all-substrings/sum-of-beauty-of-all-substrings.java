class Solution {
    public int beautySum(String s) {
        int sum=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            int[] freq=new int[26];
            for(int j=i;j<n;j++)
            {
                freq[s.charAt(j)-'a']++;
                int beauty=getMaxCount(freq)-getMinCount(freq);
                sum+=beauty;
            }
        }
        return sum;
    }
    public int getMaxCount(int[] arr)
    {
        int max=0;
        for(int i=0;i<arr.length;i++)
        {
            max=Math.max(max,arr[i]);
        }
        return max;
    }
    public int getMinCount(int[] arr)
    {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0)
            {
                min=Math.min(min,arr[i]);
            }
        }
        return min;
    }
}