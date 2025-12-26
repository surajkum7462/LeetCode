class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];
        for(int i=1;i<strs.length;i++)
        {
            common=findCommon(common,strs[i]);
        }
        return common;
        
    }
    public String findCommon(String str1 , String str2)
    {
        String newStr = "";
        int i=0;
        int j=0;
        while(i<str1.length() && j<str2.length())
        {
            if(str1.charAt(i)==str2.charAt(j))
            {
                newStr+=str1.charAt(i);
            }
            else
            {
                break;
            }
            i++;
            j++;
        }
        return newStr;
    }
}