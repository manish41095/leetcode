class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        return modifiedBinarySearch(nums, target, low, high);

    }

    private int modifiedBinarySearch(int[] nums, int target, int low, int high) {

        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;

        if (nums[mid] == target)
            return mid;

        //Check left subarray sorted or not
        if (nums[low] <= nums[mid]) { // Left sub array sorted
            // If the key is in left half
            if (nums[low] <= target && target <= nums[mid])
                return modifiedBinarySearch(nums, target, low, mid - 1);
            else
                return modifiedBinarySearch(nums, target, mid + 1, high);
        }

        else { // Right sub array sorted

            //if the key is in the right half
            if (nums[mid] <= target && target <= nums[high])
                return modifiedBinarySearch(nums, target, mid + 1, high);
            else
                return modifiedBinarySearch(nums, target, low, mid - 1);
        }
    }
}