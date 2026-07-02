class Solution {
    public int[] productExceptSelf(int[] nums) {
        // int n = nums.length;
        // int[] left = new int[n];
        // int[] right = new int[n];

        // left[0] = 1;
        // for(int i = 1; i<n ;i++){
        //     left[i] = left[i-1] * nums[i-1];
        // }

        // right[n-1] = 1;
        // for(int i = n-2; i>=0; i--){
        //     right[i] = right[i+1] * nums[i+1];
        // }

        // int[] ans = new int[n];
        // for(int i = 0 ; i < n; i++ ){
        //     ans[i] = left[i]*right[i];
        // }
        // return ans;

        //Approach 2 
        int n = nums.length;
        int prod = 1;
        int[] ans = new int[n];

        for(int i = 0 ; i < n; i++){
            ans[i] = prod;
            prod *= nums[i];
        }

        prod = 1;

        for(int i = n-1; i >=0; i--){
            ans[i] = prod*ans[i];
            prod *= nums[i];
        }
        return ans;
    }
}