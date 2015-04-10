package Model;
import facebook4j.conf.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import java.text.ParseException;

import java.util.ArrayList;
import javax.json.Json;
import javax.json.stream.JsonParser;


import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public class Social_Websites {
	private ConfigurationBuilder cb;
	private Twitter twitter;
	private Data objj= new Data();

        
public Social_Websites()
{
	cb = new ConfigurationBuilder(); 
	cb.setOAuthConsumerKey("pzaTYtDue7TbqQghQUcewZFMa"); 
	cb.setOAuthConsumerSecret("fsknSItSdiITTrADPUmWRjXN8f6j1t18MlNPu0z9lGIPrBVktZ"); 
	cb.setOAuthAccessToken("395157000-iKrvTqVPF7WYPEoH3K2Jcj4UNwNdC1FB2FAUSMZh"); 
	cb.setOAuthAccessTokenSecret("8HUcRkDhoU8x9JjL2LfyQNaLzcV8z2kzmZr3O1o12ZNLS"); 
	twitter = new TwitterFactory(cb.build()).getInstance(); 
	
}
public ArrayList<Data> specifyrequirments(String keyword,String initialdate,String enddate)throws InterruptedException, IOException, ParseException
{
	ArrayList<Data> list= new ArrayList<Data>();
	int count = 0;
//	SentimentClassifier sentClassifier = new SentimentClassifier();
	
	Query query = new Query(keyword); 
	query.setCount(100); 
	try { 
	
			QueryResult r; 
			do 
			{ 
				r = twitter.search(query); 
				ArrayList<Status> ts = (ArrayList) r.getTweets();
				
				for (int i = 0; i<ts.size() ; i++) 
				{ 	 	
					count++;
			    	        Status t = ts.get(i);
					String text = t.getText();			
				   
				    String name = t.getUser().getScreenName(); 
				    
				    String lang = t.getLang();
				   System.out.println(lang);
				     String Time=t.getCreatedAt().toString();
				     String[] datesplit=Time.split(" ");
				     String year= datesplit[datesplit.length-1];
				     String day=datesplit[datesplit.length-4];
                                     String month=datesplit[datesplit.length-5];
                                     if(month.equals("Dec"))
                                      {
                    	               month="12";
                                       }
                                     String date=day+"-"+month+"-"+year;
                                    
				     String loc = t.getUser().getLocation();
				     
				    Data objj= new Data(text,name,date);
				    list.add(objj);
				     if(count==500)
				       {
					break;			
				        }
                                                                                                                  
			}
                        }
			while ((query = r.nextQuery()) != null);
}
	catch (TwitterException te) 
	{ 
		
	}
	return list;
}
public ArrayList<Data> specifyrequirment(String keyword,String initialdate,String enddate) throws MalformedURLException
{
                String name=null;
                String DAte=null;
                String text=null;
                ArrayList<Data> list= new ArrayList<>();
                ArrayList<String> myarraylist= new ArrayList();
		facebook4j.conf.ConfigurationBuilder configurationBuilder = new facebook4j.conf.ConfigurationBuilder();
		configurationBuilder.setDebugEnabled(true);
		configurationBuilder.setOAuthAppId("1498789317054322");
		configurationBuilder.setOAuthAppSecret("a963facebc9477a19357040cd93c179c");
		configurationBuilder.setOAuthAccessToken("1498789717054282|0GBk5HXmmZohJUkWgZtyTnN8v5k"); 
		configurationBuilder .setOAuthPermissions("email, publish_stream, id, name, first_name, last_name, read_stream , generic,caption,message");
		configurationBuilder.setUseSSL(true);
		configurationBuilder.setJSONStoreEnabled(true); 
		Configuration configuration = configurationBuilder.build();
               
		URL url= new URL("https://graph.facebook.com/search?q="+keyword+"&type=page&fields=id,name&limit=15&access_token="+configuration.getOAuthAccessToken()+"");
                try  {
                    InputStream is =  url.openStream();
	            JsonParser parser = Json.createParser(is);
                    
			      while (parser.hasNext()) 
                              {                                
			          JsonParser.Event e = parser.next();
                                 
			          if (e == JsonParser.Event.KEY_NAME) {
			              switch (parser.getString()) {
			                  case "id":
			                        parser.next();                                               
			                        myarraylist.add(parser.getString());                            
			                      break;                                         
			                  default:                                             
			                      parser.next();
			                      break;
			              }
			          }
			      }
		}
			  
			  catch(Exception e)
			  {
				  e.getStackTrace();
			  }
                for(int i=0; i<myarraylist.size();i++)
                {
                    String pageId=myarraylist.get(i);
                    URL url2 = new URL("https://graph.facebook.com/"+pageId+"/posts?limit=15&access_token="+configuration.getOAuthAccessToken()+"");  
                    try  {
                    InputStream is =  url2.openStream();
	            JsonParser parser = Json.createParser(is);
                 
			      while (parser.hasNext()) 
                              {                                
			          JsonParser.Event e = parser.next();
                                
			          if (e == JsonParser.Event.KEY_NAME) {
			              switch (parser.getString()) {
			               case "name":
                              parser.next();
                              name=parser.getString();
                                                          
                              break;
			                  case "message":
			                                  parser.next();
			                                  text=parser.getString();
                                                                              
			                      break;			                 
			                  case "created_time":
			                                  parser.next();
			                                  DAte=parser.getString();
			                                  String[] split=DAte.split("-");
			                                  String date=split[split.length-1];
			                                  date=date.substring(0,2);
			                                  DAte=date+"-"+split[split.length-2]+"-"+split[split.length-3];			                                 	
                                                      if(text.length()>=8 && text.length()<=255)
                                                      {
                                                          Data obj= new Data(text,name,DAte);
                        			          list.add(obj);
                                                      }
                                                      else if(DAte.equals(initialdate)==true || DAte.equals(enddate)==true)
                                                      {
                                                          Data obj= new Data(text,name,DAte);
                        			          list.add(obj);
                                                      }
			              }
			          }
			      }
		}
			  catch(Exception e)
			  {
				  e.getStackTrace();
			  }
                }
                return list;
}

}