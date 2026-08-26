class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        // approach1 - two pointer ,  TC O(nlogn) & SC - O(1);
        // int i = 0;
        // int j = n-1;
        // int count = 0;
        // Arrays.sort(nums);
        // while(i < j){
        //     int sum = nums[i] + nums[j];
        //     if(sum == k){
        //         i++;
        //         j--;
        //         count++;
        //     }
        //     else if(sum < k){
        //         i++;
        //     }
        //     else{
        //         j--;
        //     }
        // }

        // return count;

        // approach2 - HashMap ,  TC O(n) & SC - O(n); 
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int p1 = k - num;
            if (map.getOrDefault(p1, 0) > 0) {
                count++;
                map.put(p1, map.get(p1) - 1);
            }

            else
                map.put(num, map.getOrDefault(num, 0) + 1);

        }
        return count;
    }
}