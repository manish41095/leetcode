class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result  = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(result, temp , nums);

        return  result;     
    }
    public void solve (List<List<Integer>> result, List<Integer> temp, int[] nums ){

        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int num : nums){
            if(temp.contains(num)) continue;
            temp.add(num);
            solve(result, temp, nums);
            temp.remove(temp.size()-1);
        }
    }
}