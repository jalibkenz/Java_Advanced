/// checking @Bean

package com.example.springioc;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

//Spring Inversion Of Control
interface IceCream11 {
    void eat();
}


@Component
class Vanilaz1 implements IceCream11 {
    public void eat() {
        System.out.println("Vanila");
    }
}
@Primary
@Component
class Chocolatez1 implements IceCream11 {
    public void eat() {
        System.out.println("Chocolate");
    }
}

@Scope("prototype") // This makes the Spring to leave SINGLETON DESIGN PATTERN and follow PROTOTYPE DESIGN PATTERN (separate object created)
@Component
class Babye1 {
    @Autowired
    IceCream11 i;

    void open() {
        i.eat();
    }

}

@Component
class AnotherBabye1 {

    @Qualifier("vanilaz1")
    @Autowired
    IceCream11 i;

    void open() {
        i.eat();
    }

}

@Component
class MyService {
    @Autowired
    private List<String> myList;  // Spring injects the bean from @Bean abc()

    public void printList() {
        System.out.println(myList);
    }
}


@Configuration
@ComponentScan(basePackages = "com.example.springioc")
class MyConfigurationzz {

    @Bean
    public ArrayList<String> abc() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Jalib Kenz from Bean");
        return list;   // <-- Spring registers this object as a bean
    }
}
   


//class TestBabye1{}
public class App3 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyConfigurationzz.class);

        Babye1 b1 = ac.getBean(Babye1.class);
        b1.open();

        Babye1 b2 = ac.getBean(Babye1.class);
        b2.open();

        Babye1 b3 = (Babye1) ac.getBean("babye1"); // if not using Babye1.class, then (Babye1) ac.getBean("babye1"); 
        b3.open();

        AnotherBabye1 b4 = ac.getBean(AnotherBabye1.class);
        b4.open();

        

        MyService ms = ac.getBean(MyService.class);
        ms.printList();

        if (ac instanceof AnnotationConfigApplicationContext) {
            ((AnnotationConfigApplicationContext) ac).close();
        }
    }
}
