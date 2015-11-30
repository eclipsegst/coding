package google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;

/**
 * @author Zhaolong Zhong Nov 29, 2015
 */
public class SumFile {
	public int sumFile(String path, String pathOutput) {
		try {
			int total = 0;
			// read file
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while ((line = br.readLine()) != null) {
				total += Integer.parseInt(line);
			}
			br.close();
			
			// write file with append mode
			BufferedWriter bw = new BufferedWriter(new FileWriter(pathOutput, true));
			bw.newLine();
			bw.write(String.valueOf(total));
			bw.newLine();
			bw.write(String.valueOf(new Date()));
			bw.close();
			
			return total;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
