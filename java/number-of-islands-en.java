package java;

class NumberOfIslandsEn {
    boolean[][] visited;
    int[][] direction = new int[][] {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    public int numIslands(char[][] grid) {
        int rowLen = grid.length, colLen = grid[0].length, ans = 0;
        visited = new boolean[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (visited[i][j]) continue;
                if (grid[i][j] == '0') {
                    visited[i][j] = true;
                } else {
                    bfs(i, j, grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void bfs(int row, int col, char[][] grid) {
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nextRow = row + direction[i][0];
            int nextCol = col + direction[i][1];
            if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length || visited[nextRow][nextCol]) continue;
            if (grid[nextRow][nextCol] == '1') {
                bfs(nextRow, nextCol, grid);
            } else {
                visited[nextRow][nextCol] = true;
            }
        }
    }
}
