/**
 * Author: Zhaolong Zhong
 * Date  : Mar 30, 2015 1:00:00AM
 *
 */
package weatherdataparser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.*;
import java.io.*;

public class WeatherDataParser {
  
  /**
   * Given a string of the form returned by the api call:
   * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7 
   * retrieve the maximum temperature for the day indicated by dayIndex
   * (Note: 0-indexed, so 0 would refer to the first day).
   */
  public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
      throws JSONException {
      // TODO: add parsing code here
    JSONObject weather = new JSONObject(weatherJsonStr);
    JSONArray days = weather.getJSONArray("list");
//    JSONObject dayInfo = days.getJSONObject(dayIndex);
//    JSONObject temperatureInfo = dayInfo.getJSONObject("temp");
//    return temperatureInfo.getDouble("max");
    
    for(int i = 0; i < days.length(); i++) {
          JSONObject listObject = days.getJSONObject(i);      
          
          int date = Integer.parseInt(listObject.get("dt").toString());
  
          if (date == dayIndex) {
            JSONObject tempObject = (JSONObject)listObject.get("temp");
            return Double.parseDouble(tempObject.get("max").toString());
          }
  
    }
    return -1;
  }
  
  
  public static void main(String[] args) throws Exception {
    // String url = "http://www.zhaolongzhong.com/rest/club.php";
    String url = "http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7";
    String weatherJsonStr = getJsonStr(url);
    int dayIndex = 1427918400;

    double res = getMaxTemperatureForDay(weatherJsonStr, dayIndex);
    System.out.println(res);
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
