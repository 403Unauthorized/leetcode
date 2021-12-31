package java;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 找到ListNode的长度，然后中序遍历
 */
class ConvertSortedListToBST_En {
    ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        
        int size = 0;
        ListNode tmp = head;
        node = head;
        
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        
        return inorder(0, size - 1);
    }
    
    public TreeNode inorder(int start, int end) {
        if (start > end) return null;
        
        int mid = (start + end) / 2;
        
        TreeNode left = inorder(start, mid - 1);
        
        TreeNode tree = new TreeNode(node.val);
        tree.left = left;
        node = node.next;
        
        TreeNode right = inorder(mid + 1, end);
        tree.right = right;
        return tree;
    }
}
