package removeDuplicateLines;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * Problem:
 * Remove duplicate lines in a file.
 * 
 * Solution:
 * Use FileReader and FileWriter to read and write the file. 
 * Use BufferedReader and BufferedWriter to read and write memory
 * Use HashSet to store unique lines
 */

public class RemoveDuplicateLines {
	public static void main(String[] args) throws IOException{
		System.out.println("Remove dupliate lines in a files");
		String path = "./files/duplicateLines.txt";
		removeDuplicateLines(path);
	}
	
	public static void removeDuplicateLines(String filename) throws IOException{
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			//Set<String> lines = new LinkedHashSet <String>(10000); // keep in order
			Set<String> lines = new HashSet <String>(10000);
			String line;
			while((line = reader.readLine()) != null){
				lines.add(line); // duplicate value will not be added to the hashset.
				System.out.println(line);
			}
			reader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
			for(String unique : lines){
				System.out.println(unique);
				writer.write(unique);
				writer.newLine();
			}
			writer.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
