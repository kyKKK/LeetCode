import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//  最小栈
//  思路, 每次push添加两个元素, 一个是添加元素, 一个是到目前为止最小值, pop时pop两个元素
public class LC_155 {
    private Integer[] array = new Integer[2];
    private int max_len = 2;
    private int cursor = 0;
    private Deque<Integer> min;

    /**
     * initialize your data structure here.
     */
    public LC_155() {
        min = new LinkedList<>();
    }

    public void push(int x) {
        if (cursor == max_len || cursor == max_len - 1)
            array = Arrays.copyOf(array, max_len = max_len * 2 + 1);
        if (cursor == 0) {
            array[cursor++] = x;
            array[cursor++] = x;
        } else {
            Integer tmp = array[cursor - 1];
            if (x < tmp) {
                array[cursor++] = x;
                array[cursor++] = x;
            } else {
                array[cursor++] = x;
                array[cursor++] = tmp;
            }
        }
    }

    public void pop() {
        array[--cursor] = null;
        array[--cursor] = null;
        if (cursor < max_len / 2)
            array = Arrays.copyOf(array, max_len = max_len / 2);
    }

    public int top() {
        return array[cursor - 2];
    }

    public int getMin() {
        return array[cursor - 1];
    }

    public static void main(String[] args) {
        LC_155 stack = new LC_155();
        stack.push(3);
        stack.push(5);
        stack.push(18);
        stack.push(2);
        stack.push(7);
        stack.push(1);
        stack.push(22);
        stack.push(3);
        stack.push(8);
        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack.getMin());
    }
}
