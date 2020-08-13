package LC_402;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char ch = num.charAt(i);
            if (k == 0) {
                stack.push(ch);
                continue;
            }
            while (stack.peek() != null && stack.peek() > ch && k > 0) {
                stack.pop();
                --k;
            }
            stack.push(ch);
        }
        while (k > 0) {
            stack.pop();
            --k;
        }
        StringBuilder sb = new StringBuilder();
        boolean zero = true;

        while (stack.peekLast() != null && stack.peekLast() == '0') {
            stack.pollLast();
        }
        int leftSize = stack.size();
        if (leftSize == 0)
            sb.append('0');
        for (int i = 0; i < leftSize; i++) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.removeKdigits("10", 2);
    }
}
