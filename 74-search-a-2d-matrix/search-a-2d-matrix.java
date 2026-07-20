class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Approach1 - Brute Force
        // int m = matrix.length;
        // int n = matrix[0].length;
        // for(int i = 0; i < m ; i++){
        //     for(int j = 0 ; j < n ; j++){
        //         if(matrix[i][j]==target)
        //         return true;
        //     }
        // }
        // return false;

        //Approach2 - Binary Search
        int rowId = potentialRow(matrix, target);
        if (rowId == -1)
            return false;
        boolean result = binarySearchRow(rowId, matrix, target);
        return result;
    }

    private int potentialRow(int[][] matrix, int target) {
        int high = matrix.length - 1;
        int low = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1])
                return mid;
            else if (matrix[mid][0] < target)
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return -1;
    }

    private boolean binarySearchRow(int rowId, int[][] matrix, int target){
            int low = 0 ;
            int high = matrix[rowId].length-1;
            while(low <= high){
                int mid = low + (high-low)/2;
                if(matrix[rowId][mid] == target)
                    return true;
                else if (matrix[rowId][mid] < target)  
                    low = mid + 1;
                else
                    high = mid - 1;     
            }
            return false;
        }
 
}