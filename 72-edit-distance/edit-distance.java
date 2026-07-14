class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        //Consider empty string as well
        int[][] dp = new int[m+1][n+1];

        //Intialyze dp matrix
        for(int i=1; i<=m;i++) dp[i][0] = i;
        for(int j=1; j<=n; j++) dp[0][j] =j;

        for(int i = 1; i <= m ; i++)
            for(int j = 1; j <=n; j++)

            //Same character
            if(word1.charAt(i-1)==word2.charAt(j-1))
                dp[i][j] = dp[i-1][j-1];
            //Take minimum from 3 adjacent matrix cell and add +1   
            else{
                int topLeft = dp[i-1][j-1];
                int top = dp[i-1][j];
                int left = dp[i][j-1];

                dp[i][j] = 1 + Math.min(topLeft, Math.min(top,left));
            }    
        return dp[m][n];
    }
}