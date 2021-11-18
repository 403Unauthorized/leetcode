# 563. 二叉树的坡度 - Easy
# https://leetcode-cn.com/problems/binary-tree-tilt/
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:

    def __init__(self):
        self.tilt = 0

    def findTilt(self, root: TreeNode) -> int:
        self.postorder(root)
        return self.tilt

    def postorder(self, node: TreeNode) -> int:
        if not node:
            return 0
        left = self.postorder(node.left)
        right = self.postorder(node.right)
        self.tilt += abs(left - right)
        return left + right + node.val