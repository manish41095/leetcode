class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        int rowSize = grid.length;
        int colSize = grid[0].length;

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                boolean isEqual = true;

                for (int i = 0; i < rowSize; i++) {
                    if (grid[row][i] != grid[i][col]) {
                        isEqual = false;
                        break;
                    }
                }
                
                if (isEqual) {
                    count++;
                }

            }
        }

        return count;

    }
}