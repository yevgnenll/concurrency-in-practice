package me.yevgnenll.concurrent.custom;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {
    // 조건 서술어: not-full (!isFull())
    // 조건 서술어: not-empty (!isEmpty())
    public BoundedBuffer() {
        this(100);
    }

    public BoundedBuffer(int size) {
        super(size);
    }

    // BLOCKS-UNTIL: not-full 만족할 때까지 대기
    public synchronized void put(V v) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        doPut(v);
        notifyAll();
    }

    // BLOCKS-UNTIL: not-empty 만족할 때까지 대기
    public synchronized V take() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        V v = doTake();
        notifyAll();
        return v;
    }

    // BLOCKS-UNTIL: not-full 만족할 때까지 대기
    // 조건 알림을 사용한 put 의 대체 함수
    public synchronized void alternatePut(V v) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        boolean wasEmpty = isEmpty();
        doPut(v);
        if (wasEmpty) {
            notifyAll();
        }
    }
}
