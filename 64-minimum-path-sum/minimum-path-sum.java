class Solution {

    public int solve(int[][] grid, int i, int j, int[][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }
        if (dp[i][j] != -1)
            return dp[i][j];

        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        
        // if (j + 1 < n) {
        //     right = solve(grid, i, j + 1, dp);
        // }

        // if (i + 1 < m) {
        //     down = solve(grid, i + 1, j, dp);
        // }
        
       

         if (i == m - 1) {//only go right
              dp[i][j] = grid[i][j] + solve(grid, i, j + 1, dp);
         } else if (j == n - 1) {//only go down
            dp[i][j] = grid[i][j] + solve(grid, i + 1, j, dp);
          } else if (i < m - 1 && j < n - 1) {
             dp[i][j] =  grid[i][j] + Math.min(solve(grid, i, j + 1,dp), solve(grid, i + 1, j, dp));
         }
       // dp[i][j] = grid[i][j] + Math.min(right, down);
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        //Arrays.fill(dp, -1); - This works on 1d array

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(grid, 0, 0, dp);
    }

}