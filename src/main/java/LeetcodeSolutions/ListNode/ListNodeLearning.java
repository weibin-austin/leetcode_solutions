package LeetcodeSolutions.ListNode;


/**
 *                 HEAD
 *              _________________      _________________     _________________     _________________
 *             |           |    |     |           |    |    |           |    |    |           |    |
 *             |   A       |    | --->|  B        |    |--->|    C      |    |--->|     D     |    |-----> NULL
 *             |___________|____|     |___________|____|    |___________|____|    |___________|____|
 *               Data       Next
 *
 */
public class ListNodeLearning {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        while(head != null) {
            System.out.print(head.val + " --> ");
            head = head.next;
        }
        System.out.println("null");
    }
}

