// 99. 恢复二叉搜索树 - Medium
// https://leetcode-cn.com/problems/recover-binary-search-tree/
package leetcode

func recoverTree(root *TreeNode) {
	nodes := make([]int, 0)
	var inorder func(node *TreeNode)
	inorder = func(node *TreeNode) {
		if node == nil {
			return
		}
		inorder(node.Left)
		nodes = append(nodes, node.Val)
		inorder(node.Right)
	}
	n1, n2 := findWrongNode(nodes)
	revert(root, n1, n2)
}

func findWrongNode(nodes []int) (int, int) {
	nums := make([]int, 0)
	for i, v := range nodes {
		if i == 0 {
			if v > nodes[i+1] {
				nums = append(nums, v)
			}
			continue
		}
		if i == len(nodes)-1 {
			if v < nodes[i-1] {
				nums = append(nums, v)
			}
		}
		if v >= nodes[i-1] || v <= nodes[i+1] {
			continue
		} else {
			nums = append(nums, v)
		}
	}
	return nums[0], nums[1]
}

func revert(node *TreeNode, n1 int, n2 int) {
	if node == nil {
		return
	}
	if node.Val == n1 {
		node.Val = n2
	}
	if node.Val == n2 {
		node.Val = n1
	}
	revert(node.Left, n1, n2)
	revert(node.Right, n1, n2)
}
