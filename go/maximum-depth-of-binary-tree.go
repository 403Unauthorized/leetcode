// 104. 二叉树的最大深度 - Easy
// https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
package leetcode

func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	left := 1 + maxDepth(root.Left)
	right := 1 + maxDepth(root.Right)
	max := func(a int, b int) int {
		if a > b {
			return a
		} else {
			return b
		}
	}
	return max(left, right)
}
