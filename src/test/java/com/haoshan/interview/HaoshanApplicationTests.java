package com.haoshan.interview;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HaoshanApplicationTests {

    @Test
    void contextLoads() {
        Person zhangsan = new Person("zhangsan", 18);
        Person lisi = zhangsan;
        lisi.setAge(1900);
        lisi.setName("lisi");
        System.out.println(zhangsan == lisi);
        System.out.println(zhangsan);
        System.out.println(lisi);
    }

}
@Data
@AllArgsConstructor
class Person{
    private String name;
    private int age;
}
