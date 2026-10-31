class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer, Integer> sumCount = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
            }
        }

        for (int num3 : nums3) {

            for (int num4 : nums4) {
                int sum = num3 + num4;
                if (sumCount.containsKey(-1 * sum))
                    count += sumCount.get(-1 * sum);
            }
        }

        return count;

    }
}