class Solution {
    public int searchInsert(int[] nums, int target) {

        int high = nums.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;

        //Approach1
        // int ans = 0;
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] >= target){
        //         ans = i;
        //         break;
        //     }

        // }
        // if (nums[n - 1] < target)
        //     ans = n;
        // return ans;
    }

}