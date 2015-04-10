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

/**
 *
 * @author RAO
 */
public class Socio_Monitor {
    private Data obj;
    private UserCatalog objec;
	public Socio_Monitor()
	{
            objec=new UserCatalog();
           
	}
	public void acquiredata()
	{
		obj= new Data();
                
	}
	public void specifyrequirement(String keyword,String initialdate,String enddate) throws IOException, ParseException, ClassNotFoundException, SQLException
	{	
            
	try {
		obj.specifyrequirments(keyword, initialdate, enddate) ;
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        
	}
      
}
