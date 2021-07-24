package me.yevgnenll.concurrent.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StringListEnhance implements Serializable {

    private transient int size = 0;
    private transient Entry head = null;
    private transient Entry next = null;

    private static class Entry {
        String data;
        Entry next;
        Entry previous;
    }

    public final void add(String s) {

    }

    /**
     * 이 {@code StringListEnhance} 인스턴스를 직렬화 한다.
     *
     * @serialData 이 리스트의 크기(포함된 문자열의 개수)를 기록한 후
     * ({@code int}, 이어서 모든 원소를(각각 {@code String}) 순서대로 기록한다.
     * @param s
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);
        for (Entry e = head; e != null; e = e.next) {
            s.writeObject(s);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int numElements = s.readInt();

        for (int i = 0; i < numElements; i ++) {
            add((String) s.readObject());
        }
    }

}
