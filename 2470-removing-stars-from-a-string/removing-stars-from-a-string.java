class Solution {
    public String removeStars(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack();

        for (char ch : s.toCharArray()) {
            if (ch != '*')
                st.push(ch);
            else
                st.pop();
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}