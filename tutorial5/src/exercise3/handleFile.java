package exercise3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Stack;

public class handleFile {
	public handleFile(){
		super();

	}

	public static boolean readFile(){

		File file = new File("blog.html");
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

	public static boolean writeNew(String s, String dateAndTime){
		s = dateAndTime + "\n<br/>\n" + s;

		File file = new File("blog.html");

		try {
			FileWriter fwrite = new FileWriter(file);
			BufferedWriter fout = new BufferedWriter(fwrite);
			PrintWriter fprint = new PrintWriter(fout, true);
			fprint.println("<html><head><title>My Blog</title></head><body>");
			fprint.println("<hr />");
			fprint.println(s);
			fprint.println("</body></html>");
			fprint.flush();
			fprint.close();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean writeAppend(String s, String dateAndTime){

		s = dateAndTime + "\n<br/>\n" + s;

		File file = new File("blog.html");
		
		//delete the last line
		RandomAccessFile f;
		try {
			f = new RandomAccessFile(file, "rw");
			long length = f.length() - 1;
			byte b = 0;
			do {                     
			  length -= 1;
			  f.seek(length);
			  b = f.readByte();
			} while(b != 10);
			f.setLength(length+1);
			f.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			FileWriter fwrite = new FileWriter(file, true);
			BufferedWriter fout = new BufferedWriter(fwrite);
			PrintWriter fprint = new PrintWriter(fout, true);
			fprint.println("<hr />");
			fprint.println(s);
			fprint.println("</body></html>");
			fprint.flush();
			fprint.close();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static Stack<String> getText(){

		Stack<String> text = new Stack<String>();

		File file = new File("blog.html");
		try {
			FileReader fread = new FileReader(file);

			BufferedReader fbuff = new BufferedReader(fread);
			String read;
			while((read =fbuff.readLine())!=null){
				String temp = read;
				text.push(temp);
			}
			fbuff.close();

			return text;


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		

	}

}