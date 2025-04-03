class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left = findpse(heights);
        right=findnse(heights);
        int maxi=0;
        for(int i=0;i<heights.length;i++)
        {
            int width=right[i]-left[i]-1;
            int area=heights[i]*width;
            maxi=Math.max(area,maxi);
        }
        return maxi;
    }
    public int[] findpse(int[] arr)
    {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++)
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

     public int[] findnse(int[] arr)
    {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
            {
               st.pop();
            }
            res[i]=st.isEmpty()?arr.length:st.peek();
            st.push(i);

        }
        return res;
    }
}