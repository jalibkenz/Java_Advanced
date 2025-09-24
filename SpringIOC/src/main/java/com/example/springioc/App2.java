package com.example.springioc;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

//Spring Inversion Of Control
interface IceCream1 {
    void eat();
}


@Component
class Vanilaz implements IceCream1 {
    public void eat() {
        System.out.println("Vanila");
    }
}
@Primary
@Component
class Chocolatez implements IceCream1 {
    public void eat() {
        System.out.println("Chocolate");
    }
}

@Scope("prototype") // This makes the Spring to leave SINGLETON DESIGN PATTERN and follow PROTOTYPE DESIGN PATTERN (separate object created)
@Component
class Babye {
    @Autowired
    IceCream1 i;

    void open() {
        i.eat();
    }

}

@Configuration
@ComponentScan(basePackages = "com.example.springioc")
class MyConfigurationz {

   
}

//class TestBabye{}
public class App2 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyConfigurationz.class);

        Babye b1 = ac.getBean(Babye.class);
        b1.open();

        Babye b2 = ac.getBean(Babye.class);
        b2.open();

        Babye b3 = (Babye) ac.getBean("babye"); // if not using Babye.class, then (Babye) ac.getBean("babye"); 
        b3.open();

        if (ac instanceof AnnotationConfigApplicationContext) {
            ((AnnotationConfigApplicationContext) ac).close();
        }

        System.out.println("Checking if Singleton design is practised-> "+(b1==b2));



    }
}
