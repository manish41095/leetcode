class Solution {
    public int searchInsert(int[] nums, int target) {

        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] < target)
                continue;
            if(nums[i] >= target)
                return i;  

        }
        if(nums[n-1]<target)
         return n;
        return 0; 
    }

   
}