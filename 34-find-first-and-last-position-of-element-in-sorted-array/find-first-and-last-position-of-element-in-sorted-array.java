class Solution {
    public int[] searchRange(int[] nums, int target) {
      
        int[] ans = new int[2];
        ans[0] = findFirst(nums, target);
        ans[1] = findLast(nums, target);
        return ans;
    }

    private int findFirst(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                ans = mid; // Update the result
                r = mid - 1; // Search in the left half
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    private int findLast(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                ans = mid; // Update the result
                l = mid + 1; // Search in the right half
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
        
    }
    
}