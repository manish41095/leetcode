class Solution {
    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    grid[r][c] = '0';
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{r, c});

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        for (int[] d : dirs) {
                            int nr = curr[0] + d[0];
                            int nc = curr[1] + d[1];
                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0'; // Mark visited BEFORE offering to avoid duplicates
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }
        return islands;
        
    }
}