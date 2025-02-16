class Solution {
    // public boolean isPresent(int[] arr , int target)
    // {
    //     int l=0;
    //     int r=arr.length-1;
    //     while(l<=r)
    //     {
    //         int mid=(l+r)/2;
    //         if(arr[mid]==target)
    //         {
    //             return true;
    //         }
    //         else if(arr[mid]<target)
    //         {
    //             l=mid+1;
    //         }
    //         else
    //         {
    //             r=mid-1;
    //         }
    //     }
    //     return false;
    // }
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1; // Treat as 1D array

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = matrix[mid / cols][mid % cols]; // Convert 1D index to 2D

            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}