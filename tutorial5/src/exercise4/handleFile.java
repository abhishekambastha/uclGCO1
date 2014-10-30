package exercise4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class handleFile {
	public handleFile(){
		super();
		
	}
	
	public static boolean readFile(){
		
		File file = new File("Score.txt");
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
	
	public static boolean writeNew(String s, int score){
		s = s +"\t" + score;
		File file = new File("Score.txt");
		
		try {
			file.createNewFile();
			System.out.println("File Created");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	/*	try {
			FileWriter fwrite = new FileWriter(file);
			BufferedWriter fout = new BufferedWriter(fwrite);
			PrintWriter fprint = new PrintWriter(fout, true);
			fprint.println(s);
			fprint.flush();
			fprint.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}finally{
			
		}*/
		return true;
	}
	
	public static boolean writeAppend(String s, int score){
		
		s = s +"\t" + score;
		
		File file= new File("Score.txt");
		try {
			FileWriter fwrite = new FileWriter(file, true);
			BufferedWriter fout = new BufferedWriter(fwrite);
			PrintWriter fprint = new PrintWriter(fout, true);
			fprint.println(s);
			fprint.flush();
			fprint.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static String[] getScores(){
		
		ArrayList<String> scores = new ArrayList<String>();
		
		File file = new File("Score.txt");
		try {
			FileReader fread = new FileReader(file);
			
			BufferedReader fbuff = new BufferedReader(fread);
			String read;
			while((read =fbuff.readLine())!=null){
				String[] temp = read.split("\t");
				scores.add(temp[1]);
			}
			fbuff.close();
			
			String[] results = new String[scores.size()];
			
			for(int i=0; i<scores.size(); i++){
				results[i] = scores.get(i);
			}
			
			return results;
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] ab = {"a","a"};
		return ab;
		
	}

}
