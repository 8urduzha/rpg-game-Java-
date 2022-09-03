
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello world!</title>
</head>
<body>
<h2 class="hello-title">Hello ${name}!</h2>

<sec:authorize  access="isAuthenticated()">
    <a href="/logout">logout</a>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="/admin">admin</a>
</sec:authorize>
<a href="/login"> Login</a>
<a href="/registration"> registration</a>
</body>
</html>