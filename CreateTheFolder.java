import java.io.File;

public class CreateTheFolder {
    public static void main(String[] args) {
        File f = new File("/Users/jalibkenz/Desktop/AdvancedJava/Folder");
        if(!f.exists()){
            f.mkdir();
            System.out.println("Folder is created");
        }
        else{
            System.out.println("Folder exists");
        }
        
    }
    
}