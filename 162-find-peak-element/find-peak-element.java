class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
             // If the element to the right is greater, a peak must be on the right
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } 
            // Otherwise, a peak is either at mid or to the left
            else {
                high = mid;
            }
        }

        // low and high will meet at the peak element index
        return low;
    }
}