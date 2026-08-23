class Solution {
    public int compress(char[] chars) {
        //String str = new String(chars);
       StringBuilder sb = new StringBuilder();
       int count = 1;
       int i = 1;
       sb.append(chars[0]);

       while(i < chars.length){
        if(chars[i] == chars[i-1]){
            count++;
        }
        else{
            if(count>1){
                sb.append(count);
                count = 1;
            }
            sb.append(chars[i]);
        }
        i++;
       }
        if(count>1){
                sb.append(count);
            }

         for(int j = 0; j < sb.length(); j++)
          chars[j] = sb.charAt(j);   
       return sb.toString().length();
    }
}