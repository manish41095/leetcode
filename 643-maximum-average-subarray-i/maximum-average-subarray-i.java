class Solution {
    public double findMaxAverage(int[] nums, int k) {

        double prefixSum = 0;

        for (int i = 0; i < k; i++) {
            prefixSum += nums[i];
        }
        double maxSum = prefixSum;
        for (int i = k; i < nums.length; i++) {
            prefixSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, prefixSum);
        }
        return maxSum / k;
    }
}