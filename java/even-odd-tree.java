package java;

import java.util.Deque;
import java.util.LinkedList;

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


class EvenOddTree {
    // 层序遍历
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int level = 0;
        while (!deque.isEmpty()) {
            int prev = 0;
            int levelSize = deque.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = deque.pollFirst();
                // 判断值是否符合奇偶树
                boolean valid = level % 2 == 0 ? handleEvenLevel(node, prev) : handleOddLevel(node, prev);
                if (!valid) return valid;
                prev = node.val;
                // 将子节点加入到栈中，以从左到右的顺序
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            level++;
        }
        return true;
    }

    // 处理单数层级节点
    private boolean handleOddLevel(TreeNode node, Integer prevVal) {
        boolean valid = node.val % 2 == 0;
        if (prevVal == 0) {
            return valid;
        } else {
            valid = valid && node.val < prevVal;
        }
        return valid;
    }

    // 处理偶数层级节点
    private boolean handleEvenLevel(TreeNode node, Integer prevVal) {
        boolean valid = node.val % 2 == 1;
        if (prevVal == 0) {
            return valid;
        } else {
            valid = valid && node.val > prevVal;
        }
        return valid;
    }
}
