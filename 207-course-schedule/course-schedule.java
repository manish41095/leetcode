class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
              // Build adjacency list and compute in-degree for every course
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            // Directed edge: prereq -> course
            adj.get(prereq).add(course);
            inDegree[course]++;
        }

        // Enqueue all courses with zero prerequisites
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            completedCourses++;

            // Unlock dependent courses
            for (int nextCourse : adj.get(curr)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // If all courses were completed, no cycle exists
        return completedCourses == numCourses;  
    }
}