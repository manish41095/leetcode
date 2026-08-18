class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        List<Integer> result = new ArrayList<>();
        int pLen = p.length();
        // Count the frequency of character in string p
        for (char c : p.toCharArray())
            pCount[c - 'a']++;

        // Sliding window and  count the frequency  of char in String s
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;

            //Remove the character that is out of the window
            if (i >= p.length())
                sCount[s.charAt(i - pLen) - 'a']--;

            if (Arrays.equals(pCount, sCount)) {
                result.add(i - pLen + 1);
            }
        }
        return result;
    }
}