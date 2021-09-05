package me.yevgnenll.concurrent.poly;

public class Minus implements Calculator {

    private final int a;
    private final int b;

    public Minus(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int calculate() {
        return a - b;
    }

    @Override
    public String toString() {
        return "Minus{" +
            "a=" + a +
            ", b=" + b +
            '}';
    }
}
