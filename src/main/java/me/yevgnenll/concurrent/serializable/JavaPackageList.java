package me.yevgnenll.concurrent.serializable;

import java.awt.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.ReentrantLock;

public class JavaPackageList {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();

        // value class
        BigInteger bigInteger;
        ReentrantLock reentrantLock;

        // 상속용
        Throwable throwable;
        Component component;
        Hashtable hashtable;
        Vector vector;
        Collections.synchronizedList(new ArrayList<>());
    }
}
