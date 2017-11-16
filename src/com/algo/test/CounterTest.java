package com.algo.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by qiusir on 11/16/17.
 */
public class CounterTest {
    private static int id = 0;
    private static AtomicInteger atomicId = new AtomicInteger();
    private static CountDownLatch latch = null;

    public synchronized static int getNextId() {
        return ++id;
    }

    public static int getNextIdWithAtomic() {
        return atomicId.incrementAndGet();
    }

    public static void main(String[] args) throws Exception {
        latch = new CountDownLatch(50);
        long beginTime = System.nanoTime();
        for (int i = 0; i < 50; i++) {
            new Thread(new Task(false)).run();
        }
        latch.await();
        System.out.println("Synchronized style consume time:" + (System.nanoTime() - beginTime));
        latch = new CountDownLatch(50);
        beginTime = System.nanoTime();
        for ( int i = 0; i< 50; i++) {
            new Thread(new Task(true)).run();
        }
        latch.await();
        System.out.println("CAS sytle consume time:" + (System.nanoTime() - beginTime) );
    }

    static class Task implements Runnable {

        private boolean isAtomic;

        public Task(boolean isAtomic) {
            this.isAtomic = isAtomic;
        }

        public void run() {
            for (int i = 0; i < 1000; i++) {
                if (isAtomic) {
                    getNextIdWithAtomic();
                } else {
                    getNextId();
                }
            }
            latch.countDown();
        }
    }
}
