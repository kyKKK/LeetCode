package LC_2;

class ListNode {
    ListNode next;
    int val;

    ListNode(int x) {
        x = val;
    }
}

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0), curr = dummyHead;
        ListNode p = l1, q = l2;
        int carry = 0;
        while (p != null || q != null) {
            int a = p == null ? 0 : p.val;
            int b = q == null ? 0 : q.val;
            int sum = a + b + carry;
            if (sum / 10 > 0)
                carry = 1;
            else carry = 0;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        if (carry == 1)
            curr.next = new ListNode(1);
        return dummyHead.next;
    }
}
