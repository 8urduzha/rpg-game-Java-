<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>Apartments</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <table class="table table-bordered">
                <tr>
                    <th>Name</th>
                    <th>Passed!</th>

                <%--</tr> <form:form class="form-horizontal"--%>
                                 <%--action="/getOneHero" method="POST">--%>
                <c:forEach var="location" items="${locations}">
                    <tr>
                        <td>${location.name}</td>
                <c:if test="${location.passedByHero}"><td style="background: green">1</td></c:if>
                <c:if test="${!location.passedByHero}"><td style="background: red">2</td></c:if>
                        <td>
                            <%--<input type="radio" id="${hero.id}"--%>
                                   <%--name="heroId" value="${hero.id}">--%>
                            <%--<label for="heroId">choose hero</label>--%>
                        </td>
                    </tr>
                </c:forEach>
                <div class="col-sm-10 col-sm-offset-2">
                    <button class="btn btn-success" type="submit">make choose</button>
                </div>

            <%--</form:form>--%>
            </table>
        </div>
    </div>
    <div class="row">
    </div>
</div>
</body>
</html>