class Solution {
    public int coinChange(int[] coins, int amount) {
        // Initialize the DP table with a value greater than any possible solution
        int max = amount + 1;
        int[] dp = new int[max];

        // Fill the array with the max value
        Arrays.fill(dp, max);

        // Base case: 0 coins are needed to make an amount of 0
        dp[0] = 0;

        // Compute minimum coins for all amounts up to the target
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] hasn't been changed, it means the amount is unreachable
        return dp[amount] > amount ? -1 : dp[amount];
    }
}