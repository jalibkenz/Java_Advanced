import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LengthOfInput {

    public static void main(String[] args) throws IOException {

        // write into file
        File f = new File("/Users/jalibkenz/Desktop/AdvancedJava/Folder/writeandread.txt");
        FileWriter fw = new FileWriter(f);
        if (!f.exists()) {
            f.createNewFile();

        }
        fw.write("Hello dear how are you?");
        fw.flush();
        fw.close();

        // read from file and check length
        FileReader fr = new FileReader(f);
        int i;
        long count=0;
        while ((i = fr.read()) != -1) { // read() returns -1 at end of file
            System.out.print((char) i);
            count++;
        }
        fr.close();
        System.out.println("\nLength->"+count);

        //check file length
        System.out.println("f.length()->"+f.length());
    }

}
