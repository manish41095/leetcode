class Solution {
    public boolean increasingTriplet(int[] nums) {

        int left = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        boolean res = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= left) {
                left = nums[i];
            } else if (nums[i] <= mid) {
                mid = nums[i];
            } else {
                res = true;
            }
        }
        return res;
    }
}