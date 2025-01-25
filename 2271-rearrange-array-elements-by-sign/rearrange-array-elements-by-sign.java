class Solution {
    public int[] rearrangeArray(int[] nums) {
        int k=0;
        int l=0;
        int n=nums.length;
        int[] pos = new int[n/2];
        int[] neg = new int[n/2];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                pos[k++]=nums[i];
            }
            else
            {
                neg[l++]=nums[i];
            }
        }
        k=0;
        l=0;
        for(int i=0;i<nums.length;i++)
        {
           if(i%2==0)
           {
             nums[i]=pos[k++];
           }
           else
           {
             nums[i]=neg[l++];
           }
        }
        return nums;
    }
}