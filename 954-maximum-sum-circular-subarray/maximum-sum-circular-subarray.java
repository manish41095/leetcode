class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int minSum = nums[0];
        int currSum = nums[0];
        int maxSum = nums[0];
        int currSum1 = nums[0];
        int totalSum = nums[0];

        //Kadanes algo to find min and max sum subarray 
        for(int i = 1; i< nums.length; i++){
            totalSum = totalSum + nums[i];

            currSum = Math.min(nums[i], currSum + nums[i]);
            minSum = Math.min(minSum, currSum);

            currSum1 = Math.max(nums[i], currSum1 + nums[i]);
            maxSum = Math.max(maxSum, currSum1);

        }
        if(maxSum>0){
        return Math.max(maxSum, totalSum-minSum);
        }
        else{
         return maxSum;
        }
    }
}