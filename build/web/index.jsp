<%-- 
    Document   : index
    Created on : Sep 5, 2019, 9:32:01 PM
    Author     : felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        Id: <%= request.getAttribute("id") %><br/>
        Name: <%= request.getAttribute("name") %>
    </body>
</html>
