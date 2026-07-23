class Solution {
    public int search(int[] nums, int target) {

         if (nums == null || nums.length == 0) {
          return -1;
         }
        int high = nums.length - 1;
        int pivot = findPivotIndex(nums);
        if(pivot == 0)
            return binarySearch(nums, target, 0, high);
        if(target >= nums[0])
            return binarySearch(nums, target, 0, pivot - 1);
        return binarySearch(nums, target, pivot, high);
        
    }

    private int findPivotIndex(int[] nums) {
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i] )
                return i;
        }
        return 0;
    }

    private int binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid])
                low = mid + 1;
            else {
                high = mid - 1;
            }
        }
        return -1;

    }

    // private int modifiedBinarySearch(int[] nums, int target, int low, int high) {

    //     if (low > high)
    //         return -1;

    //     int mid = low + (high - low) / 2;

    //     if (nums[mid] == target)
    //         return mid;

    //     //Check left subarray sorted or not
    //     if (nums[low] <= nums[mid]) { // Left sub array sorted
    //         // If the key is in left half
    //         if (nums[low] <= target && target <= nums[mid])
    //             return modifiedBinarySearch(nums, target, low, mid - 1);
    //         else
    //             return modifiedBinarySearch(nums, target, mid + 1, high);
    //     }

    //     else { // Right sub array sorted

    //         //if the key is in the right half
    //         if (nums[mid] <= target && target <= nums[high])
    //             return modifiedBinarySearch(nums, target, mid + 1, high);
    //         else
    //             return modifiedBinarySearch(nums, target, low, mid - 1);
    //     }
    // }
}