import java.util.Arrays;

//  数组实现队列
public class Queue_Array {
    private int max_len;
    private int head = 0;
    private int tail = 0;
    private int len = 0;
    private Integer[] arr;

    public Queue_Array(int len) {
        arr = new Integer[len];
        this.max_len = len;
    }

    public boolean add(int n) {
        if (tail == max_len) {
            if (head == 0)
                return false;
            Integer[] tmp = new Integer[max_len];
            System.arraycopy(arr, head, tmp, 0, len);
            arr = tmp;
            tmp = null;
            tail = len;
            head = 0;
            arr[tail++] = n;
            ++len;
            return true;
        }
        arr[tail++] = n;
        ++len;
        return true;
    }

    public Integer poll() {
        if (head < tail) {
            --len;
            return arr[head++];
        } else
            return null;
    }

    public int size() {
        return len;
    }

    public static void main(String[] args) {
        Queue_Array queue = new Queue_Array(3);
        queue.add(3);
        queue.add(5);
        queue.add(8);
        queue.poll();
        System.out.println(queue.head + " " + queue.tail+" size:"+queue.size());
    }

}
