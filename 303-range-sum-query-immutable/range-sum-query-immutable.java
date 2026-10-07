class NumArray {
    private int[] prefixSums;
    public NumArray(int[] nums) {
        int n = nums.length;
        prefixSums = new int[n+1];
        for(int i = 0; i < n ; i++){
             prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
       return prefixSums[right + 1] - prefixSums[left]; 
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */