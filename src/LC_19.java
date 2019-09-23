//  删除链表的倒数第N个节点

public class LC_19 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //  暴力
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode cur = head;
        for (int i = 0; cur != null; i++) {
            cur = cur.next;
            len++;
        }
        if (n == len) {
            head=head.next;
            return head;
        } else if (n == 0) {
            cur.next=null;
            return head;
        }
        cur = head;
        for (int i = 0; i < len - n - 1; i++) {
            cur=cur.next;
        }
        if(n>1)
            cur.next=cur.next.next;
        else
            cur.next=null;
        return head;
    }

}
