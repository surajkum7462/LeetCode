class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {


        int[] result = new int[arr1.length];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr1.length;i++)
        {
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        }
        int indx=0;
        
        for(int num : arr2)
        {
            int freq = map.getOrDefault(num,0);
            while(freq-- > 0)
            {
                result[indx++]=num;
            }
            map.remove(num);
        }
        List<Integer> remaining = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            int freq = entry.getValue();
            int num = entry.getKey();
            while(freq-- > 0)
            {
                remaining.add(num);
            }
        }
        Collections.sort(remaining);
        for(int num:remaining)
        {
            result[indx++]=num;
        }
        return result;
        
    }
}