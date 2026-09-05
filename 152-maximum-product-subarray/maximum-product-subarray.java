class Solution {
    public int maxProduct(int[] nums) {
     int n = nums.length;
     int leftProd = 1;
     int rightProd = 1;
     int ans = nums[0];



      for(int i = 0; i < n ; i++){
       //If any of left or right product becomes 0 update it to 1 
       leftProd = leftProd == 0 ? 1 : leftProd;
       rightProd = rightProd == 0 ? 1 : rightProd;

       leftProd *= nums[i];
       rightProd *= nums[n-1-i];

       ans = Math.max(ans, Math.max(leftProd, rightProd));


      } 

      return ans;
    }
}