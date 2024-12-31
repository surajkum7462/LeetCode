class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        Stack<Character> st = new Stack<>();
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            char c = num.charAt(i);
           while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
           
        }
         while(k>0 && !st.isEmpty())
            {
                st.pop();
                k--;
            }
            
            while(!st.isEmpty())
            {
                res.append(st.pop());
            }
           res.reverse();

            while (res.length() > 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        
        // Return "0" if the result is empty
        return res.length() == 0 ? "0" : res.toString();
    }
}