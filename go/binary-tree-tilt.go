//
//
package leetcode

var tilt int = 0

func findTilt(root *TreeNode) int {
	postorder(root)
	return tilt
}

func postorder(node *TreeNode) int {
	if node == nil {
		return 0
	}
	left := postorder(node.Left)
	right := postorder(node.Right)
	tilt += Abs(right - left)
	return left + right + node.Val
}

func Abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
