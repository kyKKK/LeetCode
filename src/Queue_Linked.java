//  链表实现队列
public class Queue_Linked {
    class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private int length = 0;
    private ListNode head = null, tail = null;

    public Queue_Linked() {
        head = tail = new ListNode(0);
    }

    public boolean add(int n) {
        ListNode tmp = new ListNode(n);
        tail.next = tmp;
        tail = tmp;
        ++length;
        return true;
    }

    public int poll() {
        if (length > 0) {
            int val = head.next.val;
            head.next = head.next.next;
            --length;
            return val;
        }
        throw new RuntimeException("out of bounds");
    }

    public static void main(String[] args) {
        Queue_Linked queue = new Queue_Linked();
        queue.add(3);
        queue.add(8);
        queue.add(15);
        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println(queue.length);
    }
}
