class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        int[][] pair = new int[n][2];

        for(int i = 0; i < n ; i++){
            pair[i][0] = nums1[i];
            pair[i][1] = nums2[i];
        }

        Arrays.sort(pair, (a,b) -> Integer.compare(b[1], a[1]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long currSum = 0;
        long maxScore = 0;

        for(int i = 0 ; i < n ; i++){
            currSum += pair[i][0];
            minHeap.offer(pair[i][0]);

            if(minHeap.size() > k){
                currSum -=  minHeap.poll();
            }

            if(minHeap.size() == k){
                long currScore = currSum * pair[i][1];
                maxScore = Math.max(maxScore, currScore);
            }
        }
        return maxScore;
    }
}