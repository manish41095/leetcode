class Solution {
    public String minWindow(String s, String t) {
     //Brute force   
    //  int minLen = Integer.MAX_VALUE;   
    //  int m = t.length();
    //  int n = s.length();
    //  int startIndex = 0;
    //  for(int i = 0 ; i < n ; i++){
    //     Map<Character, Integer> map = new HashMap<>();
    //     for(int j = 0 ; j < m ; j++ ){
    //         if(map.containsKey(t.charAt(j))){
    //             map.put(t.charAt(j),map.get(t.charAt(j))+1);
    //         }
    //         else{
    //           map.put(t.charAt(j),1);  
    //         }
    //     }
    //     int count = 0;
    //     for(int j = i ; j < n; j++){
    //         if(map.containsKey(s.charAt(j)) && map.get(s.charAt(j))> 0){
    //             count++;
    //             map.put(s.charAt(j),map.get(s.charAt(j)) - 1);
    //         }
    //         if(count == m){
    //             minLen  = Math.min(j-i+1, minLen);
    //             startIndex = i;
    //             break;
    //         }
    //     }
    //  }
    //   if (minLen == Integer.MAX_VALUE) {
    //         return "";
    //     }
    //  return s.substring(startIndex, startIndex + minLen);
    // }

    // Optimal 

     // Count characters in s
    int[] mapS = new int[256];

    // Count characters in t
    int[] mapT = new int[256];

    for (char ch : t.toCharArray())
      mapT[ch]++;

    String result = "";
    int right = 0, min = Integer.MAX_VALUE;

    // Two pointers of the sliding window: i(left), right
    for (int i = 0; i < s.length(); i++) {

      while (right < s.length() && !isDesirable(mapS, mapT)) {
        mapS[s.charAt(right)]++;

        // Extend the right pointer of the sliding window
        right++;
      }

      if (isDesirable(mapS, mapT) && min > right - i + 1) {
        result = s.substring(i, right);
        min = right - i + 1;
      }

      // Shrink the left pointer from i to i + 1
      mapS[s.charAt(i)]--;
    }

    return result;
  }

  // Runtime = O(256) = O(1)
  private boolean isDesirable(int[] mapS, int[] mapT) {
    // s should cover all characters in t
    for (int i = 0; i < mapT.length; i++) {
      if (mapT[i] > mapS[i])
        return false;
    }
    return true;
  }
}