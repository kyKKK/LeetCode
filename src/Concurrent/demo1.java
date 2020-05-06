package Concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class demo1 {
    public static class CallerTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "hello";
        }
    }

    public static void main(String[] args) {
        Thread deamonThread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        deamonThread.setDaemon(true);
    }
}
