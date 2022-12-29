package com.solvd.taxi.tasks.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        //pool();
        deadlock();
    }

    public static void pool() {
        int executorAmount = 5;
        int threadSleep = 500;
        int repeats = 10;

        ExecutorService executor = Executors.newFixedThreadPool(executorAmount);
        for(int i = 0; i < executorAmount; i++){
            Runnable worker = new TestThread(repeats, threadSleep * ((executorAmount*2-1) - i+1));
            executor.execute(worker);
        }
        executor.shutdown();
    }

    public static void deadlock() {
        String val1 = "Some value1";
        String val2 = "Some value2";

        Thread th1 = new Thread() {
            public void run() {
                synchronized (val1) {
                    System.out.println(Thread.currentThread().getName() + " got " + val1);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (val2) {
                        System.out.println(Thread.currentThread().getName() + " got " + val2);
                    }
                }
            }
        };

        Thread th2 = new Thread() {
            public void run() {
                synchronized (val2) {
                    System.out.println(Thread.currentThread().getName() + " got " + val2);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (val1) {
                        System.out.println(Thread.currentThread().getName() + " got " + val1);
                    }
                }
            }
        };

        th1.start();
        th2.start();
    }
}
