class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length && k > 0; i++){
            if(nums[i] < 0){
            nums[i] = -nums[i];
            k--;
            }
            else{
                break;
            }
        }
        int minValue  = Integer.MAX_VALUE;
        for(int val : nums){
        sum +=val;
        minValue = Math.min(minValue, Math.abs(val));
        }
        if(k%2==1){
            sum -= 2*minValue;
        }
       return sum; 
    }
}