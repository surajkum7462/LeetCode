class Solution {
    public int totalFruit(int[] fruits) {

        int max=0;
        int l=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int right=0;right<fruits.length;right++)
        {
           map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
           while(map.size()>2)
           {
              map.put(fruits[l],map.get(fruits[l])-1);
              if(map.get(fruits[l])==0)
              {
                map.remove(fruits[l]);
              }
              l++;
           }

           max=Math.max(max,right-l+1);
        }
        return max;
    }
}