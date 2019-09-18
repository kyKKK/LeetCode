//2 两数相加
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class LC_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode head = list;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            int sum = l1.val + l2.val + carry;
            if (sum >= 10) {
                list.val = sum % 10;
                carry = 1;
            } else {
                list.val = sum;
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;

            if (l1 == null && l2 == null && carry == 1) {
                list.next = new ListNode(1);
                list = list.next;
                return head;
            } else if (l1 == null && l2 == null) {
                return head;
            }
            list.next = new ListNode(0);
            list = list.next;
        }
        return head;
    }
}
