class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for(int i=1;i<strs.length;i++)
        {
            res = common(res,strs[i]);
        }
        return res;
    }

    public String common(String s1 , String s2)
    {
        StringBuilder sb = new StringBuilder();
        int min = Math.min(s1.length(),s2.length());
        for(int i=0;i<min;i++)
        {
            if(s1.charAt(i)==s2.charAt(i))
            {
                sb.append(s1.charAt(i));
            }
            else
            {
                break;
            }
        }
        return sb.toString();
    }
}