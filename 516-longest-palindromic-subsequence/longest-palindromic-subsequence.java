class Solution {
    int[][] dp = new int[1001][1001];
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        
        return solve(s, 0, n - 1);
    }

    public int solve(String s, int i, int j) {
        if (i > j)
            return 0;
        if (i == j)
            return 1;
        if (dp[i][j] != 0)
            return dp[i][j];
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + solve(s, i + 1, j - 1);
        } else {
            return dp[i][j] = Math.max(solve(s, i, j - 1), solve(s, i + 1, j));
        }
    }
}