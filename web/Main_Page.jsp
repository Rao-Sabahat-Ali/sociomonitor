<%-- 
    Document   : index
    Created on : Mar 26, 2014, 6:39:19 PM
    Author     : Haris Bin Zia
--%>

<%@page import="Model.DBhandler"%>
<%@page import="Controller.MainClass"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Location"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" /> 
  <title>Google Maps Multiple Markers</title> 

</head> 
<body>
  
  <div id="map" style="width: 500px; height: 400px;"></div>
  <% DBhandler obj= new DBhandler();
     String res =  obj.connecttoazure();
     
     %>
     <p> <%=res%> </p>
  
</body>
</html>
</html>