package me.yevgnenll.concurrent.serializable;

import java.io.Serializable;

public class BeverageName implements Serializable {

    public BeverageName(String name) {
        valid(name);
        this.name = name;
    }

    private final String name;

    public String name() {
        return name;
    }

    private void valid(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("음료 이름의 길이는 최소 1자리는 있어야 합니다");
        }
        if (name.length() > 30) {
            throw new IllegalArgumentException("음료 이름의 길이는 30자를 초과할 수 없습니다");
        }
    }

    @Override
    public String toString() {
        return "BeverageName{" +
            "name='" + name + '\'' +
            '}';
    }
}
