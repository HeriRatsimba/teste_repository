<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shoes shop | Admnistration</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" 
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
 	crossorigin="anonymous">
</head>
<body>
	<div class="row">
    	<div class="container">
    		<h3 class="text-center">Liste des admnistrateurs</h3>
    		<hr>
    		<div class="container text-left">
    			<a href="<%= request.getContextPath()%>/new" class="btn btn-success">Nouvelle enregistrement</a>
    		</div>
    		<br>
    		<table class="table table-bordered">
    			<thead style="text-align: center">
    				<tr>
    					<th>Id</th>
    					<th>Nom</th>
    					<th>Email</th>
    					<th>Téléphone</th>
    					<th>Actions</th>
    				</tr>
    			</thead>
    			<tbody style="text-align: center">
    				<c:forEach var="admin" items="${listAdmin}">
    					<tr >
    						<td><c:out value="${admin.id }"/></td>
    						<td><c:out value="${admin.nom }"/></td>
    						<td><c:out value="${admin.email }"/></td>
    						<td><c:out value="${admin.telephone }"/></td>
    						<td>
    						<a href="delete?id=<c:out value="${admin.id }"/>" class="btn btn-danger" onclick="return confirm('Voulez vous faire cette action?')">Supprimer</a></td>
    					</tr>
    				</c:forEach>
    			</tbody>
    		</table>
    	</div>
    </div>
</body>
</html>