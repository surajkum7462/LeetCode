class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n=nums1.length;
        int m=nums2.length;
        int[] arr=new int[m+n];
        int k=0;
        int i=0;
        int j=0;
        while(i<n && j<m)
        {
            if(nums1[i]<=nums2[j])
            {
                arr[k]=nums1[i];
                k++;
                i++;
            }
            else
            {
                arr[k]=nums2[j];
                k++;
                j++;
            }
        }

        while(i<n)
        {
            arr[k]=nums1[i];
            k++;
            i++;
        }
        while(j<m)
        {
            arr[k]=nums2[j];
            k++;
            j++;
        }
        int x=arr.length;
        
        if(x%2!=0)
        {
            return arr[x/2];
        }
        int mid1=arr[x/2];
        int mid2=arr[(x/2)-1];
        return (mid1+mid2)/2.0;
    }
}