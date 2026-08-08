class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");

        Stack<String> stack = new Stack();

        for (String str : arr) {
            if (str.equals("..") && !stack.isEmpty())
                stack.pop();
            if (!str.equals("") && !str.equals(".") && !str.equals(".."))
                stack.push(str);
        }

        StringBuilder sb = new StringBuilder();
        for (String str : stack) {
            sb.append("/");
            sb.append(str);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}