class Solution {
    public int longestOnes(int[] nums, int k) {

        int zeroCount = 0;
        int maxLen = 0;
        int start = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                zeroCount++;
            while(zeroCount > k) {
                if (nums[start] == 0)
                    zeroCount--;
                start++;
            }

            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;

    }
}