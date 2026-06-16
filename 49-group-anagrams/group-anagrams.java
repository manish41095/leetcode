class Solution {
    public String getCharCount(String s){
        int[] charCount = new int[26];
        char[] sToChar = s.toCharArray();
        for(char c : s.toCharArray()){
            charCount[c - 'a' ]++;
        }

        StringBuilder sb = new StringBuilder("");
        char c = 'a';
        for(int i : charCount){
            sb.append(c);
            sb.append(i);
            c++;
        }
        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> res = new HashMap<>();

        for(int i = 0; i < strs.length ; i++){
            //char[] strToChar = strs[i].toCharArray();
           // Arrays.sort(strToChar);
          //  String sortedStr = new String(strToChar);
            String sortedStr = getCharCount(strs[i]);
            if(res.containsKey(sortedStr))
            res.get(sortedStr).add(strs[i]);
            else{
                List<String> str = new ArrayList<>();
                str.add(strs[i]);
                res.put(sortedStr, str);
            }
         }
        return new ArrayList<>(res.values());
    }
}