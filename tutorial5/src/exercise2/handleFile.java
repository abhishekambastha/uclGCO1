package exercise2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class handleFile {
	public handleFile(){
		super();

	}

	public static boolean readFile(){

		File file = new File("currency.txt");
		try {
			FileReader fread = new FileReader(file);
			fread.close();
			return true;
		} catch (FileNotFoundException e) {
			try {
				file.createNewFile();
				return false;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false; 
	}

	public static boolean writeNew(String s){

		File file = new File("currency.txt");

		try {
			FileWriter fwrite = new FileWriter(file);
			BufferedWriter fout = new BufferedWriter(fwrite);
			PrintWriter fprint = new PrintWriter(fout, true);
			fprint.println(s);
			fprint.flush();
			fprint.close();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean writeAppend(String s){
		File file = new File("currency.txt");		

		try {
			FileWriter fwrite = new FileWriter(file, true);
			BufferedWriter fout = new BufferedWriter(fwrite);
			PrintWriter fprint = new PrintWriter(fout, true);
			fprint.println(s);
			fprint.flush();
			fprint.close();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
