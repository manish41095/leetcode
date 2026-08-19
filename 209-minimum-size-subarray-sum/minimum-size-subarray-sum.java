class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int result = Integer.MAX_VALUE;
        int currSum = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            while (currSum >= target) {
                result = Math.min(result, i - left + 1);
                currSum -= nums[left];
                left++;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;

        // int minLenWindow = Integer.MAX_VALUE;
        // int currSum = 0;
        // int low = 0;
        // int high = 0;

        // while(high < nums.length){
        //     currSum += nums[high];
        //     high++;

        //     while(currSum >= target){
        //         int currWindowSize = high - low;
        //         minLenWindow = Math.min(currWindowSize, minLenWindow);

        //         currSum -= nums[low];
        //         low++;
        //     }
        // }

        // return minLenWindow == Integer.MAX_VALUE ? 0 : minLenWindow;
    }
}