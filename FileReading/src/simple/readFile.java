package simple;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class readFile{
	public static void main(String args[]) throws FileNotFoundException{
		File file = new File("myFile.txt");
		FileReader fRead = new FileReader(file);
	}
}
