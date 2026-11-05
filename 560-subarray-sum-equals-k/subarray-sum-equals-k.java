class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // Base case: A prefix sum of 0 has occurred 1 time
        // This handles subarrays that sum to k starting right from index 0
        map.put(0, 1);
        for (int num : nums) {
            prefixSum += num;

            int target = prefixSum - k;

            if (map.containsKey(target))
                count += map.get(target);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;

    }
}