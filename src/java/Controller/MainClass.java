/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBhandler;
import Model.Data;
import Model.Location;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import net.java.frej.fuzzy.Fuzzy;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.apache.commons.io.IOUtils;
import org.json.simple.parser.ParseException;
import java.net.URL;
/**
 *
 * @author RAO
 */
public class MainClass {
    private DBhandler obj;
    public MainClass()
    {
        obj= new DBhandler();
    }
    public static String getLocationFromAPi(String CityName) throws ParseException
    {
        String[] list;
        list=CityName.replaceAll("[^a-zA-Z]","").toLowerCase().split("\\s+");
        CityName=list[0];
         String Address="";
         String url = "https://maps.googleapis.com/maps/api/geocode/json?address="+CityName+"&sensor=false";
	      
	        try {
	            String genreJson = IOUtils.toString(new URL(url));
	            JSONObject genreJsonObject = (JSONObject) JSONValue.parseWithException(genreJson);	          
	            JSONArray genreArray = (JSONArray) genreJsonObject.get("results");
                    if(genreArray.size()==0)
                    {
                        return "";
                    }
                    else
                    {
	            JSONObject firstGenre = (JSONObject) genreArray.get(0);	           	         
                   String City=firstGenre.get("formatted_address").toString();	          	
	            JSONObject obj=(JSONObject)firstGenre.get("geometry");
	            JSONObject loc=(JSONObject) obj.get("location");	            
                    String lat=loc.get("lat").toString();
                    String lng=loc.get("lng").toString();
	            Address= (String)(lat+"/"+lng+"/"+City);
                    }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	return Address;
    }
 public static boolean isNumeric(String str)  
 {  
  try  
  {  
    double d = Double.parseDouble(str);  
  }  
  catch(NumberFormatException nfe)  
  {  
    return false;  
  }  
  return true;  
}
 public static String getLat_lng(String city_Name) throws FileNotFoundException, IOException
 {
      double lat=33.40;
      double lng=73.10;
      String lat_lng=" ";
        String CityName="";
        FileReader fr = new  FileReader("F:\\Semesters\\7th Semester\\FYP-I\\servletsimplewebapp\\LAT.txt");
         BufferedReader br = new BufferedReader(fr);
         String aLine;
         
      while((aLine = br.readLine())!=null)
      {      
          String[] tokens=aLine.split(",");
          if(tokens.length>1)
          {
          String[] CN=tokens[2].split(" ");
          CityName="";
         for(int i=0; i<CN.length;i++)
         {                   
              CityName+=CN[i]+" ";                     
         }         
          if(CityName.toLowerCase().contains(city_Name.toLowerCase()) || city_Name.equalsIgnoreCase(CityName))
              {
                   lat=Double.parseDouble(tokens[0]);
                   lng=Double.parseDouble(tokens[1]);
                   lat_lng=(String)(lat+","+lng+","+CityName);
                   return lat_lng;
              }
          }    
      }
     return lat_lng;
 }   
 public ArrayList<Location> getlocation() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException, ParseException
    {     
        String CityNameDB;
        String lat_lng=null;
        double lat=0.0;
        double lng=0.0;
        String CountryName;
        ArrayList<Data> list= obj.getLocation();
        ArrayList<Location> list1= new ArrayList<>();
        for(int i=0; i<list.size();i++)
        {   
            if(list.get(i).getLoc() == null || list.get(i).getLoc().equals(" ") || list.get(i).getLoc().equals("") || list.get(i).getLoc().equalsIgnoreCase("pakistan"))
            {
                CityNameDB="Islamabad";
                lat_lng=getLat_lng(CityNameDB);
                String[] tokens=lat_lng.split(",");
                lat=Double.parseDouble(tokens[0]);
                lng=Double.parseDouble(tokens[1]);
                CityNameDB=tokens[2];
                String[] ctoken=CityNameDB.split(" ");
                CountryName=ctoken[ctoken.length-1];               
            }
            else
            {              
                CityNameDB=list.get(i).getLoc();
                lat_lng=getLat_lng(CityNameDB);
                if(lat_lng.equals(" "))
                {
                lat_lng=getLocationFromAPi(CityNameDB);
                if(lat_lng.equals(""))
                {
                CityNameDB="Multan";
                lat_lng=getLat_lng(CityNameDB);
                String[] tokens=lat_lng.split(",");
                lat=Double.parseDouble(tokens[0]);
                lng=Double.parseDouble(tokens[1]);
                CityNameDB=tokens[2];
                String[] ctoken=CityNameDB.split(" ");
                CountryName=ctoken[ctoken.length-1];
                }
                else
                {
                String[] tokens=lat_lng.split("/");
                lat=Double.parseDouble(tokens[0]);
                lng=Double.parseDouble(tokens[1]);
                CityNameDB=tokens[2];
                String[] ctoken=CityNameDB.split(",");
                CountryName=ctoken[ctoken.length-1];
                }
                }
                else
                {               
                String[] tokens=lat_lng.split(",");
                lat=Double.parseDouble(tokens[0]);
                lng=Double.parseDouble(tokens[1]);
                CityNameDB=tokens[2];
                String[] ctoken=CityNameDB.split(" ");
                CountryName=ctoken[ctoken.length-1];
                }
            }            
            Location objj= new Location(list.get(i).getId(),CityNameDB, lat, lng,CountryName);
            list1.add(objj);
        }
       
        obj.insertintNewData(list1);
        return list1;
    }
    public ArrayList<Location> getLocationwithCount() throws ClassNotFoundException, SQLException
    {
        ArrayList<Location> list= obj.getLocationWithCount();
        return list;
    }
    
}
