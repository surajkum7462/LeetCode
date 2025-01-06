class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(mpp.entrySet());
        int[] arr = new int[k];

        for(int i=0;i<k;i++)
        {
            arr[i]=pq.poll().getKey();
        }
        return arr;
    }
}