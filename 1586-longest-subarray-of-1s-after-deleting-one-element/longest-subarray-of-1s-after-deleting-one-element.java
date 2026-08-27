class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int n = nums.length;
        int zeroCount = 0;
        int maxCount = 0;

        for(int right = 0 ; right < n ; right++){
            if(nums[right] == 0)
              zeroCount++;
            while(zeroCount > 1){
                if(nums[left] == 0)
                    zeroCount--;
                left++;    
            } 
            maxCount = Math.max(maxCount , right - left); 
        }

        return maxCount;
        
    }
}