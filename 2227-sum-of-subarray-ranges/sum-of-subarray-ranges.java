class Solution {
    public long subArrayRanges(int[] nums) {
        return sumOfMax(nums)-sumOfMin(nums);
        
    }

  // Sum of Subarray of min
    public long sumOfMin(int[] arr)
    {
        long total=0;
        int[] nse=new int[arr.length];
        int[] pse=new int[arr.length];

        nse=findNSE(arr);
        pse=findPSE(arr);
        for(int i=0;i<arr.length;i++)
        {
            long left = i-pse[i];
            long right=nse[i]-i;
            total+=left*right*arr[i];
        }
        return total;
    }
    public int[] findNSE(int[] arr)
    {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        int n=arr.length;
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
            {
                st.pop();
            }
            res[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return res;
    }

     public int[] findPSE(int[] arr)
    {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
            {
                st.pop();
            }
            res[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return res;
    }


  // Sum of Subarray of max
    public long sumOfMax(int[] arr)
    {
        long total=0;
        int[] nge=new int[arr.length];
        int[] pge=new int[arr.length];

        nge=findNGE(arr);
        pge=findPGE(arr);
        for(int i=0;i<arr.length;i++)
        {
            long left = i-pge[i];
            long right=nge[i]-i;
            total+=left*right*arr[i];
        }
        return total;
    }
    public int[] findNGE(int[] arr)
    {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        int n=arr.length;
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]<arr[i])
            {
                st.pop();
            }
            res[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return res;
    }

     public int[] findPGE(int[] arr)
    {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]<=arr[i])
            {
                st.pop();
            }
            res[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return res;
    }


























}