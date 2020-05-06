package Concurrent;

public class ThreadLocalTest {
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    static void print(String str) {
        System.out.println(str + localVariable.get());
        localVariable.remove();
    }

    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("thread one local variable");
                print("线程1本地变量: ");
                System.out.println("thread1 after remove: " + localVariable.get());
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("thread two local variable");
                print("线程2本地变量: ");
                System.out.println("thread2 after remove: " + localVariable.get());
            }
        });
        threadOne.start();
        threadTwo.start();
    }
}
