/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Haris Bin Zia
 */
public class SurveyData {
    private String keyword;
    private String initial_date;
    private String end_date;
   
   

    

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setInitial_date(String initial_date) {
        this.initial_date = initial_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getInitial_date() {
        return initial_date;
    }

    public String getEnd_date() {
        return end_date;
    }
}
