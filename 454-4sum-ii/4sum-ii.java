class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer, Integer> sumCount = new HashMap<>();
        int count = 0;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
            }
        }

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int sum = -(num3 + num4);
                if (sumCount.containsKey(sum))
                    count += sumCount.getOrDefault(sum, 0);
            }
        }

        return count;

    }
}