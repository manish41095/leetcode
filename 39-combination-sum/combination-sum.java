class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(candidates, 0, 0, target, temp, result);

        return result;
        
    }

    public void solve(int[] candidates, int index, int sum ,int target, List<Integer> temp,
     List<List<Integer>> result){
        if(sum > target) return ;

        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            //sum += candidates[i];
            temp.add(candidates[i]);
            solve(candidates, i, sum  + candidates[i], target, temp, result);
            temp.remove(temp.size() - 1);
        }
     }
}