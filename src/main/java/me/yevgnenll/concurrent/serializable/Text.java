package me.yevgnenll.concurrent.serializable;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.Set;

public class Text {
    public enum Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
    }
    // 어떤 set도 전달 가능, EnumSet이 가장 좋다.
    public void applyStyles(Set<Style> styles) { }

    private static class SerializationProxy <E extends Enum<E>> implements Serializable {

        // private final Class<E> elementType;
        private final Enum<?>[] elements;

        SerializationProxy(EnumSet<E> set) {
            elements = set.toArray(new Enum<?>[0]);
        }
    }
}
