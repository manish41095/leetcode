class Solution {
    public int pivotIndex(int[] nums) {

        int n = nums.length;
        int leftSum = 0;
        int rightSum = 0;
        int totalSum = 0;

        // Step 1: Calculate the total sum of the entire array
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: Iterate through the array and check the pivot condition
        for (int i = 0; i < n; i++) {

            // Right sum is totalSum minus leftSum minus the current element
            rightSum = totalSum - leftSum - nums[i];

            // If they match, we found our leftmost pivot index
            if (leftSum == rightSum)
                return i;

            // Add current element to leftSum for the next iteration
            leftSum += nums[i];

        }

        return -1;
    }
}