class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/ 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)     
                low = mid + 1;
            else
                high = mid - 1;        
        }

        return low;
       











        //Approach1
        // int ans = 0;
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] >= target){
        //         ans = i;
        //         break;
        //     }

        // }
        // if (nums[n - 1] < target)
        //     ans = n;
        // return ans;
    }

}