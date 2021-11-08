# 105. 从前序与中序遍历序列构造二叉树 - Medium

from typing import List


class TreeNode:
    def __init__(self, val, left = None, right = None) -> None:
        self.val = val
        self.left = left
        self.right = right

class Solution:

    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        def buildTreeHelper(pLeft: int, pRight: int, iLeft: int, iRight: int) -> TreeNode:
            if pLeft > pRight:
                return None
            root = TreeNode(preorder[pLeft])
            rootIdx = index[preorder[pLeft]]
            leftSize = rootIdx - iLeft
            root.left = buildTreeHelper(pLeft + 1, pLeft + leftSize, iLeft, rootIdx - 1)
            root.right = buildTreeHelper(pLeft + leftSize + 1, pRight, rootIdx + 1, iRight)
            return root
             
        index = { val: i for i, val in enumerate(inorder)}
        return buildTreeHelper(0, len(preorder) - 1, 0, len(inorder) - 1)
