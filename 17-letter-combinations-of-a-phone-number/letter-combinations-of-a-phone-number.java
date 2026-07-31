class Solution {
    Map<Character, String> map = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        if(digits.length()==0)
        return result;
        StringBuilder temp = new StringBuilder();
        solve(0, digits, temp);
        return result;
    }

    public void solve(int id, String digits, StringBuilder temp) {
        int n = digits.length();
        if (id == n) {
            result.add(temp.toString());
            return;
        }

        char ch = digits.charAt(id);
        String str = map.get(ch);

        for (char c : str.toCharArray()) {
            temp.append(c);
            solve(id + 1, digits, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}