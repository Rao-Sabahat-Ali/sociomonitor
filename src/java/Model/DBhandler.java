package Model;

import java.io.*;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static jdk.nashorn.internal.runtime.Debug.id;

import java.sql.*;

public class DBhandler {
           Connection con = null;
	   Statement stmt = null;
	   String category=null;
	   PreparedStatement ps=null;
public DBhandler()
{
	
}
public ArrayList<Data> getLocation() throws ClassNotFoundException, SQLException
{
                   ArrayList<Data> list= new ArrayList<>();
                   Class.forName("com.mysql.jdbc.Driver");
		   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sociomonitor","root","1234");	
		   stmt = (Statement) con.createStatement();
		   String sql="Select * from rawnews where idrawdata<=6820 and idrawdata>6331";
		   ResultSet result=stmt.executeQuery(sql);		   
		   while(result.next())
		   {
		     	Data obj= new Data(result.getInt("idrawdata"),result.getString("source"),result.getString("text"),result.getDate("date"),result.getString("location"));
                        list.add(obj);
                   }                  
                   con.close();
                   return list;            
}
public ArrayList<Location> getLocationWithCount() throws ClassNotFoundException, SQLException
{
                  ArrayList<Location> list= new ArrayList<>();
                  Class.forName("com.mysql.jdbc.Driver");
		   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sociomonitor","root","1234");	
		   stmt = (Statement) con.createStatement();
		   String sql="Select CityName,Lat,Lng,Count(CityName) as Count_City  from location group by lat";
		   ResultSet result=stmt.executeQuery(sql);
		   
		   while(result.next())
		   {
		     	 Location obj= new Location(result.getString("CityName"),result.getInt("Count_City"),result.getDouble("lat"),result.getDouble("lng"));
                         list.add(obj);
                   }
                   
                   con.close();
                   return list;
            
}
public void insertintNewData(ArrayList<Location> list) throws ClassNotFoundException, SQLException
{
                   Class.forName("com.mysql.jdbc.Driver");
		   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sociomonitor","root","1234");
		   con.setAutoCommit(false); 
                   String sql = "INSERT INTO location (id,CityName,Lat,Lng,CountryName) " +
                   "VALUES (?,?,?,?,?)";
           PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql); 
           for(int i=0;i<list.size();i++)
		   {
			   ps.setInt(1, list.get(i).getId());			  
			   ps.setString(2,list.get(i).getCity() );
			   ps.setDouble(3, list.get(i).getLat());
			   ps.setDouble(4,list.get(i).getLng());
                           ps.setString(5,list.get(i).getCountryName());
		           ps.addBatch();
	           }
	      ps.executeBatch();
	      con.commit();
	      con.setAutoCommit(true);
	      con.close();
}
public String connecttoazure()
{
 String connectionUrl = "jdbc:sqlserver://ptmwqztprx.database.windows.net;"
                                    + "database=sociomonitor;"
                                    + "user=Admin007@ptmwqztprx.database.windows.net;"
                                    + "password=Rao12345";
 
 
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        Connection con = (Connection) DriverManager.getConnection(connectionUrl);
        System.out.print("Connected.");
        String SQL = "SELECT * FROM location";
        Statement stmt = (Statement) con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            return (rs.getString(1) + rs.getString(3));
        }
    }catch(Exception e){
 return "err";            
}

 return "rrr";
 
 
}
}

