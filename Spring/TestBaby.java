package Spring;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
//Spring Inversion Of Control
interface IceCream {
    void eat(); 
}


class Vanila implements IceCream{
    public void eat(){
        System.out.println("Vanila");
    }
}

class Chocolate implements IceCream{
    public void eat(){
        System.out.println("Chocolate");
    }
}
class Baby{
    @AutoWired
    IceCream i;

}

class MyConfiguration{
    
}

class TestBaby {
    public static void main(String[] args) {
        
    }
}
