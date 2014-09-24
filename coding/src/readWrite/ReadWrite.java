package readWrite;

import java.io.*;
public class ReadWrite {
	public static void main(String args[])
	{
		int i;
		FileInputStream inputFile = null;
		try {
			inputFile = new FileInputStream("input.txt");
		} catch(FileNotFoundException e){
			System.out.println("Cannot Open File.");
		}
		
		FileOutputStream outputFile = null;
		try {
			outputFile = new FileOutputStream("output.txt");
		} catch(FileNotFoundException e){
			System.out.println("Cannot Open File");
		}
		
		try{
			do{
				i = inputFile.read();
				if(i != -1){
					System.out.print((char) i);
					outputFile.write(i);
				}
			} while(i != -1);
		} catch(IOException e) {
			System.out.println("Error Reading File.");
		}
		
		try{
			inputFile.close();
		} catch(IOException e) {
			System.out.println("Error Closing File");
		}
		
		try{
			outputFile.close();
		} catch(IOException e) {
			System.out.println("Error Closing File");
		}
	}
}