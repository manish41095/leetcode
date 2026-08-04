class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //Convert dict into set for O(1) lookup time
        Set<String> wordSet = new HashSet<>(wordDict);

        //Find the max len of word in dict
        int maxLen = 0;

        for(String word : wordDict){
            maxLen = Math.max(maxLen, word.length());
        }

        //Create dp array to check segmentation till 0 to i;
        int n = s.length();

        boolean[] dp = new boolean[n+1];

        dp[0] = true;  //Base case for empty String

        for(int i = 1; i <= n; i++)
            // Check prefix till maxLen
            for(int j = i-1; j >= Math.max(0, i- maxLen); j--){
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break; // No need to check further prefixes
                }
            }
            return dp[n];

    }
}