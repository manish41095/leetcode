class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        //Start 1st pointer
        for (int i = 1; i < n; i++) {
            // start 2nd pointer
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1)
                        dp[i] = dp[j] + 1;
                }
            }
        }

        //1 Find the the max value in dp array
        int max = 0;
        for(int i = 0; i < dp.length; i++)
           max = Math.max(dp[i],max);
        return max+1;

        //2nd approach to find max
        // int maxIndex = 0;
        // for(int i = 0 ; i < dp.length; i++)
        //     if(dp[i] > dp[maxIndex] )
        //     maxIndex = i;
        // return dp[maxIndex]+1;
    }
}