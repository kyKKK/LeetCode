package jianzhiOffer.J_06;

import java.util.*;

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    List<Integer> ret = new LinkedList<>();

    public int[] reversePrint(ListNode head) {
        helper(head);
        int[] arr = new int[ret.size()];
        int i = 0;
        for (Integer integer : ret) {
            arr[i++] = integer;

        }
        return arr;
    }

    public int[] reversePrint2(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            stack.add(cur.val);
        }
        int[] ret = new int[stack.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = stack.removeLast();
        }
        return ret;
    }

    private void helper(ListNode head) {
        if (head == null)
            return;

        if (head.next == null) {
            ret.add(head.val);
            return;
        }
        helper(head.next);
        ret.add(head.val);
    }
}
