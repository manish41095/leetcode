class Solution {
    public boolean isIsomorphic(String s, String t) {
       //Revision 01-10-2026
        if (s.length() != t.length())
            return false;

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);
            if (!map.containsKey(key)) {
                if (!map.containsValue(value)) {
                    map.put(key, value);
                } else {
                    return false;
                }
            }

            else {
                char mapChar = map.get(key);
                if (mapChar != value)
                    return false;
            }
        }

        return true;
    
        // if(s.length()!=t.length())
        //     return false;
        // Map<Character, Character> charMap = new HashMap<>();

        // for(int i = 0; i < s.length(); i++){
        //     char original = s.charAt(i);
        //     char replace = t.charAt(i);

        //     if(!charMap.containsKey(original)){
        //         if(!charMap.containsValue(replace)){
        //             charMap.put(original,replace);
        //         }
        //         else{
        //             return false;
        //         }
        //     }
        //     else{
        //         char mappedChar = charMap.get(original);
        //         if(mappedChar != replace)
        //           return false;
        //     }
        // }
        
        // return true;
    }
}