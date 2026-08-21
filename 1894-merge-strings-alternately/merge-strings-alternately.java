class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int n = word1.length();
        int m = word2.length();

        for (int i = 0; i < m + n; i++) {
            if (i < n) {
                sb.append(word1.charAt(i));
            }
            if (i < m) {
                sb.append(word2.charAt(i));
            }
        }

        return sb.toString();
    }
}