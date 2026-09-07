class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        // Step 1: Create a frequency array. 
        // Max value in constraint is usually 100, so size 102 prevents out-of-bounds.
        int[] count = new int[102];

        for (int num : nums) {
            count[num]++;
        }

        // Step 2: Convert to running sum (prefix sum)
        // count[i] will store how many numbers are smaller than or equal to i
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < result.length; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                // The numbers smaller than nums[i] is the sum of frequencies up to nums[i] - 1
                result[i] = count[nums[i] - 1];
            }
        }

        return result;

    }
}