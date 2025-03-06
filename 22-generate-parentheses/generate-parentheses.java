class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        solve(n,"",0,0,ans);
        return ans;
        
    }
    public void solve(int n , String curr , int open , int close , List<String> ans)
    {
        if(curr.length()==n*2)
        {
            ans.add(curr);
            return;
        }
        if(open<n)
        {
            solve(n,curr+"(",open+1,close,ans);
        }
        if(open>close)
        {
            solve(n,curr+")",open,close+1,ans);
        }
    }
}