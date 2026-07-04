class Solution {
   static class Pair {
        int i;
        int j;
        long sum;

        Pair(int i, int j, long sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
                (a, b) -> Long.compare(a.sum, b.sum)
        );

        // Add first element of nums2 with first k elements of nums1
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new Pair(i, 0, (long) nums1[i] + nums2[0]));
        }

        while (k > 0 && !minHeap.isEmpty()) {

            Pair current = minHeap.poll();

            int i = current.i;
            int j = current.j;

            result.add(Arrays.asList(nums1[i], nums2[j]));

            // Move to next element in nums2 for the same nums1[i]
            if (j + 1 < nums2.length) {
                minHeap.offer(new Pair(i, j + 1, (long) nums1[i] + nums2[j + 1]));
            }

            k--;
        }

        return result;
    }

}