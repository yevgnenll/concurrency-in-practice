package me.yevgnenll.concurrent.poly;

public class Add implements Calculator {

    private final int a;
    private final int b;

    public Add(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int calculate() {
        return a + b;
    }

    @Override
    public String toString() {
        return "Add{" +
            "a=" + a +
            ", b=" + b +
            '}';
    }
}
