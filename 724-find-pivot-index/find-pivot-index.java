class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int leftSum = 0;

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += nums[i];

        for (int i = 0; i < n; i++) {
            // Right sum is calculated as: totalSum - leftSum - currentElement
            if (leftSum == sum - leftSum - nums[i])
                return i;
            // Update left sum for the next index
            leftSum += nums[i];

        }

        return -1;
    }
}