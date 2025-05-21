class Solution {
    public int reversePairs(int[] nums) {
        int n=nums.length;
         int[] temp = new int[n];
       return mergeSort(nums,temp,0,n-1);
    }
    public int mergeSort(int[] arr , int temp[] ,int start , int end)
    {
        int inversionCnt=0;
        if(start<end)
        {
            int mid = (start+end)/2;
            inversionCnt+=mergeSort(arr,temp,start,mid);
            inversionCnt+=mergeSort(arr,temp,mid+1,end);
            inversionCnt+=mergeSortAndCnt(arr,temp,start,mid,end);
        }
        
        return inversionCnt;
    }
    public  int mergeSortAndCnt(int[] arr , int[] temp,int left , int mid,int right)
    {
        int i=left;
        int j=mid+1;
        int k=left;
        int inver=0;

        while(i<=mid)
        {
            while(j<=right && arr[i]>2L * arr[j])
            {
                j++;
            }
            inver+=j-mid-1;
            i++;
        }



       i = left;
        j = mid + 1;


        while(i<=mid && j<=right)
        {
            if(arr[i]<=arr[j])
            {
                temp[k++]=arr[i++];
            }
            else
            {
                temp[k++]=arr[j++];
               
            }
        }
        while(i<=mid)
        {
            temp[k++]=arr[i++];
        }
        
        while(j<=right)
        {
            temp[k++]=arr[j++];
        }
        for(i=left;i<=right;i++)
        {
            arr[i]=temp[i];
        }
        return inver;
    }
}