package me.yevgnenll.concurrent.custom;

import me.yevgnenll.concurrent.custom.exception.BufferEmptyException;

public class ExampleUsage {

    private GrumpyBoundedBuffer<String> buffer;
    int SLEEP_GRANULARITY = 50;

    void useBuffer() throws InterruptedException {
        while (true) {
            try {
                String item = buffer.take();
                // use item
                break;
            } catch (BufferEmptyException e) {
                Thread.sleep(SLEEP_GRANULARITY);
            }
        }
    }
}
