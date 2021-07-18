package me.yevgnenll.concurrent.custom;

import net.jcip.annotations.*;

import me.yevgnenll.concurrent.custom.exception.BufferEmptyException;
import me.yevgnenll.concurrent.custom.exception.BufferFullException;

@ThreadSafe
public class GrumpyBoundedBuffer <V> extends BaseBoundedBuffer<V> {
    public GrumpyBoundedBuffer() {
        this(100);
    }

    public GrumpyBoundedBuffer(int size) {
        super(size);
    }

    public synchronized void put(V v) throws BufferFullException {
        if (isFull()) {
            throw new BufferFullException();
        }
        doPut(v);
    }

    public synchronized V take() throws BufferEmptyException {
        if (isEmpty())
            throw new BufferEmptyException();
        return doTake();
    }
}
