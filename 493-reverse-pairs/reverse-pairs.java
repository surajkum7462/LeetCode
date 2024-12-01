class Solution {
    public int reversePairs(int[] nums) {
       
        int n = nums.length;
        int[] temp = new int[n];
        return mergeSortAndCount(nums, temp, 0, n - 1);
    }

    private int mergeSortAndCount(int[] nums, int[] temp, int left, int right) {
        int invCount = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            invCount += mergeSortAndCount(nums, temp, left, mid);
            invCount += mergeSortAndCount(nums, temp, mid + 1, right);
            invCount += mergeAndCount(nums, temp, left, mid, right);
        }
        return invCount;
    }

    private int mergeAndCount(int[] nums, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int invCount = 0;

        while (i <= mid) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }
            invCount += (j - mid - 1);
            i++;
        }

        i = left;
        j = mid + 1;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (i = left; i <= right; i++) {
            nums[i] = temp[i];
        }

        return invCount;
    }
}

        
    
