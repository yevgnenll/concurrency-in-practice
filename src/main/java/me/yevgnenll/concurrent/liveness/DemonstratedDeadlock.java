package me.yevgnenll.concurrent.liveness;

import static me.yevgnenll.concurrent.liveness.DynamicOrderDeadlock.*;

import java.util.*;


/**
 * DemonstrateDeadlock
 * <p/>
 * Driver loop that induces deadlock under typical conditions
 *
 * @author Brian Goetz and Tim Peierls
 */
public class DemonstratedDeadlock {
    private static final int NUM_THREADS = 20;
    private static final int NUM_ACCOUNTS = 5;
    private static final int NUM_ITERATIONS = 1000000;

    public static void main(String[] args) {
        final Random rnd = new Random();
        final Account[] accounts = new Account[NUM_ACCOUNTS];

        for (int i = 0; i < accounts.length; i++)
            accounts[i] = new Account();

        class TransferThread extends Thread {
            public void run() {
                for (int i = 0; i < NUM_ITERATIONS; i++) {
                    int fromAcct = rnd.nextInt(NUM_ACCOUNTS);
                    int toAcct = rnd.nextInt(NUM_ACCOUNTS);
                    DollarAmount amount = new DollarAmount(rnd.nextInt(1000));
                    try {
                        System.out.println("start ----> from: " + accounts[fromAcct] + ",  to: " + accounts[toAcct] + ", amount: " + amount);
                        transferMoney(accounts[fromAcct], accounts[toAcct], amount);
                        System.out.println("from: " + accounts[fromAcct] + ",  to: " + accounts[toAcct] + ", amount: " + amount);
                    } catch (InsufficientFundsException ignored) {
                    }
                }
            }
        }
        for (int i = 0; i < NUM_THREADS; i++)
            new TransferThread().start();
    }
}