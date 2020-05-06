import java.io.BufferedWriter;

//  21 合并两个有序链表
public class LC_21 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //  递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;

        }
    }

    //  迭代
    public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode head = pre;
        if (l1 == null && l2 == null) {
            return null;
        }
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                pre.next = l2;
                break;
            } else if (l2 == null) {
                pre.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            } else {
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
    }
}
