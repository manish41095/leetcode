class Solution {
    public boolean isValidSudoku(char[][] board) {

        //Approach1 - Brute Force

        //Validate Row
        for (int row = 0; row < 9; row++) {
            Set<Character> set = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.')
                    continue;

                if (set.contains(board[row][col]))
                    return false;
                set.add(board[row][col]);
            }
        }

        //Validate Column
        for (int col = 0; col < 9; col++) {
            Set<Character> set = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                if (board[row][col] == '.')
                    continue;

                if (set.contains(board[row][col]))
                    return false;
                set.add(board[row][col]);
            }
        }

        //Validate 3*3 box

        for (int startRow = 0; startRow < 9; startRow += 3) {
            int endRow = startRow + 2;

            for (int startCol = 0; startCol < 9; startCol += 3) {
                int endCol = startCol + 2;
                //if (board[startRow][startCol] == '.')
                //    continue;

                if (!isValidBox(board, startRow, endRow, startCol, endCol))
                    return false;
            }
        }

        return true;
    }

    public boolean isValidBox(char[][] board, int startRow, int endRow, int startCol, int endCol) {
        Set<Character> set = new HashSet<>();
        for (int i = startRow; i <= endRow; i++) {

            for (int j = startCol; j <= endCol; j++) {
                if (board[i][j] == '.')
                    continue;

                if (set.contains(board[i][j]))
                    return false;

                set.add(board[i][j]);
            }
        }
        return true;
    }
}