class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int leftProd = 1;
        int rightProd = 1;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            //If any of left or right product becomes 0 update it to 1 
            // Reset to 1 if the running product became 0
            if (leftProd == 0) leftProd = 1;
            if (rightProd == 0) rightProd = 1;

            leftProd *= nums[i];
            rightProd *= nums[n - 1 - i];

            ans = Math.max(ans, Math.max(leftProd, rightProd));

        }

        return ans;
    }
}