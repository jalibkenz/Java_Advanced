
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadWithBuffer {

	public static void main(String[] args) throws IOException {
		File f1 = new File("/Users/jalibkenz/Desktop/AdvancedJava/Folder/hello.txt");
		FileReader fr = new FileReader(f1);
		BufferedReader br = new BufferedReader(fr);
		
		String s1=br.readLine();
		while(s1!=null) {
			System.out.println(s1);
			s1=br.readLine();
		}
        br.close();
	}
}