class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int read = 0;
        int n = chars.length;
        while(read < n){
            char currChar = chars[read];
            int count = 0;
            while(read < n && currChar == chars[read])
            {
                count++;
                read++;
            }
            chars[write++] = currChar ;

            if(count > 1)
             for (char digit : Integer.toString(count).toCharArray()) {
                    chars[write++] = digit;
                }
        }

        return write;
       
    }
}