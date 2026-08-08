class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");

        Stack<String> stack = new Stack();

        // for (String str : arr) {
        //     if (str.equals("..") && !stack.isEmpty())
        //         stack.pop();
        //     if (!str.equals("") && !str.equals(".") && !str.equals(".."))
        //         stack.push(str);
        // }
        // Both for loop correct below one simplified
        for (String str : arr) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!str.equals("") && !str.equals(".")) {
                stack.push(str);
            }
        }


        StringBuilder sb = new StringBuilder();
        for (String str : stack) {
            sb.append("/");
            sb.append(str);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}