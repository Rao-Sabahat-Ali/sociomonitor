package Model;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RAO
 */
public class Location {

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String CountryName) {
        this.CountryName = CountryName;
    }

    public Location(String city, int NewsCount, double lat, double lng) {
        this.city = city;
        this.NewsCount = NewsCount;
        this.lat = lat;
        this.lng = lng;
    }

    public Location(int id, String city, double lat, double lng,String CountryName) {
        this.id = id;
        this.city = city;
        this.lat = lat;
        this.lng = lng;
        this.CountryName=CountryName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getNewsCount() {
        return NewsCount;
    }

    public void setNewsCount(int NewsCount) {
        this.NewsCount = NewsCount;
    }
public Location()
{
    
}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    private int id;
    private String city;
    private int NewsCount;
    private double lat;
    private  double lng;
    private String Text;
    private Date date;
    private String CountryName;
    
  
}
