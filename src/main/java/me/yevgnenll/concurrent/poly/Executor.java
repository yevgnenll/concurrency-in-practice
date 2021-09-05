package me.yevgnenll.concurrent.poly;

import java.util.ArrayList;
import java.util.List;

public class Executor {

    public static void main(String[] args) {

        List<Calculator> calculators = new ArrayList() {{
            add(new Add(1, 4));
            add(new Minus(4, 2));
            add(new Multiply(2, 7));
            add(new Divide(100, 2));
        }};

        calculators.stream()
            .map(Calculator::calculate)
            .forEach(System.out::println);

    }
}
