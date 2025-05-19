class Solution {
    public String decodeString(String s) {

        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k=0;
        for(char ch:s.toCharArray())
        {
            if(Character.isDigit(ch))
            {
              k=k*10+(ch-'0');
            }
            else if(ch=='[')
            {
                count.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                 k=0;
            }
            else if(ch==']')
            {
                StringBuilder decode = stringStack.pop();
                int cnt = count.pop();
                for(int i=0;i<cnt;i++)
                {
                    decode.append(current);
                }
                current = decode;

            }
            else
            {
               current.append(ch);
            }
        }
       
        return current.toString();
    }
    
}
