import java.io.File;
import java.io.IOException;

class CreateNewFileInTheFolder {
    public static void main(String[] args) throws IOException{
        File f = new File("/Users/jalibkenz/Desktop/AdvancedJava/Folder/hello.txt");

        if (!f.exists()) {
            f.createNewFile();            
        }
        else{
            System.out.println("File doesn't exist");
        }

        
    }
}
