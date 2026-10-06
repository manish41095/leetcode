class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int counter = 0;
        for(int i = 0; i < n ; i++){
            if(nums[i] == 0)
              continue;
            else{
                nums[counter++] = nums[i];
            }  
        }

        for(int i = counter ; i < n ;i++)
            nums[i] = 0;
        
    }
}