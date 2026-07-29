class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int maxSide = 0;
        int[][] dp = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
              if(matrix[i][j] == '1'){
                if(i==0 || j==0){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
                maxSide  = Math.max(maxSide, dp[i][j]);
              }
            }
        }

        return maxSide*maxSide;
    }
}