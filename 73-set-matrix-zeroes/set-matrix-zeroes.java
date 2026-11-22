class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;

        //Set marker in first row and first column

        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col ; j++) {

                if (matrix[i][j] == 0) {
                    if (i == 0)
                        firstRow = true;
                    if (j == 0)
                        firstCol = true;

                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //Iterate inner matrix except fisrt row and column and set 0 based on condition

        for (int i = 1; i < row ; i++) {
            for (int j = 1; j < col ; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        //Check first row and first column
        if (firstRow) {
            for (int i = 0; i < col ; i++)
                matrix[0][i] = 0;
        }

        if (firstCol) {
            for (int i = 0; i < row ; i++)
                matrix[i][0] = 0;
        }

    }
}