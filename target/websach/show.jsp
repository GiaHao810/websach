
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page import="org.apache.commons.codec.binary.*" %>
<%@ page import="org.apache.commons.codec.binary.*" %>
<%@ page import="org.apache.commons.codec.binary.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>
    



        <h1>aaaaaaaaaaaaaaaaaaaaaaaa</h1>



        <h2>${book_id}</h2>
        <h2>${title}</h2>
        <h2>${price}</h2>
        <img src="data:image/jpeg;base64,${fn:escapeXml(requestScope.image_url)}" />



</body>
</html>