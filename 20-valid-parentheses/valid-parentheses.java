class Solution {
    public boolean isValid(String s) {
       Stack<Character> st = new Stack<>();
       int i=0;
       int n=s.length();
       while(i<n)
       {
          char ch = s.charAt(i);
          if(ch=='[' || ch=='{' || ch=='(')
          {
             st.push(ch);
          }
          else
          {
            if(st.isEmpty())
            {
                return false;
            }
             char top=st.peek();
             if((top=='{' && ch=='}') ||
                (top=='(' && ch==')') ||
                (top=='[' && ch==']'))
                {
                    st.pop();
                }
                else
                {
                    return false;
                }
          }
          i++;
       }
       return st.isEmpty()?true:false;
    }
}