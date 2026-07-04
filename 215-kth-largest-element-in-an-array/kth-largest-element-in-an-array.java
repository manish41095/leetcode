class Solution {
    public int findKthLargest(int[] nums, int k) {
      //Approach1
       Arrays.sort(nums);
       return nums[nums.length - k];
        
    }
}