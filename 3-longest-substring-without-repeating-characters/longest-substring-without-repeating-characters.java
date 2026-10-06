class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int start = 0;
        int maxLen = 0;

        for(int end = 0; end < s.length(); end++){
            char ch = s.charAt(end);

            while(set.contains(ch)){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(ch);
            int currLen = end - start + 1;
            maxLen = Math.max(currLen, maxLen);
        }

        return maxLen;
    }
}