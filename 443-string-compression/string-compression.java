class Solution {
    public int compress(char[] chars) {

        int write=0;
      
        int i=0; 
        while(i<chars.length)
        {
            char currectChar = chars[i];
              int cnt=0;

              while(i<chars.length && chars[i]==currectChar)
              {
                 cnt++;
                 i++;
              }
              chars[write++]=currectChar; // for itself charcter

              if(cnt>1)
              {
                for(char ch:String.valueOf(cnt).toCharArray())
                {
                    chars[write++]=ch;
                }
              }
        }
        return write;
        
    }
}