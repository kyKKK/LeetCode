//  链表的中间结点
public class LC_876 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow=head,fast=head;
        while (fast != null && fast.next != null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
