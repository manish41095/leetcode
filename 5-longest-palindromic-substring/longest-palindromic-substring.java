class Solution {
    public boolean isPalnidrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        //Without DP;
        int max = 0;
        int start = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalnidrome(s, i, j)) {
                    int len = j - i + 1;
                    if ( len > max) {
                        max = len;
                        start = i;
                    }
                    
                }

            }
        }
        return s.substring(start, start+max);
    }
}