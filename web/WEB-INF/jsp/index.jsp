

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User catalog</title>
    </head>

    <body>
        <a href="user/create.htm">create</a><br/>

    <c:forEach items="${accounts}" var="car">
        username: ${car.name} <a href="user/update/${car.id}.htm">update</a> <a href="user/delete/${car.id}.htm">delete</a>
        <br />
    </c:forEach>
</body>
</html>
