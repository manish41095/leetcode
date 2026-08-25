class Solution {
    public int largestInteger(int[] nums, int k) {
        // Approach1
        // int[] count = new int[51];
        // int n = nums.length;

        // for(int i = 0 ; i <= n-k ; i++){
        //     boolean[] seen = new boolean[51];
        //     for(int j = i ; j < i+ k ; j++){
        //         if(!seen[nums[j]]){
        //         count[nums[j]]++;
        //         seen[nums[j]] = true;
        //         }
        //     }
        // } 

        // int ans = -1;
        // for(int x = 0 ; x < count.length; x++){
        //     if(count[x] == 1)
        //     ans = x;
        // }

        // return ans;

        //Approach 2

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        // Count total frequencies of each number in the array
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        // Case 1: Subarray size is 1
        // Every element forms its own subarray. We need the max element with frequency 1.
        if (k == 1) {
            int max = -1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    max = Math.max(max, entry.getKey());
                }
            }
            return max;
        }

        //if any element appear more than one time in same sub array that will not be conidered
        //two  apperance its conside only one apperance it will conside two only if it 
        //appear   in two different sub array

        // Case 2: Subarray size equals the whole array length
        // There is only 1 subarray. Every element appears in it exactly once.
        if (k == n) {
            int max = -1;
            for (int num : nums)
                max = Math.max(max, num);

            return max;
        }

        // Case 3: 1 < k < n
        // Only the first and last elements can appear in exactly one subarray of size k.
        // Elements in the middle will always appear in multiple subarrays.

        int firstNum = nums[0];
        int lastNum = nums[n - 1];
        int max = -1;

        int firstCount = map.get(firstNum);
        int lastCount = map.get(lastNum);

        if (firstCount == 1)
            max = Math.max(firstNum, max);

        if (lastCount == 1)
            max = Math.max(lastNum, max);

        return max;

    }
}