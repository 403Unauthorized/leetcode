// Medium - https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
package java;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 分别找到root节点的左右子树最大值与最小值的差，取较大的一个
 */
class MaximumDifferenceBetweenNodeAndAncestorEn {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }
    
    public int dfs(TreeNode root, int max, int min) {
        if (root == null) return max - min;
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        return Math.max(dfs(root.left, max, min), dfs(root.right, max, min));
    }
}
