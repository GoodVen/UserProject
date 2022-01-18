<%-- 
    Document   : usercreate
    Created on : 15.12.2018, 18:01:35
    Author     : Sergey
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>        
    </head>
    <body>
        <h1>Update user</h1>
    <c:url var="saveUrl" value="/user/save.htm" />
    <form:form modelAttribute="userAttribute" method="POST" action="${saveUrl}">

        <form:hidden path="id" />
        User:
        <form:input path="name"></form:input>
        <input type="submit" value="Save" />
    </form:form>
</body>
</html>
