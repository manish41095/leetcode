class Solution {
    //Revision 04-10-2026
    public boolean isPalindrome(String s) {
      String cleanStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

      int n = cleanStr.length();

      for(int i = 0; i < n/2; i++){
            if(cleanStr.charAt(i) != cleanStr.charAt(n-i-1)){
                return false;
            }
      }
      return true; 
    }
}