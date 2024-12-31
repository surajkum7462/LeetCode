class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        nse=findNSE(arr);
        pse=findPSEE(arr);
        long total=0;
        int mod=(int)(1e9+7);

        for(int i=0;i<n;i++)
        {
            int left=i-pse[i];
            int right=nse[i]-i;
            total=(total+(left*right*1L*arr[i])%mod)%mod;
        }
        return (int)total;
    }
    
    public int[] findPSEE(int[] arr)
    {
        int n=arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() &&  arr[st.peek()] >=arr[i])
            {
                st.pop();
            }
            nse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return nse;
    }
    public int[] findNSE(int[] arr)
    {
        int n=arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() &&  arr[st.peek()] >arr[i])
            {
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }
}