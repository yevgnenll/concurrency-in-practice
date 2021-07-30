package me.yevgnenll.concurrent.serializable.enhanced;

import java.util.Arrays;

public enum Elvis {
    INSTANCE;

    private String[] favoriteSongs = {
        "Hound Dog", "Heartbreak Hotel"
    };

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}
