package me.yevgnenll.concurrent.liveness;

public class LeftRightDeadlock {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            synchronized (right) {
                doSomething();
            }
        }
    }

    public void rigthLeft() {
        synchronized (right) {
            synchronized (left) {
                doSomethingElse();
            }
        }
    }

    private void doSomething() {

    }

    private void doSomethingElse() {

    }
}
