package me.yevgnenll.concurrent.serializable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Serialize {
    public static void main(String[] args) throws IOException {

        Elvis elvis = Elvis.INSTANCE;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);

        out.writeObject(elvis);
        System.out.println(out);
        System.out.println(Arrays.toString(bos.toByteArray()));
    }
}
