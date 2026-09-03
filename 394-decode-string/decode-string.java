class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for(char ch : s.toCharArray()){
          if(Character.isDigit(ch)){
            //Handle multi digit number - 12[a]
            k = k*10 + ch - '0';
          }
          else if(ch == '['){
            countStack.push(k);
            k = 0;
            stringStack.push(currentString);
            currentString = new StringBuilder();
           // continue;
          }
         else if (ch == ']') {
                // Decode the current segment
                StringBuilder decodedSegment = currentString;
                int repeatCount = countStack.pop();
                
                // Retrieve the string state before this bracket opened
                currentString = stringStack.pop();
                
                // Append the repeated segment to the previous context
                while (repeatCount > 0) {
                    currentString.append(decodedSegment);
                    repeatCount--;
                }
            } else {
                // Ordinary character, append to the current working string
                currentString.append(ch);
            }
        }

        return currentString.toString();
        
    }
}