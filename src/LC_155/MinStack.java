package LC_155;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    private int[] arr;
    private int len = 0, max_len;
    private int head = 0, tail = 0;
    Deque<Integer> min = new LinkedList<>();


    public MinStack() {
        this(16);
    }

    public MinStack(int x) {
        arr = new int[x];
        max_len = 16;
    }

    public void push(int x) {
        if (len >= max_len) {
            int[] tmp = new int[max_len * 2];
            System.arraycopy(arr, head, tmp, 0, len);
            arr = tmp;
            head = 0;
            tail = len;
            max_len = max_len * 2;
        }
        arr[tail++] = x;
        ++len;
        if (min.size() == 0)
            min.push(x);
        else
            min.addLast(Math.min(min.getLast(), x));
    }

    public void pop() {
        if (head == tail)
            throw new RuntimeException("stack is empty");
        --tail;
        --len;
        min.removeLast();
    }

    public int top() {
        return arr[tail - 1];
    }

    public int getMin() {
        return min.getLast();
    }

    public static void main(String[] args) {
        MinStack minstack = new MinStack();
        minstack.push(-2);
        minstack.push(-4);
        minstack.push(-3);
        System.out.println(minstack.getMin());
    }
}
