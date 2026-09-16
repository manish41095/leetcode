class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0 ; j < n ; j++)
                // Fill the first row and first column with 1s
                if(i == 0 || j == 0)
                    dp[i][j] = 1;

                // Fill the rest of the table    
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];    
        
        return dp[m-1][n-1];
    }
}