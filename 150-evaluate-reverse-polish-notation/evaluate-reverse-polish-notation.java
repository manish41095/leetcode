class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        String operator = "+-*/";
        for (String token : tokens) {
            if (operator.indexOf(token) != -1) {
                int d2 = stack.pop();
                int d1 = stack.pop();
                int result = 0;
                if (token.equals("+")) {
                    result = d1 + d2;
                } else if (token.equals("-")) {
                    result = d1 - d2;
                } else if (token.equals("*")) {
                    result = d1 * d2;
                } else {
                    result = d1 / d2;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }

        }
        return stack.pop();
    }
}