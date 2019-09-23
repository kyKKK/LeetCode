//  删除链表的倒数第N个节点

public class LC_19 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //  2次遍历
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode cur = head;
        for (int i = 0; cur != null; i++) {
            cur = cur.next;
            len++;
        }
        if (n == len) {
            head = head.next;
            return head;
        } else if (n == 0) {
            cur.next = null;
            return head;
        }
        cur = head;
        for (int i = 0; i < len - n - 1; i++) {
            cur = cur.next;
        }
        if (n > 1)
            cur.next = cur.next.next;
        else
            cur.next = null;
        return head;
    }

    //  二次遍历, 用哨兵节点, 可减少边界条件的判断
    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        int len = 0;
        ListNode pre = new ListNode(0);
        pre.next = head;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            len++;
        }
        ListNode cur = pre;
        for (int i = 0; i < len - n; i++) {
            cur = cur.next;
        }
        if (n == 0) {
            cur.next = null;
        } else {
            cur.next = cur.next.next;
        }
        return pre.next;
    }

    //  一次遍历, 用双指针
    public ListNode removeNthFromEnd_2(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        ListNode first = pre;
        ListNode second = pre;
        pre.next = head;
        for (int i = 0; i < n + 1; i++) {
            second = second.next;
        }
        for (; second != null; second = second.next) {
            first = first.next;
        }
        if (n == 0)
            first.next = null;
        else
            first.next = first.next.next;
        return pre.next;
    }

}
