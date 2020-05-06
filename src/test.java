import java.io.IOException;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;

public class test {
    private static Object lock = new Object();

    private static class A extends Thread {
        public void run() {
            synchronized (lock) {
//                while (!Thread.currentThread().isInterrupted()) {
//
//                }
                System.out.println("exit");
                lock.notifyAll();
            }
        }

    }

    public static void test() throws InterruptedException {
        A a = new A();
        a.start();
        synchronized (lock) {

            Thread.sleep(1000);
            //a.interrupt();
            lock.wait();
            a.join();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        test();
    }
}
