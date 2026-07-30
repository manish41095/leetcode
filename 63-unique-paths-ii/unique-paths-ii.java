class Solution {
    int m,n;
    int[][] dp = new int[101][101];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // int m = obstacleGrid.length;
        // int n = obstacleGrid[0].length;
        // int[][] dp = new int[m][n];
        // if (obstacleGrid[0][0] == 1) {
        //     return 0;
        // }

        // dp[0][0] = 1;
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (obstacleGrid[i][j] == 1) {
        //             dp[i][j] = 0;
        //             continue;
        //         }
        //         if (i == 0 || j == 0)
        //             dp[i][j] = 1;
        //         else {
        //             dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        //         }
        //     }
        // }
        // return dp[m - 1][n - 1];
        return solve(obstacleGrid, 0, 0);
    }

    public int solve(int[][] obstacleGrid, int i, int j){
         m = obstacleGrid.length;
         n = obstacleGrid[0].length;
       
                if(i>=m || j >=n || obstacleGrid[i][j]!=0)
                    return 0;
                if(dp[i][j] != 0)
                    return dp[i][j];
                if(i == m-1 && j == n-1)
                    return 1;

              int   right = solve(obstacleGrid, i, j+1);
               int   down = solve(obstacleGrid, i+1, j);    
        

        return dp[i][j] = right + down;

    }
}