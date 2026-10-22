class Solution {
    public int minCostClimbingStairs(int[] cost) {
    //Approach1 without dp
    //    int first = cost[0];
    //    int second = cost[1];
    //   int minCost = 0;
    //   for(int i = 2 ; i <cost.length ; i++){
    //    int curr = cost[i] + Math.min(first, second);
    //    first = second;
    //    second = curr;
    //   }
    //  return Math.min(first, second);  

    //Approach2 with DP
    int n = cost.length;
    int[] dp = new int[n+1]; 
    dp[0] = 0;
    dp[1] = 0;
    for(int i = 2; i <= n; i++){
        dp[i] = Math.min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2]);
    }
    return dp[n];
    }
}