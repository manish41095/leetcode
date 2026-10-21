class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        List<Integer> temp = new ArrayList<>();
        solve(1, result, temp, n, k);

        return result;

    }

    public void solve(int start, List<List<Integer>> result, List<Integer> temp, int n, int k) {

        // Base case: combination reached the target size k
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // Pruning Optimization: 
        // Ensure there are enough elements left to make a valid combination of size k.
        // If (k - current.size()) is greater than the available numbers left, stop the loop.
        int remainingNeeded = k - temp.size();
        for (int i = start; i <= n - remainingNeeded + 1; i++) {
            temp.add(i);
            solve(i + 1, result, temp, n, k);
            temp.remove(temp.size() - 1);
        }
    }
}
