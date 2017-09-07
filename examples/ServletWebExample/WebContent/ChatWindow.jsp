<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
</head>
<body>
<FORM action="MessageServlet" method="post">
<input type="textarea" name="messageText"> 
<button name="send" ></button> 
</FORM>
<TEXTAREA rows="10" cols="100">


<c:forEach items="${messages}" var="m">
   <c:out value="${m}"/>
</c:forEach>
</TEXTAREA>





</body>
</html>