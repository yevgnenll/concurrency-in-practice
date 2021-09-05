package me.yevgnenll.concurrent.poly;

public class Multiply implements Calculator {

    private final int a;
    private final int b;

    public Multiply(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int calculate() {
        return a * b;
    }

    @Override
    public String toString() {
        return "Multiply{" +
            "a=" + a +
            ", b=" + b +
            '}';
    }
}
