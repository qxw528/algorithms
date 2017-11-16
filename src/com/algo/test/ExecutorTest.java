package com.algo.test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by qiusir on 11/16/17.
 */
public class ExecutorTest {

    final BlockingQueue<Runnable> queue = new SynchronousQueue<Runnable>();

    final ThreadPoolExecutor executor = new ThreadPoolExecutor(10,600,30, TimeUnit.SECONDS,queue, Executors.defaultThreadFactory()
            ,new ThreadPoolExecutor.AbortPolicy());

    final AtomicInteger completedTask = new AtomicInteger(0);

    final AtomicInteger rejectedTask = new AtomicInteger(0);

    static  long beginTime;

    final int count = 1000;

    public static void main(String[] args) {
        beginTime = System.currentTimeMillis();
        ExecutorTest executorTest = new ExecutorTest();
        executorTest.start();
    }

    public void start() {
        CountDownLatch latch = new CountDownLatch(count);
        CyclicBarrier barrier = new CyclicBarrier(count);

        for (int i = 0; i < count; i++) {
            new Thread(new TestThread(latch,barrier)).start();
        }

        try {
            latch.await();
            executor.shutdownNow();
        }
        catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    class TestThread implements Runnable {
        private CountDownLatch latch;
        private CyclicBarrier barrier;
        public TestThread(CountDownLatch latch, CyclicBarrier barrier) {
            this.latch = latch;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                barrier.wait();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            try {
                executor.execute(new Task(latch));
            } catch (RejectedExecutionException exception) {
                latch.countDown();
                System.err.println("Rejected task number is:" + rejectedTask.incrementAndGet());
            }
        }

    }

    class Task implements Runnable {
        private CountDownLatch latch;
        public Task(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Executor task number is:" + completedTask.incrementAndGet());
            System.out.println("Task time is:" + (System.currentTimeMillis() - beginTime) + "ms");
            latch.countDown();
        }
    }
}
