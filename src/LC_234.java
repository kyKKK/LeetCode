//  请判断一个链表是否为回文链表。

public class LC_234 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //  不用快慢指针
    public boolean isPalindrome1(ListNode head) {
        int len = 0;
        for (ListNode node = head; node != null; node = node.next) {
            len++;
        }
        ListNode cur = head, pre = null, tmp = null;
        for (int i = 0; i < len / 2; i++) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        if (len % 2 == 1) {
            cur = cur.next;
        }
        for (; pre != null; pre = pre.next, cur = cur.next) {
            if (pre.val != cur.val)
                return false;
        }
        return true;
    }

    //  快慢指针
    public boolean isPalindrome2(ListNode head) {
        if(head==null||head.next==null)
            return true;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur = head, pre = null;
        while (cur != slow) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        if (fast != null) {
            slow=slow.next;
        }
        while (pre != null) {
            if(pre.val!=slow.val)
                return false;
            pre=pre.next;
            slow=slow.next;

        }
        return true;
    }
}
