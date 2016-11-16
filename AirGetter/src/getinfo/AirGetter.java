//Air Quality Measurements -- returns the Latest Measurements 

package getinfo;

import java.io.*;
import java.net.*;

import org.json.JSONObject;

public class AirGetter {

	// getMehtod that get the URL given and return whatever as a String // Using a get request
	
   public static String getHTML(String urlToRead) throws Exception {
      StringBuilder result = new StringBuilder();
      URL url = new URL(urlToRead);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      while ((line = rd.readLine()) != null) {
         result.append(line);
      }
      rd.close();
      return result.toString(); // JSON Object
   }
    
   
   // Parse JSON string creating objects
   
   public static void main(String[] args) throws Exception
   {
	 String data;
     data = getHTML("http://data.goteborg.se/AirQualityService/v1.0/LatestMeasurement/b5f338ed-0976-451d-906a-d2da42b65e98?format=Json");
     //System.out.println(data);
     
     JSONObject obj = new JSONObject(data);
     JSONObject obj2 = new JSONObject(obj.getString("Weather")); 
     JSONObject obj3 = new JSONObject(obj2.getString("RainFall"));
     JSONObject obj4 = new JSONObject(obj2.getString("Temperature"));
     JSONObject obj5 = new JSONObject(obj2.getString("Humidity"));
     JSONObject obj6 = new JSONObject(obj2.getString("SolarInsolation"));
     JSONObject obj7 = new JSONObject(obj2.getString("AirPressure"));
     JSONObject obj8 = new JSONObject(obj2.getString("WindDirection"));
     JSONObject obj9 = new JSONObject(obj.getString("AirQuality"));
     JSONObject obj10 = new JSONObject(obj9.getString("NO2"));
     JSONObject obj11 = new JSONObject(obj9.getString("SO2"));
     JSONObject obj12 = new JSONObject(obj9.getString("O3"));
     JSONObject obj13 = new JSONObject(obj9.getString("PM10"));
     JSONObject obj14 = new JSONObject(obj9.getString("NOx"));
     JSONObject obj15 = new JSONObject(obj9.getString("PM2_5"));


	 // Starts from here
	 System.out.println("StartTime: " + obj.getString("StartTime"));
	 System.out.println("StopTime: " + obj.getString("StopTime"));

	 //Print out the Weather values
	 System.out.println("\nWeather:");
	 System.out.println("\nTemperature: 		" + obj4.getString("Value") + " " + obj4.getString("Unit"));
	 System.out.println("Humidity: 		" + obj5.getString("Value") + " " + obj5.getString("Unit"));
	 System.out.println("Solar Insolation: 	" + obj6.getString("Value") + " " + obj6.getString("Unit"));
	 System.out.println("Air Pressure: 		" + obj7.getString("Value") + " " + obj7.getString("Unit"));
	 System.out.println("Wind Direction: 	" + obj8.getString("Value") + " " + obj8.getString("Unit"));
	 System.out.println("RainFall: 		" + obj3.getString("Value") + " " + obj3.getString("Unit"));

	 //Print out the Air Quality values
	 System.out.println("\nAir Quality:");
	 System.out.println("\nNO2:	" + obj10.getString("Value") + "  " +obj10.getString("Unit") + ",	Index: " + obj10.getString("Index"));
	 System.out.println("SO2:	" + obj11.getString("Value") + "   " +obj11.getString("Unit") + ",	Index: " + obj11.getString("Index"));
	 System.out.println("O3:	" + obj12.getString("Value") + "   " +obj12.getString("Unit") + ",	Index: " + obj12.getString("Index"));
	 System.out.println("PM10: 	" + obj13.getString("Value") + "  " +obj13.getString("Unit") + ",	Index: " + obj13.getString("Index"));
	 System.out.println("NOx: 	" + obj14.getString("Value") + "  " +obj14.getString("Unit") + ",	Index: " + obj14.getString("Index"));
	 System.out.println("PM2_5: 	" + obj15.getString("Value") + "   " +obj15.getString("Unit") + ",	Index: " + obj15.getString("Index"));




   }
}