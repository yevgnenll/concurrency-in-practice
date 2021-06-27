package me.yevgnenll.concurrent.test.correctness;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoundedBufferTest {

    private static final long LOCKUP_DETECT_TIMEOUT = 1000;
    private static final int CAPACITY = 10000;
    private static final int THRESHOLD = 10000;

    @Test
    void testIsEmptyWhenConstructed() {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        assertTrue(bb.isEmpty());
        assertFalse(bb.isFull());
    }

    @Test
    void testIsFullAfterPuts() throws InterruptedException {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        for(int i = 0; i < 10; i ++) {
            bb.put(i);
        }
        assertTrue(bb.isFull());
        assertFalse(bb.isEmpty());
    }

    @Test
    void testTakeBlocksWhenEmpty() {
        final BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        Thread taker = new Thread(() -> {
            try {
                Integer unused = bb.take();
                fail();
            } catch (InterruptedException success) {
            }
        });

        try {
            taker.start();
            Thread.sleep(LOCKUP_DETECT_TIMEOUT);
            taker.interrupt();
            taker.join(LOCKUP_DETECT_TIMEOUT);
            assertFalse(taker.isAlive());
        } catch (Exception unexcepted) {
            fail();
            System.out.println("ddddd" + unexcepted.getMessage());
        }
    }

}