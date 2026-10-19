class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int globalMax = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < n; i++) {
            int num = nums[i];

            if(num < 0){
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            currentMax = Math.max(nums[i], currentMax * nums[i]);
            currentMin = Math.min(nums[i], currentMin * nums[i]);

            globalMax = Math.max(currentMax, globalMax);

        }

        return globalMax;
    }
}