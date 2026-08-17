class Solution {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
        }

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1); // This means sum = 0 at index = -1 base case for hash map

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum)) {
                int prevIndex = map.get(sum);
                int length = i - prevIndex;
                maxLength = Math.max(length, maxLength);
            } else {
                map.put(sum, i);
            }
        }

        return maxLength;

    }
}