import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteInTheFile {
    public static void main(String[] args) throws IOException{
        File f = new File("/Users/jalibkenz/Desktop/AdvancedJava/Folder/hello.txt");
        FileWriter fw = new FileWriter(f);
        if(f.exists()){
            fw.write("Hello dear.\n");
            fw.flush();
            fw.write("How are you?");
            fw.close();
            System.out.println("Written to file");
        }
        else{
            System.out.println("File doesn't exist");
        }

    }
}

