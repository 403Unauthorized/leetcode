//
//
package leetcode

type ListNode struct {
	Val  int
	Next *ListNode
}

var ans *ListNode = new(ListNode)

func reverseList(head *ListNode) *ListNode {
	dummy := new(ListNode)
	dummy = ans
	recurve(head)
	return dummy.Next
}

func recurve(node *ListNode) {
	if node == nil {
		return
	}
	recurve(node.Next)
	ans.Next = &ListNode{Val: node.Val}
	ans = ans.Next
}
