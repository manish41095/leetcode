class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        // Map<Character, Integer> pCount = new HashMap<>();
        // Map<Character, Integer> sCount = new HashMap<>();
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        List<Integer> result = new ArrayList<>();

        // Count the frequency character of string p
        for (char c : p.toCharArray())
            pCount[c - 'a']++;

        // Sliding window and  count the frequency  char of String s

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;

            if (i >= p.length())
                sCount[s.charAt(i - p.length()) - 'a']--;

            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}