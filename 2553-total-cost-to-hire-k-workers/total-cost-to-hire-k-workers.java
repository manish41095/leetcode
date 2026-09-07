class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<Integer> minHeap1 = new PriorityQueue<>();
        PriorityQueue<Integer> minHeap2 = new PriorityQueue<>();

        long cost = 0;
        int left = 0;
        int right = costs.length - 1;

        while(k > 0){

            while(minHeap1.size() < candidates && left <= right){
                minHeap1.offer(costs[left]);
                left++;
            }

             while(minHeap2.size() < candidates && right >= left){
                minHeap2.offer(costs[right]);
                right--;
            }

            int min1 = minHeap1.size() > 0 ? minHeap1.peek() : Integer.MAX_VALUE;
            int min2 = minHeap2.size() > 0 ? minHeap2.peek() : Integer.MAX_VALUE;

            if(min1 <= min2)
            {
                cost +=min1;
                minHeap1.poll();
            }
            else{
                cost +=min2;
                minHeap2.poll();
            }

            k--;

        }
      return cost;

        
    }
}