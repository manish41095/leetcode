class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int curr = 1;
        int max = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i]>nums[i-1]){
                curr++;
                max = Math.max(max,curr);
            }
            else{
                curr = 1;
            }
        }
        return max;
    }
}