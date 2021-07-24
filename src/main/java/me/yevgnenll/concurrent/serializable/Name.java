package me.yevgnenll.concurrent.serializable;

import java.io.InputStreamReader;
import java.io.Serializable;

public class Name implements Serializable {

    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    /**
     * 성, null이 아니어야 한다
     * @serial
     */
    private final String lastName;

    /**
     * 이름, null이 아니어야 한다.
     * @serial
     */
    private final String firstName;

    /**
     * 중간이름, 중간이륾이 없다면 null
     * @serial
     */
    private final String middleName;


    private void readObject(InputStreamReader i) {

    }
}
