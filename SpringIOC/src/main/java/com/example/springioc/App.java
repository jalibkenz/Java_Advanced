package com.example.springioc;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
// import org.springframework.context.annotation.Scope;

//Spring Inversion Of Control
interface IceCream {
    void eat();
}


@Component
class Vanila implements IceCream {
    public void eat() {
        System.out.println("Vanila");
    }
}
@Primary
@Component
class Chocolate implements IceCream {
    public void eat() {
        System.out.println("Chocolate");
    }
}

// @Scope("prototype")
@Component
class Baby {
    @Autowired
    IceCream i;

    void open() {
        i.eat();
    }

}

@Configuration
@ComponentScan(basePackages = "com.example.springioc")
class MyConfiguration {

}

//class TestBaby{}
public class App {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);

        Baby b1 = ac.getBean(Baby.class);
        b1.open();

        Baby b2 = ac.getBean(Baby.class);
        b2.open();

        if (ac instanceof AnnotationConfigApplicationContext) {
            ((AnnotationConfigApplicationContext) ac).close();
        }

        System.out.println("Checking if Singleton design is practised-> "+(b1==b2));

    }
}
