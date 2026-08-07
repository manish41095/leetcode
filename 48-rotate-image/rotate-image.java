class Solution {
    public void rotate(int[][] matrix) {

        int n  = matrix.length;

        for(int i = 0; i < (n+1)/2 ; i++){
            for(int j = 0; j < n/2 ; j++){
                // int temp = matrix[n-1-j][i]; // bottom left

                // matrix[n-1-j][i] = matrix[n-1-i][n-1-j]; // copy bottom right to bottom left

                // matrix[n-1-i][n-1-j] = matrix[j][n-1-i]; //Copy top right to bottom right

                // matrix[j][n-1-i] = matrix[i][j]; // copy top left to top right;

                // matrix[i][j] = temp ; // copy bottom left to top left

                int temp = matrix[i][j];//topLeft

                //1st rotation  bottomLeft to topLeft

               matrix[i][j] = matrix[n-1-j][i];

                // 2nd rotation bottom right to bottom left

                matrix[n-1-j][i]  = matrix[n-1-i][n-1-j];

                //3rd rotation topRight to bottom right

                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];

                //4th rotation topleft to top right

                matrix[j][n-1-i] = temp;
              
            }
        }

        
    }
}