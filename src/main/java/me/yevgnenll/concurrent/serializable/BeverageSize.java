package me.yevgnenll.concurrent.serializable;

public enum BeverageSize {

    SHORT(237),
    TALL(355),
    GRANDE(473),
    VENTI(591);

    BeverageSize(int capacity) {
        this.capacity = capacity;
    }

    private final int capacity;

    public int capacity() {
        return capacity;
    }

}
