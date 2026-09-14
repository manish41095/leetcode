class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        sum(1, k, n, temp, res);
        return res;

    }

    public void sum(int start, int kLeft, int sumNeeded, List<Integer> temp, List<List<Integer>> res) {

        if (kLeft == 0 && sumNeeded == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (kLeft < 0 || sumNeeded < 0)
            return;

        for (int i = start; i <= 9; i++) {
            if (i > sumNeeded)
                break;

            temp.add(i);
            sum(i + 1, kLeft - 1, sumNeeded - i, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}