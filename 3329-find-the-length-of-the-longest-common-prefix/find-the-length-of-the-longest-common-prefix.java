class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        Set<Integer> prefix = new HashSet<>();

        // Step 1: Insert all possible prefixes of numbers in arr1 into the HashSet
        for (int val : arr1) {
            while (val > 0) {
                prefix.add(val);
                // Strip the last digit to get the next prefix
                val = val / 10;
            }
        }

        int maxLength = 0;

        // Step 2: Search for matching prefixes using numbers in arr2
        for (int val : arr2) {

            while (val > 0) {
                if (prefix.contains(val)) {
                    // Calculate digit count of the matched prefix
                    int currLength = String.valueOf(val).length();
                    maxLength = Math.max(currLength, maxLength);
                    break; // Found the longest prefix for this number, move to next
                }
                val = val / 10;
            }
        }

        return maxLength;

    }
}