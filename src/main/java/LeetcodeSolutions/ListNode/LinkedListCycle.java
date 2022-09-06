package LeetcodeSolutions.ListNode;

/**
 *
 *           HEAD
 *        _________________      _________________     _________________     _________________
 *       |           |    |     |           |    |    |           |    |    |           |    |
 *       |   3       |    | --->|  2        |    |--->|    0      |    |--->|    -4     |    |----->
 *       |___________|____|     |___________|____|    |___________|____|    |___________|____|     |
 *         Data       Next               ^                                                         |
 *                                       |                                                         |
 *                                       <---------------------------------------------------------V
 *
 *                 a                                      HP = a, PQ = b, QP = c
 *           H------------- P -----------  b
 *                         |            |                 P is the start point of cycle
 *                         |            |                 Q is the meeting point
 *                         |            |                 fast = a + b + c + b = a + 2b + c
 *                         ------------ Q                 slow = a + b
 *                        c                               fast = slow * 2 -> a + 2b + c = 2a + 2b -> a = c
 *
 *
 *
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        System.out.println(detectCycle(head).val);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                fast = head;
                while(fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
