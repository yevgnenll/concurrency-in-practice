package me.yevgnenll.concurrent.serializable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ElvisImpersonator {

    // 진짜 Elvis 인스턴스로는 만들어질 수 없는 바이트 스트림
    private static final byte[] serializedForm = {
        -84, -19, 0, 5, 115, 114, 0, 42, 109, 101, 46, 121, 101, 118, 103, 110, 101, 110, 108, 108, 46, 99, 111, 110,
        99, 117, 114, 114, 101, 110, 116, 46, 115, 101, 114, 105, 97, 108, 105, 122, 97, 98, 108, 101, 46, 69, 108, 118,
        105, 115, -42, -124, -118, 12, 32, 123, 72, 7, 2, 0, 1, 91, 0, 13, 102, 97, 118, 111, 114, 105, 116, 101, 83,
        111, 110, 103, 115, 116, 0, 19, 91, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110,
        103, 59, 120, 112, 117, 114, 0, 19, 91, 76, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 83, 116, 114, 105, 110,
        103, 59, -83, -46, 86, -25, -23, 29, 123, 71, 2, 0, 0, 120, 112, 0, 0, 0, 2, 116, 0, 9, 72, 111, 117, 110, 100,
        32, 68, 111, 103, 116, 0, 16, 72, 101, 97, 114, 116, 98, 114, 101, 97, 107, 32, 72, 111, 116, 101, 108
    };

    public static void main(String[] args) {
        Elvis a = ElvisStealer.impersonator;
        // ElvisStealer.impersonator 를 초기화 한 다음
        // 진짜 Elvis (즉, Elvis.INSTANCE)를 반환한다
        Elvis elvis = (Elvis)deserialize(serializedForm);
        Elvis impersonator = ElvisStealer.impersonator;

        elvis.printFavorite();
        impersonator.printFavorite();
    }

    static Object deserialize(byte[] sf) {
        try {
            return new ObjectInputStream(new ByteArrayInputStream(sf)).readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
