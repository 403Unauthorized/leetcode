// 105. 从前序与中序遍历序列构造二叉树 - Medium
// https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
package leetcode

func buildTree(preorder []int, inorder []int) *TreeNode {
	index := make(map[int]int)
	for i, v := range inorder {
		index[v] = i
	}
	var buildHelper func(pLeft int, pRight int, iLeft int, iRight int) *TreeNode
	buildHelper = func(pLeft int, pRight int, iLeft int, iRight int) *TreeNode {
		if pLeft > pRight {
			return nil
		}
		root := &TreeNode{Val: preorder[pLeft], Left: nil, Right: nil}
		rootIdx := index[preorder[pLeft]]
		var leftSize int = rootIdx - iLeft
		root.Left := buildHelper(pLeft + 1, pLeft + leftSize, iLeft, rootIdx - 1)
		root.Right := buildHelper(pLeft + leftSize + 1, pRight, rootIdx + 1, iRight)
		return root
	}
	
	return buildHelper(0, len(preorder)-1, 0, len(inorder)-1)
}
