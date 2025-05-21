class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        if(nums==null || n<4)
        {
            return new ArrayList<>();
        }
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++)
        {
            for(int j=i+1;j<n-2;j++)
            {
                int left=j+1;
                int right=n-1;
                while(left<right)
                {
                    long sum=(long) nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target)
                    {
                        ans.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                    }
                    else if(sum<target)
                    {
                        left++;
                    }
                    else
                    {
                        right--;
                    }
                }
            }
        }
     return new ArrayList<>(ans);
    }
}