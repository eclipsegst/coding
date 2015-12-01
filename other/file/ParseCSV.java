package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Arrays;


/**
 * @author Zhaolong Zhong Nov 30, 2015
 */
public class ParseCSV {
	
	public static void parseCSV() throws IOException {
		String path = "./files/airports.csv";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			String[] strs = line.split(",");
			System.out.println(Arrays.toString(strs));
			int total = 0;
			while ((line = br.readLine()) != null) {
				strs = line.split(",");
				if (total < 10) {
					System.out.println(Arrays.toString(strs));
				}
				total++;
			}
			br.close();
			System.out.println("" + total);
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void parseCSV2() {
		String path = "./files/airports.csv";
		try {
			InputStream inputStream = new FileInputStream(path);
			int inputStreamSize = inputStream.available();
            byte[] inputStreamBuffer = new byte[inputStreamSize];

            inputStream.read(inputStreamBuffer);
            inputStream.close();

            String data = new String(inputStreamBuffer, "UTF-8");
            String[] lines = data.split("\n");
            System.out.println(lines[0]);
            System.out.println(lines[1]);
            
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		parseCSV();
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
	}
}
