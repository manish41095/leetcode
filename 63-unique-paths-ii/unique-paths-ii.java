class Solution {
    int m, n;
    int[][] dp = new int[101][101];

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        return solve(obstacleGrid, 0, 0);
    }

    public int solve(int[][] obstacleGrid, int i, int j) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;

        if (i >= m || j >= n || obstacleGrid[i][j] != 0)
            return 0;

        if (dp[i][j] != 0)
            return dp[i][j];
            
        if (i == m - 1 && j == n - 1)
            return 1;

        int right = solve(obstacleGrid, i, j + 1);
        int down = solve(obstacleGrid, i + 1, j);

        return dp[i][j] = right + down;

    }
}