class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n=nums.length;
       
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            cnt=0;
            for(int j=i;j<n;j++)
            {
                if(nums[i]==nums[j])
                {
                    cnt++;                  
                }
               
            }
             if(cnt>n/3 && !ans.contains(nums[i]))
                {
                        ans.add(nums[i]);
                 }
                   
               
        }
        return ans; 
        
    }
}