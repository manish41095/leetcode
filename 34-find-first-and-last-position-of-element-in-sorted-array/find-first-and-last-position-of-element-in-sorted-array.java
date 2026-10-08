class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };

        result[0] = findIndex(nums, target, true);
        result[1] = findIndex(nums, target, false);

        return result;
    }

    private int findIndex(int[] nums, int target, boolean isFirst) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                index = mid;
                if (isFirst) {
                    high = mid - 1; //Keep searching left half for the *first* position
                } else {
                    low = mid + 1; //Keep searching right half for the *last* position
                }
            }

            else if (nums[mid] < target)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return index;
    }

    // public int[] searchRange(int[] nums, int target) {

    //     int left = findLeftIndex(nums, target);
    //     int right = findRightIndex(nums, target);
    //     return new int[]{left,right};
    // }
    // private int findLeftIndex(int[] nums, int target){
    //     int index = -1;
    //     int low = 0;
    //     int high = nums.length-1;
    //     while(low <= high ){
    //         int mid  = low + (high - low)/2;
    //         if(nums[mid] == target){
    //             index = mid;
    //             high = mid - 1; //search in the left sub array
    //         }
    //         else if(nums[mid] < target){
    //             low = mid + 1;
    //         }
    //         else{
    //             high = mid - 1;
    //         }
    //     }

    //     return index;
    // }

    // private int findRightIndex(int[] nums, int target){
    //     int index = -1;
    //     int low = 0;
    //     int high = nums.length-1;
    //     while(low <= high ){
    //         int mid  = low + (high - low)/2;
    //         if(nums[mid] == target){
    //             index = mid;
    //             low = mid + 1; //search in the right  sub array
    //         }
    //         else if(nums[mid] < target){
    //             low = mid + 1;
    //         }
    //         else{
    //             high = mid - 1;
    //         }
    //     }

    //     return index;
    // }
}