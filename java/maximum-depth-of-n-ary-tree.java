// 559. N 叉树的最大深度 - Easy
// https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
package java;

import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class MaximumDepthOfNAryTree {
    int ans = 0;
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        recursive(root, 1);
        return ans;
    }

    public void recursive(Node node, int depth) {
        if (node.children == null || node.children.isEmpty()) {
            ans = Math.max(ans, depth);
            return;
        }
        List<Node> children = node.children;
        for (Node child : children) {
            recursive(child, depth + 1);
        }
    }
}
