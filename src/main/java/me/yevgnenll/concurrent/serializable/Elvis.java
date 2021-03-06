package me.yevgnenll.concurrent.serializable;

import java.io.Serializable;
import java.util.Arrays;

public class Elvis implements Serializable {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {}

    private String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};
    public void printFavorite() {
        System.out.println(Arrays.toString(favoriteSongs));
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
