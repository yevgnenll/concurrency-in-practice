package me.yevgnenll.concurrent.serializable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NationalTest {

    @Test
    void test() {
        National national = National.KOREA;
        National na = National.KOREA;
        System.out.println(na);
        System.out.println(national);

    }

    @Test
    void number() {
        System.out.println(1<<31-1);
        System.out.println((2^31)-1);
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    void test2() {

        final int a = 1;
        final int b= 1;
        System.out.println(a);
        System.out.println(b);
    }

}