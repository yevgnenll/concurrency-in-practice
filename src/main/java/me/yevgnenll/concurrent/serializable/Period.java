package me.yevgnenll.concurrent.serializable;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public final class Period implements Serializable {

    private final Date start;
    private final Date end;

    /**
     * @param start 시작 시간
     * @param end 종료 시각; 시작 시간보다 뒤여야 한다.
     * @throws IllegalArgumentException 시작 시각이 종료 시각보다 늦을때 발생한다
     * @throws NullPointerException start 나 end 가 null 이면 발생한다.
     */
    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException(start + " after " + end);
        this.start = start;
        this.end = end;
    }

    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    @Override
    public String toString() {
        return start + " - " + end;
    }

    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("proxy 가 필요합니다");
    }

    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    private static class SerializationProxy implements Serializable {

        private static final long serialVersionUID = -2785633062946028119L;

        private final Date start;
        private final Date end;

        SerializationProxy(Period period) {
            start = period.start;
            end = period.end;
        }

        private Object readResolve() {
            return new Period(start, end);
        }
    }
}
