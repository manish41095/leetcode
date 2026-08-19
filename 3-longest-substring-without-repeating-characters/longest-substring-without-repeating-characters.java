class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> charSet = new HashSet<>();
        int maxLen = 0;
       
        int start = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            while(charSet.contains(c)){
              charSet.remove(s.charAt(start));
              start++;
            }

            charSet.add(c);
            maxLen = Math.max(maxLen, i - start + 1);  
            
        }

        return maxLen;
    }
}