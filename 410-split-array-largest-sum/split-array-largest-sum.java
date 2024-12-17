class Solution {
    public int splitArray(int[] nums, int k) {
         ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(nums)
                                                                  .boxed()
                                                                  .collect(Collectors.toList());
        return findPages(list,list.size(),k);
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if(m>n)
        {
            return -1;
        }
        int l=Collections.max(arr);
        int r=arr.stream().mapToInt(Integer::intValue).sum();

        while(l<=r)
        {
            int mid=(l+r)/2;
            int st=countSt(arr,mid);
            if(st>m)
            {
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return l;
    }
    public static int countSt(ArrayList<Integer> arr,int  pages)
    {
        int n=arr.size();
        int st=1;
        long pgSt=0;
        for(int i=0;i<n;i++)
        {
            if(pgSt+arr.get(i)<=pages)
            {
                pgSt+=arr.get(i);
            }
            else
            {
                st++;
                pgSt=arr.get(i);
            }
        }
        return st;
    }
}