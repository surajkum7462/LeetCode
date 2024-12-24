class Solution {
    public void solveSudoku(char[][] board) {
        // Call the helper function to start solving the Sudoku
        solve(board);
    }

    private boolean solve(char[][] board) {
        // Traverse the board to find an empty cell ('.')
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {  // If the current cell is empty
                    // Try digits from '1' to '9'
                    for (char c = '1'; c <= '9'; c++) {
                        // Check if placing 'c' is valid
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;  // Place the digit in the cell

                            // Recursively attempt to solve the rest of the board
                            if (solve(board)) {
                                return true;  // If solved, return true
                            } else {
                                board[i][j] = '.';  // Backtrack if no solution found
                            }
                        }
                    }
                    return false;  // If no valid number can be placed, return false
                }
            }
        }
        return true;  // If the board is completely filled, return true
    }

    // Helper function to check if placing digit 'c' at board[row][col] is valid
    private boolean isValid(char[][] board, int row, int col, char c) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false;
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
        }

        // Check 3x3 subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == c) return false;
            }
        }

        return true;  // If no conflicts, it's safe to place 'c' here
    }
}
