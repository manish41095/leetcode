class Solution {
    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();

        String vowels = "aeiouAEIOU";
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {

            while (i < j) {
                char ch = arr[i];
                if (vowels.indexOf(ch) != -1)
                    break;
                i++;
            }

            while (i < j) {
                char ch = arr[j];
                if (vowels.indexOf(ch) != -1)
                    break;
                j--;
            }

            if (i < j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return new String(arr);

    }
}