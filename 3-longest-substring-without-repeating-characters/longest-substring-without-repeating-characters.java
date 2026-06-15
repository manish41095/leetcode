class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> charSet = new HashSet<>();
        int maxLen = 0;
        int start = 0;
        for(int end = 0 ; end < s.length(); end ++){
            while(charSet.contains(s.charAt(end))){
                charSet.remove(s.charAt(start));
                start++;
            }

            charSet.add(s.charAt(end));
            maxLen = Math.max(maxLen, end-start+1);
        }
      return maxLen;  
    }
}