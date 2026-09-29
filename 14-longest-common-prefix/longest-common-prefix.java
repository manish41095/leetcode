class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Approach1
        // StringBuilder result = new StringBuilder();
        // Arrays.sort(strs);
        // int n = strs.length;

        // String first = strs[0];
        // String last = strs[n - 1];

        // for (int i = 0; i < first.length(); i++) {
        //     if (first.charAt(i) != last.charAt(i))
        //         break;
        //     result.append(first.charAt(i));
        // }
        // return result.toString();

        //Optimal Approach 29-09-26

        if (strs == null || strs.length == 0)
            return "";

        String first = strs[0];

        // Loop through each character of the first string
        for (int i = 0; i < first.length(); i++) {

            char ch = first.charAt(i);

            // Compare this character with the same position in all other strings
            for (int j = 1; j < strs.length; j++) {

                // Stop if we hit the end of a string or find a mismatch
                if (i == strs[j].length() || strs[j].charAt(i) != ch) {
                    return first.substring(0, i);
                }
            }
        }

        return first;

    }
}