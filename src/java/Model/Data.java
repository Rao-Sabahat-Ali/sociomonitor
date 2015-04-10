/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author RAO
 */
public class Data {
    public void setUser(String user) {
	User = user;
}public String getLoc() {
	return Loc;
}public void setText(String text) {
	Text = text;
}public void setTime(String time) {
	this.time = time;
}public String getUser() {
	return User;
}public String getTime() {
	return time;
}public String getText() {
	return Text;
}
public void setLoc(String loc) {
	Loc = loc;
}

private String keyword;
private String initialdate;
private String enddate;
private String User;
private String Text;
private String time;
private String Loc;
private Date date;
private int id;

private DBhandler objj;
public Data()
{
	objj= new DBhandler();
}

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Data(int id,String User, String Text, Date date, String Loc ) {
        this.User = User;
        this.Text = Text;
        this.Loc = Loc;
        this.date = date;
        this.id = id;
    }
public Data(String text,String user,String date)
{
	this.Text=text;
        this.User=user;
        this.time=date;
}
public void specifyrequirments(String keywords,String initial_date,String end_date)throws InterruptedException, IOException, ParseException, ClassNotFoundException, SQLException
{
	
	keyword=keywords;
	initialdate=initial_date;
	enddate=end_date;
	Social_Websites obj= new Social_Websites();
	ArrayList<Data> list=obj.specifyrequirments(keyword, initialdate, enddate);
        ArrayList<Data> list1=obj.specifyrequirment(keyword,initialdate, enddate);	      
}
 
}

