class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        func(0,s,ans,temp);
        return ans;
        
    }
    public void func(int indx,String s,List<List<String>> ans , List<String> temp)
    {
        if(indx==s.length())
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
       for(int i=indx;i<s.length();i++)
       {
         if(palindrome(s,indx,i))
         {
            temp.add(s.substring(indx,i+1));
            func(i+1,s,ans,temp);
               temp.remove(temp.size()-1);
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