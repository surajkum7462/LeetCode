class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int k=0;
        int[] m=new int[nums1.length+nums2.length];

        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]<nums2[j])
            {
                m[k]=nums1[i];
                i++;k++;
            }
            else
            {
                m[k]=nums2[j];
                j++;
                k++;
            }
        }

        while(i<nums1.length)
        {
            m[k]=nums1[i];
            i++;
            k++;
        }
        

        while(j<nums2.length)
        {
            m[k]=nums2[j];
            j++;
            k++;
        }

       int r=m.length;
        if(r%2==0)
        {
            int a=r/2;
            return (double)(m[a]+m[a-1])/2;
        }
        else
        {
            int x=r/2;
            return (double) (m[x]);
        }
        
    }
}