class Solution {
    public boolean wordPattern(String pattern, String s) {
        // Map<Character, String> map = new HashMap<>();
        // String[] values = s.split(" ");
        // if(pattern.length()!=values.length){
        //     return false;
        // }
        // for(int i = 0; i < pattern.length(); i++){
        //     char key = pattern.charAt(i);
        //     String value = values[i];
        //     if(!map.containsKey(key)){
        //         if(!map.containsValue(value)){
        //           map.put(key,value);
        //         }
        //         else
        //             return false;
        //     }
        //     else{
        //         String mapValue = map.get(key);
        //         if(!mapValue.equals(value)){
        //             return false;
        //         }
        //     }
        // }
        // return true;
        

     
       Map<Character, String> map = new HashMap<>();
       String[] values = s.split(" ");

       if(pattern.length()!= values.length)  return false;

       for(int i = 0 ; i < values.length; i++){
        char key = pattern.charAt(i);
        String value = values[i];
        if(!map.containsKey(key)){
            if(!map.containsValue(value)){
                map.put(key,value);
            }
            else return false;
            

        }
        else{
            String getValue = map.get(key);
            if(!value.equals(getValue))
              return false;

        }

       }
       return true;
















    }
}