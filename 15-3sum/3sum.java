class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);//First sort the array
        Set<List<Integer>> triplet = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    triplet.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
                else if (sum > 0){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
      return new ArrayList<>(triplet);  
    }
}