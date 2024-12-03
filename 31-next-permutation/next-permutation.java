class Solution {
    public void nextPermutation(int[] nums) {
        int indx=-1;
        int n=nums.length;

        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                indx=i;
                break;
            }
        }
        if(indx==-1)
        {
           reverse(nums,0,n-1);
           return;
        }
        for(int i=n-1;i>indx;i--)
        {
            if(nums[i]>nums[indx])
            {
                int temp=nums[i];
                nums[i]=nums[indx];
                nums[indx]=temp;
                break;
            }
        }
        reverse(nums,indx+1,n-1);
        
    }
    private void reverse(int[] a,int start,int end)
    {
        while(start<end)
        {
            int temp=a[start];
            a[start]=a[end];
            a[end]=temp;
            start++;
            end--;
        }
    }
}