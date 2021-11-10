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
	inorder(root)
	n1, n2 := findWrongNode(nodes)
	revert(root, 2, n1, n2)
}

func findWrongNode(nodes []int) (int, int) {
	index1, index2 := -1, -1
	for i := 0; i < len(nodes)-1; i++ {
		if nodes[i+1] < nodes[i] {
			index2 = i + 1
			if index1 == -1 {
				index1 = i
			} else {
				break
			}
		}
	}
	n1, n2 := nodes[index1], nodes[index2]
	return n1, n2
}

func revert(node *TreeNode, count int, n1 int, n2 int) {
	if node == nil {
		return
	}
	if node.Val == n1 || node.Val == n2 {
		if node.Val == n1 {
			node.Val = n2
		} else {
			node.Val = n1
		}
		count--
		if count == 0 {
			return
		}
	}

	revert(node.Left, count, n1, n2)
	revert(node.Right, count, n1, n2)
}
