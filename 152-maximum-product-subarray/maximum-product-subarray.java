class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int globalMax = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            // If the current number is negative, swapping max and min 
            // optimizes the incoming multiplication logic
            if(num < 0){
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            // Decide whether to start a new subarray or extend the existing one
            currentMax = Math.max(num, currentMax * num);
            currentMin = Math.min(num, currentMin * num);

            // Maintain the overall global maximum seen so far
            globalMax = Math.max(currentMax, globalMax);

        }

        return globalMax;
    }
}