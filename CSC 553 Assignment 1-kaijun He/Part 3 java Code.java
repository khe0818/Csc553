import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class homeworkOne {
	public static void main(String [] args) {
		 		String s = new String();
	 
	        try
	        {
	            FileReader fr = new FileReader(new File("C:\\Users\\kaijun\\Desktop\\Csc553\\input.sql"));
	            BufferedReader br = new BufferedReader(fr);
	            int i = 1;
	            s = "Query#" + i + ":";
	            System.out.println(s);
	            boolean flag = false;
	            s = br.readLine();
	            while(s != null) {	
	            	String input = s.toString();
	            	if(input.length() != 0) {
		            	int m = s.indexOf(' ');
		            	String word = input.substring(0, m) + " :";
		            	String rest = input.substring(m);
		            	
		            	if(rest.contains("AND")) {
		            		rest = rest.replaceAll("AND", "");
		            	}
		            	
		            	System.out.println(word + rest);
	            	}
	            	
	            	if(s.endsWith(";") && s != null) {	
	            		i++;  
	            		flag = true;
	            		
	            	}
	            	s = br.readLine();
	            	if(s != null && flag) {
	            		System.out.println();
	            		System.out.println();
	            		System.out.println("Query#" + i + ":");
	            		flag = false;
	            	}
	            }
	            br.close();
	          
	            
	        }
	        catch (Exception e) {
	        	
	        }
	 
	}
	
}
