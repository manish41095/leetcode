class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            // Update the freq of the incoming character
            freq[s.charAt(right) - 'A']++;

            // Track the highest frequency of a single character in the window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int windowLen = right - left + 1;
            // Current window size is (right - left + 1)
            // If remaining characters to change > k, shrink the window from the left
            if (windowLen - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            windowLen = right - left + 1;

            // Keep track of the maximum valid window size found
            maxLen = Math.max(windowLen, maxLen);

        }

        return maxLen;

    }
}