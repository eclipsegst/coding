/**
 * Author: Zhaolong Zhong
 * Date  : 2015 11:22:45 AM
 * Notes :
 * Download Image By URL
 * Step 1: Get the JSON object
 * Step 2: Build image URL using the information in the JSON object
 * Step 3: Download image to local
 */
package imageloader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class DownloadImage {

  
  public static void main(String[] args) throws Exception {
    // getHeroIcon();
    
    getItemIcon();
      
    System.out.println("Complete download.");
    
  }
  
  @SuppressWarnings("finally")
  public static void getItemIcon() throws Exception {
    String url = "https://api.steampowered.com/IEconDOTA2_570/GetGameItems/V001/?key=&language=en";
    String jsonStr = getJsonStr(url);
    
    JSONObject result = new JSONObject(jsonStr);
    JSONObject listOfItem = result.getJSONObject("result");
    JSONArray items = listOfItem.getJSONArray("items");
    System.out.println(items.length());
    
    File outputFile = null;
    outputFile = new File("output.txt");
    
    FileOutputStream fos = new FileOutputStream(outputFile);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
    
    for(int i = 0; i < items.length(); i++) {
      System.out.println(i);
      JSONObject item = items.getJSONObject(i);
      String fullName = item.getString("name");
      int id = item.getInt("id");
      
      String name = fullName.substring(5);
      String tmpUrl = "http://cdn.dota2.com/apps/dota2/images/items/" + name + "_lg.png";
      try {
        downloader(tmpUrl, name);
        
        String keyValue = String.valueOf(id) + ":\"" + name + "\","; 
             
        bw.write(keyValue);
        bw.newLine();
        
      } catch (MalformedURLException e){
        System.out.println(name);
      } finally {
        continue;
      }
    }
    
    try{
      bw.close();
    } catch(IOException e) {
        System.out.println("Error Closing File");
    }
  }
  
  public static void getHeroIcon() throws Exception {
    String url = "http://api.steampowered.com/IEconDOTA2_570/GetHeroes/v1?key=";
    String jsonStr = getJsonStr(url);
    
    JSONObject result = new JSONObject(jsonStr);
    JSONObject listOfItem = result.getJSONObject("result");
    JSONArray heroes = listOfItem.getJSONArray("heroes");
    
    for(int i = 0; i < heroes.length(); i++) {
      
      JSONObject hero = heroes.getJSONObject(i);
      String fullName = hero.getString("name");
      
      String name = fullName.substring(14);
      String tmpUrl = "http://cdn.dota2.com/apps/dota2/images/heroes/" + name + "_sb.png";
      downloader(tmpUrl, name);
      System.out.println(name);
    }
  }
  
  public static void downloader(String url, String name) throws IOException {
    URL imageUrl = null;
    try {
      imageUrl = new URL(url);
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    InputStream in = new BufferedInputStream(imageUrl.openStream());
    OutputStream out = new BufferedOutputStream(new FileOutputStream("C://Users//zztg2//Desktop//item_icon//" + name + "_lg.png"));

    for ( int i; (i = in.read()) != -1; ) {
        out.write(i);
    }
    in.close();
    out.close();
  }
  
  public static String getJsonStr(String url) throws Exception{
    URL oracle = new URL(url);
    
    // Method 1:Reading Directly from a URL, gets an input stream directly from the URL
    // BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
    
    // Method 2: Reading from a URLConnection, 
    // retrieves a URLConnection object and gets an input stream from the connection.
    // since it's an object, you can writing to the URL
    URLConnection yc = oracle.openConnection();
    BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
    
    StringBuffer jsonStr = new StringBuffer();
    String inputLine;
    
    while((inputLine = in.readLine()) != null) {
      jsonStr.append(inputLine);  
    }
    
    // Close the input stream
    in.close();
    
    return jsonStr.toString();
  }
  
}
