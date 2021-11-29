// 剑指 Offer II 013. 二维子矩阵的和 - Medium
// https://leetcode-cn.com/problems/O4NDxx/
package point_to_offer;

/**
 * 思路：前缀和
 * 这道题的难点就是如何利用指定区域的前缀和(Cumulative sum)
 * 计算出当前区域的和，这道题我会用图讲解一下
 */
class NumMatrix {

    int[][] matrixPrefixSum;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        matrixPrefixSum = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrixPrefixSum[i + 1][j + 1] = matrixPrefixSum[i][j + 1] + matrixPrefixSum[i + 1][j] - matrixPrefixSum[i][j] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrixPrefixSum[row2 + 1][col2 + 1] - matrixPrefixSum[row2 + 1][col1] - matrixPrefixSum[row1][col2 + 1] + matrixPrefixSum[row1][col1];
    }
}
