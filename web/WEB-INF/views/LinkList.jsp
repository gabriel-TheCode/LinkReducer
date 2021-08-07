<%-- 
    Document   : linkList
    Created on : 22 juil. 2021, 20:40:55
    Author     : gabrielthecode
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reducteur d'URL</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body> 
        <div class="container">
            <h1>Bienvenue sur votre reducteur d'URLs favori!</h1>
            <h4>
                <a href="new">Raccourcir une URL</a>
                &nbsp;&nbsp;&nbsp;
            </h4><br/>
            <div align="left">
                <h3>Liste d'URLs raccourcies</h3>

                <ul>
                    <c:forEach var="link" items="${listLink}">
                        <li>${link.url} via <a onclick="window.open('<c:out value="${link.url}"/>', '_blank')" href="link?id=<c:out value='${link.id}' />">http://localhost:8080/${link.code}</a> ${empty link.username ? '' : 'par'} ${link.username} (${link.visit} accès)</li>                  

                        <a href="edit?id=<c:out value='${link.id}' />">Modifier</a>
                        &nbsp;&nbsp;|&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${link.id}' />">Supprimer</a> 
                        <hr>

                    </c:forEach>
                </ul>

            </div>  
        </div>
    </body>
</html>
