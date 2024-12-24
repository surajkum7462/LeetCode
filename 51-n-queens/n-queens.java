class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        // Initialize the board with '.'
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';

        List<List<String>> res = new ArrayList<>();
        dfs(0, board, res);
        return res;
    }

    public boolean validate(char[][] board, int row, int col) {
        int dupRow = row;
        int dupCol = col;

        // Check upper diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;
        // Check left row
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = dupRow;
        col = dupCol;
        // Check lower diagonal
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }

        return true;
    }

    public void dfs(int col, char[][] board, List<List<String>> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q'; // Place a queen
                dfs(col + 1, board, res); // Recur for the next column
                board[row][col] = '.'; // Backtrack and remove the queen
            }
        }
    }

    public List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
