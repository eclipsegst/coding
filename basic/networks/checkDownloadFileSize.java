package networks;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * @author Zhaolong Zhong Mar 4, 2016
 */
public class checkDownloadFileSize {

	public static void main(String[] args) {
		System.out.println("hello");
		ArrayList<String> urls = new ArrayList<>();
		urls.add("http://static.zephyrcharts.com/maps/VFR.db");
		urls.add("http://static.zephyrcharts.com/maps/IFRL.db");
		urls.add("http://static.zephyrcharts.com/maps/IFRH.db");
		urls.add("http://static.zephyrcharts.com/maps/TAC.db");
		urls.add("http://static.zephyrcharts.com/maps/WAC.db");
		for (String url : urls) {
			CheckDownloadFileSize(url);
		}
	}
	
	private static void CheckDownloadFileSize(String urlString) {
		URL url;
		try {
			url = new URL(urlString);
			URLConnection urlConnection;
			urlConnection = url.openConnection();
			urlConnection.connect();
			int fileSize = urlConnection.getContentLength();
			
			System.out.println(humanReadableByteCount(fileSize, false));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Reference: http://stackoverflow.com/a/3758880
	 */
	private static String humanReadableByteCount(long bytes, boolean si) {
	    int unit = si ? 1000 : 1024;
	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
	    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}

}
