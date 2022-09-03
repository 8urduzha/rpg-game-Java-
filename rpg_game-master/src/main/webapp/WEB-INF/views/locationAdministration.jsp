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
                    <th>Edit location</th>
                    <th>Delete</th>

                    </tr>
                <%--<form:form class="form-horizontal"--%>
                    <%--action="/getOneHero" method="POST">--%>
                    <c:forEach var="location" items="${locations}">
                <tr>
                    <td><img width="100%" alt="Location image" src="/images/${location.photoUrl}"></td>
                    <td>${location.name}</td>
                    <td>
                        <div class="col-sm-10 col-sm-offset-2">
                            <a href="/admin/location/${location.id}">
                                <button class="btn btn-success" type="submit">Edit</button>
                            </a>
                        </div>
                    </td>

                    <td>
                        <div class="col-sm-10 col-sm-offset-2">
                            <a href="/admin/location/delete/${location.id}">
                            <button class="btn btn-danger" type="submit">Delete</button>
                            </a>
                        </div>
                    </td>
                </tr>
                </c:forEach>
                <%--</form:form>--%>
            </table>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
            <form:form class="form-horizontal"
                       action="/addLocation" method="POST" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="locationName" class="control-label col-sm-2">Location name:</label>
                    <div class="col-sm-10">
                        <input type="text" name="locationName" id="locationName" class="form-control" />
                    </div>

                </div>
                <div class="form-group">
                    <label for="file" class="control-label col-sm-2">Select img:</label>
                    <div class="col-sm-10">
                        <input name="image" id="image" type="file">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-10 col-sm-offset-2">
                        <button class="btn btn-success" type="submit">add Location</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>

</div>
</body>
</html>