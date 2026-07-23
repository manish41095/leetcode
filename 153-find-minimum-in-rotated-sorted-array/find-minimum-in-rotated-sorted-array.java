class Solution {
    public int findMin(int[] nums) {
        // int pivot = 0;
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i - 1] > nums[i])
        //         pivot = i;
        // }
        // return nums[pivot];
        int low = 0 ;
        int high = nums.length-1;
        while(low < high){
            int mid  = low + (high-low)/2;
            if(nums[mid] > nums[high])
              low = mid + 1;
            else{
                high = mid;
            }
        }
        return nums[low];
    }

}