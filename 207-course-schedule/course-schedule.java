class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
               List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            adj.get(pair[1]).add(pair[0]);
        }

        // 0 = unvisited, 1 = visiting (on current recursion stack), 2 = safe
        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasCycle(i, adj, state)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int node, List<List<Integer>> adj, int[] state) {
        state[node] = 1; // Mark as currently visiting

        for (int neighbor : adj.get(node)) {
            if (state[neighbor] == 1) {
                return true; // Back-edge found -> cycle exists
            }
            if (state[neighbor] == 0 && hasCycle(neighbor, adj, state)) {
                return true;
            }
        }

        state[node] = 2; // Mark as completely explored and cycle-free
        return false;
    }
}