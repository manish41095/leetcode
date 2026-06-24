class Solution {
    public List<Integer> findDuplicates(int[] nums) {
       int n = nums.length;
       Set<Integer> set = new HashSet<>();
       List<Integer> result  = new ArrayList<>();
       for(int i = 0 ; i < n ; i ++){
        if(set.contains(nums[i])){
            result.add(nums[i]);
        }
        else{
            set.add(nums[i]);
        }
       }
       return result;
    }
}