class Solution {
    public String longestCommonPrefix(String[] strs) {

        String res = strs[0];

        for(int i=1;i<strs.length;i++)
        {
            res = common(res,strs[i]);
        }
        return res;
        
    }

    public String common(String p , String q)
    {
        StringBuilder sb = new StringBuilder();
        int min  = Math.min(p.length(),q.length());
        for(int i=0;i<min;i++)
        {
            if(p.charAt(i)==q.charAt(i))
            {
                sb.append(p.charAt(i));
            }
            else
            {
                break;
            }
        }
        return sb.toString();
    }

    
}