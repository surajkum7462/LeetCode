class Solution {
    public List<List<Integer>> threeSum(int[] arr) {

       // Optimal solution
       Arrays.sort(arr);
       List<List<Integer>> ans = new ArrayList<>();
       int n=arr.length;
       for(int i=0;i<n;i++)
       {
          if(i!=0 && arr[i]==arr[i-1])
          {
             continue;
          }
          int j=i+1;
          int k= n-1;
          while(j<k)
          {
            int sum = arr[i]+arr[j]+arr[k];
            if(sum<0)
            {
                j++;
            }
            else if(sum>0)
            {
                k--;
            }
            else
            {
                List<Integer> list = Arrays.asList(arr[i],arr[j],arr[k]);
                ans.add(list);
                j++;
                k--;
                while(j<k && arr[j]==arr[j-1])
                {
                    j++;
                }
                while(j<k && arr[k]==arr[k+1])
                {
                    k--;
                }
            }
          }
       }
       return ans;



       // Better Solution
        // Set<List<Integer>> st =new HashSet<>();
        // for(int i=0;i<n;i++)
        // {
        //     Set<Integer> set = new HashSet<>();

        //     for(int j=i+1;j<n;j++)
        //     {
        //         int third= -(arr[i]+arr[j]);

        //         if(set.contains(third))
        //         {
        //             List<Integer> list = Arrays.asList(arr[i],arr[j],third);
        //             list.sort(null);
        //             st.add(list);
        //         }
        //         set.add(arr[j]);
        //     }
        // }
        // List<List<Integer>> ans=new ArrayList<>(st);
        // return ans;
    }
}