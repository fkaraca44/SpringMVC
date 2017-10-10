<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"  %>
    <%@ taglib prefix="security"
  uri="http://www.springframework.org/security/tags" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="sf"%>
        <%@ taglib uri="http://www.springframework.org/tags" prefix="form"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

<a href="${pageContext.request.contextPath }/login">Login</a><p/>
<a href="${pageContext.request.contextPath }/newaccount">register</a><p/>
<sec:authorize access="hasRole ('ADMIN')">
<a href="${pageContext.request.contextPath }/search">search</a><p/>

</sec:authorize>

<a href="${pageContext.request.contextPath }/controlPage">}controlPage</a><p/>
	<c:url var="logoutUrl" value="/logout" />
	<form action="${logoutUrl }" method="post">
		<input type="submit" value="Log out!"/>
	</form>
	

</body>
</html>