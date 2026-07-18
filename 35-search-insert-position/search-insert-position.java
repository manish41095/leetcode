class Solution {
    public int searchInsert(int[] nums, int target) {

        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {

            if (nums[i] >= target){
                ans = i;
                break;
            }

        }
        if (nums[n - 1] < target)
            ans = n;
        return ans;
    }

}