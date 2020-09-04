package jianzhiOffer.J_09;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public Solution() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty())
            return stack2.pop();
        if (stack1.isEmpty())
            return -1;
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack1.pop();

    }
}
