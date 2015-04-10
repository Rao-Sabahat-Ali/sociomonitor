package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Data;
import Controller.MainClass;
import java.util.ArrayList;
import Model.Location;

public final class Main_005fPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html> \n");
      out.write("<head> \n");
      out.write(" <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\">\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>Circles</title>\n");
      out.write("    <style>\n");
      out.write("      html, body, #map-canvas {\n");
      out.write("        height: 100%;\n");
      out.write("        margin: 0px;\n");
      out.write("        padding: 0px\n");
      out.write("      }\n");
      out.write("    </style>\n");
      out.write("    <script src=\"https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true\"></script>\n");
      out.write("    <script>\n");
      out.write("    var circle, map;\n");
      out.write("    function initialize()   \n");
      out.write("    { \n");
      out.write("    ");
 MainClass obj =new MainClass(); 
  //  obj.getlocation();
   ArrayList<Location> list= obj.getLocationwithCount();
    
      out.write("\n");
      out.write("     var locations = [\n");
      out.write("        ");

    for(int i=0; i<list.size();i++)
     {  if(i+1==list.size())
       { 
      out.write("\n");
      out.write("          ['");
      out.print(list.get(i).getCity());
      out.write('\'');
      out.write(',');
      out.print(list.get(i).getLat());
      out.write(',');
      out.print(list.get(i).getLng());
      out.write(',');
      out.print(list.get(i).getNewsCount());
      out.write("]\n");
      out.write("      ");
 } 
      out.write("\n");
      out.write("          ");
 if(i<list.size() && i+1!=list.size()) { 
      out.write("\n");
      out.write("     ['");
      out.print(list.get(i).getCity());
      out.write('\'');
      out.write(',');
      out.print(list.get(i).getLat());
      out.write(',');
      out.print(list.get(i).getLng());
      out.write(',');
      out.print(list.get(i).getNewsCount());
      out.write("],\n");
      out.write("    ");
 } } 
      out.write("\n");
      out.write("    ];\n");
      out.write("     var map = new google.maps.Map(document.getElementById('map-canvas'), {\n");
      out.write("      zoom: 10,\n");
      out.write("      center: new google.maps.LatLng(");
      out.print(list.get(2).getLat());
      out.write(',');
      out.print(list.get(2).getLng());
      out.write("),\n");
      out.write("      mapTypeId: google.maps.MapTypeId.ROADMAP\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    var infowindow = new google.maps.InfoWindow();\n");
      out.write("\n");
      out.write("    var marker, i;\n");
      out.write("\n");
      out.write("    for (i = 0; i < locations.length; i++) { \n");
      out.write("      marker = new google.maps.Marker({\n");
      out.write("        position: new google.maps.LatLng(locations[i][1], locations[i][2]),\n");
      out.write("        map: map\n");
      out.write("      });\n");
      out.write("\n");
      out.write("      google.maps.event.addListener(marker, 'click', (function(marker, i) {\n");
      out.write("        return function() {\n");
      out.write("          infowindow.setContent(locations[i][0]);\n");
      out.write("          infowindow.open(map, marker);\n");
      out.write("        }\n");
      out.write("      })(marker, i));\n");
      out.write("      calcRadius(marker, map, locations[i][3]);\n");
      out.write("    }\n");
      out.write("        // Add click event listenecal\n");
      out.write("        \n");
      out.write("    };\n");
      out.write("    \n");
      out.write("    function calcRadius(marker, map, radiusVal)\n");
      out.write("    {               \n");
      out.write("             circle = new google.maps.Circle({\n");
      out.write("              map: map,\n");
      out.write("              fillColor : '#FF0000',\n");
      out.write("              fillOpacity : 0.3,\n");
      out.write("              radius : radiusVal*100,\n");
      out.write("              strokeColor : '#FF0000',\n");
      out.write("              strokeOpacity : 0.9,\n");
      out.write("              strokeWeight : 2\n");
      out.write("            });           \n");
      out.write("            circle.bindTo('center', marker, 'position');        \n");
      out.write("    }   \n");
      out.write("    google.maps.event.addDomListener(window, 'load', initialize);\n");
      out.write("    \n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div id=\"map-canvas\"></div>\n");
      out.write("  </body\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
