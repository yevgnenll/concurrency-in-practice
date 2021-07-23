package me.yevgnenll.concurrent.serializable;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Beverage implements Serializable {

    private static final long serialVersionUID = -2869694270928466514L;

    public Beverage(String partnerName, BeverageName name, BeverageSize size) {
        this();
        this.partnerName = partnerName;
        this.name = name;
        this.size = size;
    }

    public Beverage(BeverageName name, BeverageSize size) {
        this("Sam", name, size);
    }

    public Beverage() {
        this.orderAt = LocalDateTime.now();
    }

    private transient String partnerName;
    private final LocalDateTime orderAt;

    private BeverageName name;
    private BeverageSize size;

    public String beverageName() {
        return name.name();
    }

    public BeverageSize beverageSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Beverage{" +
            "partnerName='" + partnerName + '\'' +
            ", orderAt=" + orderAt +
            ", name=" + name +
            ", size=" + size +
            '}';
    }
}
