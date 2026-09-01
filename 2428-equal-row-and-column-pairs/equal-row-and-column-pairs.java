class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        int rowSize = grid.length;
        int colSize = grid[0].length;
        //Brute Force Approach
        // for (int row = 0; row < rowSize; row++) {
        //     for (int col = 0; col < colSize; col++) {
        //         boolean isEqual = true;

        //         for (int i = 0; i < rowSize; i++) {
        //             if (grid[row][i] != grid[i][col]) {
        //                 isEqual = false;
        //                 break;
        //             }
        //         }

        //         if (isEqual) {
        //             count++;
        //         }

        //     }
        // }

        //Optimzed approach using map

        Map<List<Integer>, Integer> map = new HashMap<>();

        for (int row = 0; row < rowSize; row++) {
            List<Integer> rowMap = new ArrayList<>();
            for (int col = 0; col < colSize; col++) {
                rowMap.add(grid[row][col]);
            }
            map.put(rowMap, map.getOrDefault(rowMap, 0) + 1);
        }

        for (int col = 0; col < colSize; col++) {
            List<Integer> colMap = new ArrayList<>();
            for (int row = 0; row < rowSize; row++) {
                colMap.add(grid[row][col]);
            }

            if (map.containsKey(colMap)) {
                count += map.get(colMap);
            }

        }

        return count;

    }
}