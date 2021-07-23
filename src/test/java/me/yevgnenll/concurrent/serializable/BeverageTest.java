package me.yevgnenll.concurrent.serializable;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.MethodOrderer.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(value = OrderAnnotation.class)
class BeverageTest {

    private static final String FILE_PATH = "./beverage.txt";

    @Test
    @DisplayName(value = "직렬화 과정을 수행한다")
    @Order(value = 0)
    void serializeTest() throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(FILE_PATH);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        try (ObjectOutputStream out = new ObjectOutputStream(bos)) {
            Beverage juice = new Beverage(new BeverageName("orange juice"), BeverageSize.TALL);
            Beverage soda = new Beverage(new BeverageName("soda"), BeverageSize.VENTI);

            List<Beverage> beverageList = new ArrayList<>();
            beverageList.add(juice);
            beverageList.add(soda);

            out.writeObject(juice);
            out.writeObject(soda);
            out.writeObject(beverageList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName(value = "역직렬화를 수행한다")
    @Order(value = 1)
    void deserialize() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(FILE_PATH);
        BufferedInputStream bis = new BufferedInputStream(fis);
        try(ObjectInputStream in = new ObjectInputStream(bis)) {

            Beverage beverage1 = (Beverage)in.readObject();
            Beverage beverage2 = (Beverage)in.readObject();
            List<Beverage> list = (List<Beverage>) in.readObject();

            System.out.println(beverage1.toString());
            System.out.println(beverage2.toString());
            System.out.println("count :: " + list.size());
            System.out.println(list);

            assertThat(beverage1.beverageName()).isEqualTo("orange juice");
            assertThat(beverage1.beverageSize()).isEqualTo(BeverageSize.TALL);
            assertThat(beverage2.beverageName()).isEqualTo("soda");
            assertThat(beverage2.beverageSize()).isEqualTo(BeverageSize.VENTI);
            assertThat(list.size()).isEqualTo(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}