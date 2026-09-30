class Solution {

    // public boolean isPalnidrome(String s, int i, int j) {
    //     while (i < j) {
    //         if (s.charAt(i) != s.charAt(j)) {
    //             return false;
    //         } else {
    //             i++;
    //             j--;
    //         }
    //     }
    //     return true;
    // }

    // public String longestPalindrome(String s) {
    //     //Without DP;
    //     int max = 0;
    //     int start = 0;
    //     int n = s.length();
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i; j < n; j++) {
    //             if (isPalnidrome(s, i, j)) {
    //                 int len = j - i + 1;
    //                 if ( len > max) {
    //                     max = len;
    //                     start = i;
    //                 }

    //             }

    //         }
    //     }
    //     return s.substring(start, start+max);
    // }

    //Approach2 
    

    int maxLen = 0;
    int start = 0;

    public  String longestPalindrome(String s){
        if(s.length() < 2)
            return s;

        for(int i = 0; i < s.length() - 1; i++){

            //Odd length Palindrome
            expand(s, i, i);
            //Even length Palindrome
            expand(s, i, i+1);
        }  

        return s.substring(start, start + maxLen);  
    }

    public void expand(String s, int begin, int end){

        while(begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)){
            int len = end - begin + 1;

            if(maxLen < len){
                maxLen = len;
                start = begin;
            }

            begin--;
            end++;
        }
    }
}


