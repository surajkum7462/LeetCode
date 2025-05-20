class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        for(char ch:s.toCharArray())
        {
            if(ch=='(')
            {
                st.push(0);
            }
            else
            {
                int val=0;
                while(st.peek()!=0)
                {
                    val+=st.pop();
                }
                st.pop();
                st.push(val==0?1:2*val);
            }
        }
        int total=0;
        while(!st.isEmpty())
        {
            total+=st.pop();
        }
        return total;
    }
}