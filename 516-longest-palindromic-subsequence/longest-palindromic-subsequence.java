class Solution {
    //Recursive approach
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        return solve(s, 0, n - 1, dp);
    }

    public int solve(String s, int i, int j, int[][] dp) {
        if (i > j)
            return 0;
        if (i == j)
            return 1;
        if (dp[i][j] != 0)
            return dp[i][j];
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + solve(s, i + 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(solve(s, i, j - 1, dp), solve(s, i + 1, j, dp));
        }
    }

    //Bottom up approach 

    // public int longestPalindromeSubseq(String s) {
    //     int n = s.length();
    //     int[][] dp = new int[n][n];

    //     for(int i = n-1; i>=0; i--){
    //         dp[i][i] = 1;
    //         for(int j = i+1 ; j < n ; j++){

    //             if(s.charAt(i) == s.charAt(j)){
    //                 dp[i][j] = 2 + dp[i+1][j-1];
    //             }
    //             else{
    //                 dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
    //             }
    //         }
    //     }

    //     return dp[0][n-1];
    // }
}