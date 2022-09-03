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
                    <th>Photo</th>
                    <th>Name</th>
                    <th></th>
                    <th>Delete</th>

                </tr>
                    <tr>
                        <td><img width="100%" alt="Location image" src="/images/${location.photoUrl}"></td>
                        <td>${location.name}</td>

                        <td>
                            <div class="col-sm-10 col-sm-offset-2">
                                <a href="/admin/location/delete/${location.id}">
                                    <button class="btn btn-danger" type="submit">Delete</button>
                                </a>
                            </div>
                        </td>
                    </tr>
                <%--</form:form>--%>
            </table>

            <h3>Location monsters</h3>

            <table class="table table-bordered">
                <tr>
                    <th>Name</th>
                    <th>Hp</th>
                    <th>Mp</th>
                    <th>power</th>
                    <th>Delete</th>


                </tr>
                <c:forEach var="monster" items="${location.monsters}">
                    <tr>
                            <%--<td><img width="100%" alt="Location image" src="/images/${location.photoUrl}"></td>--%>
                        <td>${monster.name}</td>
                        <td>${monster.hitPoint}</td>
                        <td>${monster.manaPoint}</td>
                        <td>${monster.power}</td>

                        <td>
                            <div class="col-sm-10 col-sm-offset-2">
                                <a href="/admin/location/${location.id}/delete/monster/${monster.id}">
                                    <button class="btn btn-danger" type="submit">Delete</button>
                                </a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                <%--</form:form>--%>
            </table>

            <h3>Add monsters to location</h3>

            <table class="table table-bordered">
                <tr>
                    <th>Name</th>
                    <th>Hp</th>
                    <th>Mp</th>
                    <th>power</th>
                    <th>Add</th>


                </tr>
                <c:forEach var="monster" items="${monsters}">

                <tr>
                        <%--<td><img width="100%" alt="Location image" src="/images/${location.photoUrl}"></td>--%>
                    <td>${monster.name}</td>
                    <td>${monster.hitPoint}</td>
                    <td>${monster.manaPoint}</td>
                    <td>${monster.power}</td>

                    <td>
                        <div class="col-sm-10 col-sm-offset-2">
                            <a href="/admin/location/${location.id}/add/monster/${monster.id}">
                                <button class="btn btn-success" type="submit">Add</button>
                            </a>
                        </div>
                    </td>
                </tr>
                </c:forEach>
                    <%--</form:form>--%>
            </table>

        </div>
    </div>


</div>
</body>
</html>