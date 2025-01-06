class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m=g.length;
        int n=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int l=0;
        int r=0;
        while(r<m && l<n)
        {
            if(g[r]<=s[l])
            {
                r=r+1;
            }
            l=l+1;
        }
        return r;
    }
}