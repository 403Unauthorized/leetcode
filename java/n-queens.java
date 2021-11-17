// 
// 
package java;

import java.util.ArrayList;
import java.util.List;

class NQueens {

    List<List<String>> ans;
    boolean[][] rowCol;
    boolean[] forward;
    boolean[] backward;
    
    public List<List<String>> solveQueens(int n) {
        rowCol = new boolean[n][n];
        forward = new boolean[2 * n];
        backward = new boolean[n];
        ans = new ArrayList<>(n);
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }
        backtrack(board, 0, n);
        return ans;
    }

    public void backtrack(String[][] board, int row, int n) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (String[] line : board) {
                list.add(String.join("", line));
            }
            ans.add(list);
        }
        for (int col = 0; col < n; col++) {
            if (!isValid(row, col)) continue;
            rowCol[row][col] = true;
            forward[row + col] = true;
            backward[Math.abs(col - row)] = true;
            board[row][col] = "Q";
            backtrack(board, row + 1, n);
            rowCol[row][col] = false;
            forward[row + col] = false;
            backward[Math.abs(col - row)] = false;
            board[row][col] = ".";
        }
    }

    private boolean isValid(int row, int col) {
        int v = Math.abs(col - row);
        return !(rowCol[row][col] || forward[row + col] || backward[v]);
    }
}
