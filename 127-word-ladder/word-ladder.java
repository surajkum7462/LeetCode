class Pair
{
    String first ;
    int second;
    Pair(String first , int second)
    {
        this.first = first;
        this.second=second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> st = new HashSet<>(wordList);
       
        st.remove(beginWord);
        while(!q.isEmpty())
        {
            String word = q.peek().first;
            int step = q.peek().second;
            q.poll();
            if(word.equals(endWord)==true)
            {
                return step;
            }

            for(int i=0;i<word.length();i++)
            {
                for(char ch = 'a' ;ch<='z';ch++)
                {
                    char[] replacedWord = word.toCharArray();
                    replacedWord[i]=ch;
                    String existWord = new String(replacedWord);
                    if(st.contains(existWord))
                    {
                        st.remove(existWord);
                        q.add(new Pair(existWord,step+1));
                    }
                }
            }
        }
        return 0;
    }
}