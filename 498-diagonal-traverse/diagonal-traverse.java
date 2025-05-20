class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int m=mat.length;
        int n=mat[0].length;
        int[] ans = new int[m*n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
               int key=i+j;
               if(!map.containsKey(key))
               {
                    map.put(key,new ArrayList<>());
               }
               map.get(key).add(mat[i][j]);
               
            }
        }
        int k=0;
        boolean flip=true;
        for(List<Integer> it:map.values())
        {
          if(flip)
          {
            Collections.reverse(it);
          }
          for(int num:it)
          {
            ans[k++]=num;
          }
          flip=!flip;
        }
        return ans;
    }
}