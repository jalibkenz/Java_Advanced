import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteWithBuffer {

	public static void main(String[] args) throws IOException {
		File f1 = new File("/Users/jalibkenz/Desktop/AdvancedJava/Folder/Hello_Buffer.txt");
		FileWriter fw = new FileWriter(f1);
		BufferedWriter bw = new BufferedWriter(fw);
		
		if(f1.exists()) {
			bw.newLine(); //only for BufferedWriter
			bw.write("Good afternoon Guys");
			bw.newLine();
			bw.write("Hello hi");
		}
		else{
			System.out.println("No file found");
        }
		bw.flush();
        bw.close();

	}

}