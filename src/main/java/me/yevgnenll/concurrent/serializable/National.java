package me.yevgnenll.concurrent.serializable;

public enum National {

    KOREA;

    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
}
