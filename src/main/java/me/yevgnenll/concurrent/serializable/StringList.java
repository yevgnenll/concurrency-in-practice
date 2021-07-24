package me.yevgnenll.concurrent.serializable;

import java.io.Serializable;

public class StringList implements Serializable {

    private final int size = 0;
    private Entry head = null;

    private static class Entry implements Serializable {
        String data;
        Entry next;
        Entry previous;
    }
}
