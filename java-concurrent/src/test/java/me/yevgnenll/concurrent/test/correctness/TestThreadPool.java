package me.yevgnenll.concurrent.test.correctness;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;

/**
 * TestingThreadFactory
 * <p/>
 * Testing thread pool expansion
 *
 * @author Brian Goetz and Tim Peierls
 */
public class TestThreadPool {

    @Test
    public void testPoolExpansion() throws InterruptedException {
        final TestingThreadFactory threadFactory = new TestingThreadFactory();
        int MAX_SIZE = 10;
        ExecutorService exec = Executors.newFixedThreadPool(MAX_SIZE, threadFactory);

        for (int i = 0; i < 10 * MAX_SIZE; i++) {
            System.out.println("i= " + i + ", " + threadFactory.numCreated.get());
            exec.execute(() -> {
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        for (int i = 0; i < 20 && threadFactory.numCreated.get() < MAX_SIZE; i++) {
            Thread.sleep(100);
        }
        assertEquals(threadFactory.numCreated.get(), MAX_SIZE);
        exec.shutdownNow();
    }
}
