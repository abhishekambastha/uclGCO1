package helloWorld;
import java.io.*;

public class check {
	public static void main(String...args) throws IOException{
		File nFile = new File("file.txt");
		nFile.createNewFile();
		
		try{
			InputStreamReader ir = new InputStreamReader(System.in);
			BufferedReader in=new BufferedReader(ir);
			PrintWriter out = new PrintWriter(new FileWriter(nFile));
			String s;
			
			while((s=in.readLine())!=null){
				out.println(s);
			}
	
			in.close();
			out.flush();
			out.close();
			
		}catch(Exception e){
			
		}
		
		System.out.println("Check File:" + nFile.getAbsolutePath());
	}
}
