// 221. 最大正方形 - Medium
// https://leetcode-cn.com/problems/maximal-square/
package java;

class MaximalSquare {
    /**
     * 这道题可以计算最长变长然后返回最长边长的平方。
     * 初始化一个dp二维数组dp[i][j]表示在(i,j)位置时可形成的正方形的最长变长
     * 则当matrix[i][j] = '1'时
     *  dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
     * 但是也要考虑边界情况，在i=0或者j=0时，只用设置dp[i][j]为1即可。
     * 每次计算dp[i][j]后，与maxSide做比较，取较大值设置为maxSide。
     * 最后返回maxSide的平方
     */
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int maxSide = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }
}
