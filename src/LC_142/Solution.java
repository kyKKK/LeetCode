package LC_142;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    //  方法一，哈希表
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (set.contains(cur))
                return cur;
            set.add(cur);
        }
        return null;
    }

    // 方法二，双指针
    public ListNode detectCycle_1(ListNode head) {
        ListNode fast = head, slow = head;
        do {
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        fast = head;
        do {
            fast = fast.next;
            slow = slow.next;
        } while (fast != slow);
        return fast;
    }
}
