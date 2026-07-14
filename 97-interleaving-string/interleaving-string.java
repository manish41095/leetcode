class Solution {
    private Boolean dp[][];
    public boolean solution(int i, int j, String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();

       // Both strings are fully consumed
      if (i == m && j == n) {
            return true;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }  

        int k = i + j;

        boolean result = false;

        // Pick the next character from s1
        if (i < m && s1.charAt(i) == s3.charAt(k)) {
            result = solution(i + 1, j, s1, s2, s3);
        }

        // Pick the next character from s2
        if (!result && j < n && s2.charAt(j) == s3.charAt(k)) {
            result = solution(i, j + 1, s1, s2, s3);
        }
        dp[i][j] = result;
        return dp[i][j];
     

     
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        dp = new Boolean[s1.length()+1][s2.length()+1];
        return solution(0, 0, s1, s2, s3);

    }
}