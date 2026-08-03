class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> result  = new ArrayList<>();

        solve("",0,0,n,result);

        return result;
        
    }

    public void solve(String curr, int open, int close, int total, List<String> result){
        if(curr.length() == 2*total)
        {
            result.add(curr);
            return;
        }

        if(open < total){
            solve(curr + "(" , open+1, close, total , result);
        }
        if(close < open){
            solve(curr + ")" , open , close+1, total, result);
        }
    }
}