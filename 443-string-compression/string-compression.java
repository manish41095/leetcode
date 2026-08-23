class Solution {
    public int compress(char[] chars) {
        // Approach1 with extra space 
        //    StringBuilder sb = new StringBuilder();
        //    int count = 1;
        //    int i = 1;
        //    sb.append(chars[0]);

        //    while(i < chars.length){
        //     if(chars[i] == chars[i-1]){
        //         count++;
        //     }
        //     else{
        //         if(count>1){
        //             sb.append(count);
        //             count = 1;
        //         }
        //         sb.append(chars[i]);
        //     }
        //     i++;
        //    }
        //     if(count>1){
        //             sb.append(count);
        //         }

        //      for(int j = 0; j < sb.length(); j++)
        //       chars[j] = sb.charAt(j);   
        //    return sb.toString().length();

        //Approach2 without extra space

        int write = 0;
        int read = 0;
        int n = chars.length;
        while (read < n) {
            char curr = chars[read];
            int count = 0; 
            while (read < n && chars[read] == curr) {
                read++;
                count++;
            }

            chars[write++] = curr;

            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray())
                    chars[write++] = c;
            }
        }

        return write;
    }
}