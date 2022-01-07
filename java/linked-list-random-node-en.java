package java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class LinkedListRandomNode {
    final Random random = new Random();
    final List<Integer> list;

    public LinkedListRandomNode(ListNode head) {
        list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}