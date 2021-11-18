// 563. 二叉树的坡度 - Easy
// https://leetcode-cn.com/problems/binary-tree-tilt/
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


class BinaryTreeTilt {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        postorder(root);
        return tilt;
    }

    public int postorder(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = postorder(node.left);
        int right = postorder(node.right);
        tilt += Math.abs(left - right);
        return left + right + node.val;
    }
}
