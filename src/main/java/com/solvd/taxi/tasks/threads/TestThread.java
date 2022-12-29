package com.solvd.taxi.tasks.threads;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

public class TestThread implements Runnable{
    int threadSleepTime;
    int repeats;

    public TestThread(int repeats, int threadSleepTime) {
        this.repeats = repeats;
        this.threadSleepTime = threadSleepTime;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is working");
        displayLocalTime();
        System.out.println(Thread.currentThread().getName() + " FINISHED");
    }

    public void displayLocalTime() {
        IntStream.range(0, repeats).forEach(el -> {
            System.out.println(Thread.currentThread().getName() + " says that localtime is " + LocalDateTime.now());
            try {
                Thread.sleep(threadSleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
