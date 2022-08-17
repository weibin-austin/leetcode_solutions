package DataStructure;

import java.util.LinkedList;
import java.util.List;

public class LinkedListAndListNode {
    public static void main(String[] args) {
        List linkedList = new LinkedList();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.a = 6;
        System.out.println(listNode2.a);
//        ListNode.a = 6;
    }
}

class ListNode {
    public static int a = 5;
    int val;
//    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
}
