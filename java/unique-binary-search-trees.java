// 96. 不同的二叉搜索树
// https://leetcode-cn.com/problems/unique-binary-search-trees/
package java;

class UniqueBinarySearchTrees {
    /**
     * 假设n个节点的二叉搜索树个数为 G(n), 以 i 为根节点的二叉搜索树个数为 f(i)
     * 则以i为根节点的左子树个数为 i - 1, 右子树个数为 n - i，
     * 所以 f(i) = G(i - 1) * G(n - i)
     * G(n) = G(0) * G(n - 1) + G(1) * G(n - 2) + ... + G(n - 1) * G(0)
     * 我们设 dp[i] 为 i 个节点时可形成的二叉搜索树的个数
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
