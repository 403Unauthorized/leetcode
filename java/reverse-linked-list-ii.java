// 92. 反转链表 II - Medium
// https://leetcode-cn.com/problems/reverse-linked-list-ii/
package java;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class ReverseLinkedList2 {
    ListNode ans = new ListNode(0);
    int current = 1;
    ListNode suffix = null;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = ans;
        while (head != null) {
            if (current < left) {
                ans.next = new ListNode(head.val);
                ans = ans.next;
                head = head.next;
                current++;
            } else {
                reverse(head, left, right);
                break;
            }
        }
        ans.next = suffix;
        return dummy.next;
    }

    public void reverse(ListNode node, int left, int right) {
        if (current == right) {
            ans.next = new ListNode(node.val);
            ans = ans.next;
            suffix = node.next;
            return;
        }
        current++;
        reverse(node.next, left, right);
        ans.next = new ListNode(node.val);
        ans = ans.next;
    }
}
