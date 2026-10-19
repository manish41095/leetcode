class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int totalSum = 0;

        // Trackers for Maximum Subarray (Standard Kadane)
        int maxSum = nums[0];
        int currMax = 0;

        // Trackers for Minimum Subarray (Inverse Kadane)
        int minSum = nums[0];
        int currMin = 0;


        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];

            // Standard Kadane to find the max subarray in the middle
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSum = Math.max(currMax, maxSum);

             // Inverse Kadane to find the min subarray in the middle
            currMin = Math.min(nums[i], currMin + nums[i]);
            minSum = Math.min(currMin, minSum);     

            

        }

         // Edge Case: If all numbers are negative, totalSum == minSum.
        // totalSum - minSum would equal 0, which is incorrect because an empty 
        // subarray isn't allowed. In this case, standard maxSum is the answer.
        if(maxSum < 0)
            return maxSum;
        return Math.max(maxSum, totalSum - minSum);    
    }
}