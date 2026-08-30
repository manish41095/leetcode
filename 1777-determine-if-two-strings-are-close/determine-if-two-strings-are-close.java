class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n != m)
            return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (char ch : word1.toCharArray())
            count1[ch - 'a']++;
        for (char ch : word2.toCharArray())
            count2[ch - 'a']++;

        for (int i = 0; i < 26; i++) {
            if ((count1[i] == 0 && count2[i] != 0) || (count2[i] == 0 && count1[i] != 0))
                return false;
        }

        Arrays.sort(count1);
        Arrays.sort(count2);

        return Arrays.equals(count1, count2);
    }
}