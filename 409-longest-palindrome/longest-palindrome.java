class Solution {
    public int longestPalindrome(String s) {

        int[] count = new int[128]; // Use 128 bcz asci value small and large alphabet in bewteen 65 - 90 and 97 to 122;
        int res = 0;

        for(char c : s.toCharArray())
        {
            count[c]++;
        }

        for(int i = 0 ; i < 128; i++){
            int value  = count[i];
            res += (value/2)*2;
            if(res%2 == 0 && value%2 != 0)
            {
                res++;
            }
        }
        return res;
    }
}