package me.yevgnenll.concurrent.test.correctness;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;


/**
 * PutTakeTest
 * <p/>
 * Producer-consumer test program for BoundedBuffer
 *
 * @author Brian Goetz and Tim Peierls
 */
public class PutTakeTest {
    protected static final ExecutorService pool = Executors.newCachedThreadPool();
    protected CyclicBarrier barrier;
    protected final BoundedBuffer<Integer> bb;
    protected final int nTrials, nPairs;
    protected final AtomicInteger putSum = new AtomicInteger(0);
    protected final AtomicInteger takeSum = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        new PutTakeTest(10, 10, 100000).test(); // sample parameters
        pool.shutdown();
    }

    public PutTakeTest(int capacity, int npairs, int ntrials) {
        this.bb = new BoundedBuffer<>(capacity);
        this.nTrials = ntrials;
        this.nPairs = npairs;
        this.barrier = new CyclicBarrier(npairs * 2 + 1);
    }

    void test() {
        try {
            for (int i = 0; i < nPairs; i++) {
                pool.execute(new Producer());
                pool.execute(new Consumer());
            }
            barrier.await(); // wait for all threads to be ready
            System.out.println("load complete");
            barrier.await(); // wait for all threads to finish
            assertEquals(putSum.get(), takeSum.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class Producer implements Runnable {
        public void run() {
            try {
                int seed = (this.hashCode() ^ (int) System.nanoTime());
                int sum = 0;
                barrier.await();
                for (int i = nTrials; i > 0; --i) {
                    bb.put(seed);
                    sum += seed;
                    // System.out.println("producer: " + sum);
                    seed = IdGenerator.xorShift(seed);
                    if (i == nTrials) {
                        System.out.println("producer: " + sum);
                    }
                }
                putSum.getAndAdd(sum);
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    class Consumer implements Runnable {
        public void run() {
            try {
                barrier.await();
                int sum = 0;
                for (int i = nTrials; i > 0; --i) {
                    sum += bb.take();
                    // System.out.println("consumer: " + sum);
                    if (i == nTrials) {
                        System.out.println("consumer: " + sum);
                    }
                }
                takeSum.getAndAdd(sum);
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
