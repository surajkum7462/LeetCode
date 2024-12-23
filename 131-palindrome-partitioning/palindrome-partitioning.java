class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();

        List<String> path = new ArrayList<>();

        partioning(0,s,path,ans);

        return ans;
        
    }

    public void partioning(int indx , String s ,List<String> path , List<List<String>> ans)
    {
        if(indx==s.length())
        {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i=indx;i<s.length();i++)
        {
            if(palindrome(s,indx,i))
            {
               path.add(s.substring(indx,i+1));
               partioning(i+1,s,path,ans);
               path.remove(path.size()-1);
            }
        }
    }
    public boolean palindrome(String s , int start , int end)
    {
        while(start<=end)
        {
            if(s.charAt(start)!=s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}