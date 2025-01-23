class Solution {
    public void reverse(int arr[],int l,int r)
    {
      
        while(l<r)
        {
            int temp=arr[r];
            arr[r]=arr[l];
            arr[l]=temp;
            l++;
            r--;
        }
       
    }
    public void rotate(int[] nums, int k){
         int n = nums.length;
          k =k%n;
         reverse(nums,0,n-1);
         reverse(nums,0,k-1);
         reverse(nums,k,n-1);
         

        
    }
}