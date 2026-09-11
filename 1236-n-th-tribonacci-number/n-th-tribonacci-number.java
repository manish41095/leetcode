class Solution {
    static int ans = 0;
    public int tribonacci(int n) {
    
       // Base cases
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        
        // Starting values
        int t0 = 0, t1 = 1, t2 = 1;
        int nextTerm = 0;
        
        // Calculate up to n
        for (int i = 3; i <= n; i++) {
            nextTerm = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = nextTerm;
        }
        
        return nextTerm;
    }
   
}