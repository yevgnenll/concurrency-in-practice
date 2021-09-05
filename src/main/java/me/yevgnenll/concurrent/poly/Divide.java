package me.yevgnenll.concurrent.poly;

public class Divide extends Validator {

    private final int a;
    private final int b;

    public Divide(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    protected void validate(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("분모는 0이 될 수 없습니다");
        }
    }

    @Override
    public int calculate() {
        validate(a, b);
        return a / b;
    }

    @Override
    public String toString() {
        return "Divide{" +
            "a=" + a +
            ", b=" + b +
            '}';
    }
}
