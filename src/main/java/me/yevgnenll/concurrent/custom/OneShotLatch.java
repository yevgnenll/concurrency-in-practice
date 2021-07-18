package me.yevgnenll.concurrent.custom;

import net.jcip.annotations.ThreadSafe;
import java.util.concurrent.locks.*;

@ThreadSafe
public class OneShotLatch {
    private final Sync sync = new Sync();

    public void signal() {
        sync.releaseShared(0);
    }

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(0);
    }

    private class Sync extends AbstractQueuedSynchronizer {
        protected int tryAcquireShared(int ignored) {
            // latch가 열려있는 상태라면 성공, 아니면 실패 (state == 1 성공)
            return (getState() == 1) ? 1 : -1;
        }

        protected boolean tryReleaseShared(int ignored) {
            setState(1); // Latch 를 열었다.
            return true; // 다른 thread 에서 확보 연산에 성공할 가능성이 있다.
        }
    }
}
