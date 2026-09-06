class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        int[][] pair = new int[n][2];

        // Step 1: Pair up nums1 and nums2 elements
        for (int i = 0; i < n; i++) {
            pair[i][0] = nums1[i];
            pair[i][1] = nums2[i];
        }

        // Step 2: Sort the pairs based on nums2 in descending order
        Arrays.sort(pair, (a, b) -> Integer.compare(b[1], a[1]));

        // Min-heap to keep track of the top k elements from nums1
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long currSum = 0;
        long maxScore = 0;

        // Step 3: Iterate through the sorted pairs
        for (int i = 0; i < n; i++) {
            currSum += pair[i][0];
            minHeap.offer(pair[i][0]);

            // If we have more than k elements, remove the smallest nums1 element
            if (minHeap.size() > k) {
                currSum -= minHeap.poll();
            }

            // When we have exactly k elements, update the max score
            if (minHeap.size() == k) {
                // pairs[i][1] is the minimum nums2 value in our current window
                long currScore = currSum * pair[i][1];
                maxScore = Math.max(maxScore, currScore);
            }
        }
        return maxScore;
    }
}