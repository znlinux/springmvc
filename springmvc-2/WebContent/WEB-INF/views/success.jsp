<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
  <h4>Success Stage</h4>
  
  time: ${requestScope.time}
  <br><br>
  names: ${requestScope.names}
  <br><br>
  
  request user: ${requestScope.user}
  <br><br>
  session user: ${sessionScope.user}
  <br><br>
  
  
  <fmt:message key="i18n.username"></fmt:message>
  <br><br>
  <fmt:message key="i18n.password"></fmt:message>
  <br><br>
</body>
</html>