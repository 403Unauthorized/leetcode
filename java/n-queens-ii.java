package java;

class NQueens2 {
    int ans = 0;
    boolean[] visitedRow;
    boolean[] visitedCol;
    boolean[] diagonal;
    boolean[] backDiagonal;
    public int totalNQueens(int n) {
        if (n == 1) return 1;
        if (n < 4) return 0;
        visitedRow = new boolean[n];
        visitedCol = new boolean[n];
        diagonal = new boolean[2 * n];
        backDiagonal = new boolean[2 * n];
        backtrace(n, 0);
        return ans;
    }
    public void backtrace(int n, int row) {
        if (row == n) {
            ans++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (visitedRow[row] || visitedCol[col] || diagonal[row + col] || backDiagonal[row - col + n - 1]) {
                continue;
            }
            visitedRow[row] = true;
            visitedCol[col] = true;
            diagonal[row + col] = true;
            backDiagonal[row - col + n - 1] = true;
            backtrace(n, row + 1);
            visitedRow[row] = false;
            visitedCol[col] = false;
            diagonal[row + col] = false;
            backDiagonal[row - col + n - 1] = false;
        }
    }
}
