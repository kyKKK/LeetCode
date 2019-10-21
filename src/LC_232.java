import java.util.Deque;
import java.util.LinkedList;

//  用栈实现队列
public class LC_232 {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;
    private int front;

    public LC_232() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        if(stack1.isEmpty())
            front=x;
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        return front;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}
