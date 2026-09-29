class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(strs);
       // char[] first = strs[0].toCharArray();
        //char[] last = strs[strs.length-1].toCharArray();

        int n = strs.length;

        String first = strs[0];
        String last = strs[n-1];
       
       for (int i = 0 ; i < first.length() ; i++){
        if(first.charAt(i) != last.charAt(i))
            break;
        result.append(first.charAt(i));
       }
      return result.toString();
    }
}