import java.util.PriorityQueue;
import java.util.concurrent.*;

//  循环数组实现队列
public class Queue_CircleArray {
    private int max_length;
    private int length = 0;
    private int head = 0, tail = 0;
    private Integer[] arr;

    public Queue_CircleArray(int length) {
        max_length = length + 1;
        arr = new Integer[max_length];
    }

    public boolean add(int val) {
        if ((tail + 1) % max_length == head)
            throw new RuntimeException("Full");
        arr[tail] = val;
        tail = (tail + 1) % max_length;
        ++length;
        return true;
    }

    public int poll() {
        if (head == tail)
            throw new RuntimeException("Queue is empty");
        int val = arr[head];
        head = (head + 1) % max_length;
        --length;
        return val;
    }

    public int size() {
        return length;
    }

    public static void main(String[] args) {
        Queue_CircleArray queue = new Queue_CircleArray(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.poll();
        System.out.println(queue.size());
        System.out.println(Integer.toBinaryString(-2));
    }
}

