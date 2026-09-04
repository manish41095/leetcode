class Solution {
    public String reverseVowels(String s) {

        // char[] arr = s.toCharArray();

        // String vowels = "aeiouAEIOU";
        // int start = 0;
        // int end = s.length() - 1;

        // while (start < end) {
        //     // Find fist vowel from start exit from while and then check for 2nd vowel and so on
        //     while (start < end) {
        //         char ch = arr[start];
        //         if (vowels.indexOf(ch) != -1)
        //             break;
        //         start++;
        //     }
        //     // Find first vowel from last exit from while and then check for 2nd vowel and so on
        //     while (start < end) {
        //         char ch = arr[end];
        //         if (vowels.indexOf(ch) != -1)
        //             break;
        //         end--;
        //     }
        //     // Here swap first from start and first from end vowel and so on
        //     if (start < end) {
        //         char temp = arr[start];
        //         arr[start] = arr[end];
        //         arr[end] = temp;
        //         start++;
        //         end--;
        //     }
        // }

        // return new String(arr);

        if (s == null || s.length() <= 1) {
            return s;
        }

        // Convert the string to a character array for in-place swapping
        char[] chars = s.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        String vowels = "aeiouAEIOU";

        while (start < end) {
            // Move start pointer forward if it's not a vowel (indexOf returns -1)
            while (start < end && vowels.indexOf(chars[start]) == -1) {
                start++;
            }
            // Move end pointer backward if it's not a vowel (indexOf returns -1)
            while (start < end && vowels.indexOf(chars[end]) == -1) {
                end--;
            }

            // Swap the vowels
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            // Move pointers inward
            start++;
            end--;
        }

        return new String(chars);

    }

}