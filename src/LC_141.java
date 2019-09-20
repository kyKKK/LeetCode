import java.util.HashSet;
import java.util.List;
import java.util.Set;


//  环形链表
public class LC_141 {
    class ListNode {
        ListNode next;
        int val;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 空间复杂度O(n)
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head)) {
                set.add(head);
                head = head.next;
            } else
                return true;

        }
        return false;
    }

    //  空间复杂度O(1)
    public boolean hasCycle_1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow.next == fast || slow == fast)
                return true;
        }
        return false;
    }
}
