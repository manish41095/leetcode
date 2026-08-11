class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        // int count = 0;

        // for (int i = 0; i < n; i++) {
        //     if (i < n - 1 && nums[i] == nums[i + 1]) {
        //         continue;
        //     }
        //     nums[count++] = nums[i];

        // }
        // return count;

        int slow = 0;
        for(int i = 1; i<n ; i++){
            if(nums[slow] != nums[i] ){
                slow++;
                nums[slow] = nums[i];
                
            }
        }
        return slow+1;
    }
}