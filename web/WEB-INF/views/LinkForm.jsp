<%-- 
    Document   : LinkForm
    Created on : 22 juil. 2021, 20:41:24
    Author     : gabrielthecode
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter une URL</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style type="text/css">
         form { margin: auto; border: solid highlighttext; display: block;}
      </style>

    </head>
    <body>
        <div class="container">
            <center>
                <h1>Reducteur d'URL!</h1>
                <h4>
                    <a href="new">Ajouter un nouveau lien</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="list">Liste des mini URLs</a>
                </h4>
            </center>
            
            <form action=${empty link ? 'insert' : 'update'} method="post" class="col-md-12 mx-auto text-center">


                <h3>${empty link ? 'Ajouter un raccourci' : 'Modifier un raccourci'}</h3>

                <br/>

                <c:if test="${link != null}">
                    <input type="hidden" name="id" value="<c:out value='${link.id}' />" />
                    <input type="hidden" name="visit" value="<c:out value='${link.visit}' />" />
                </c:if>  
                 
 
                <div class="form-group row">
                    <label for="url" class="col-sm-2 col-form-label">URL</label>
                    <div class="col-md-8">
                        <input type="text" name="url" placeholder="Entrez votre lien"  class="form-control" value="<c:out value='${link.url}' />" />
                    </div>
                </div>

                <div class="form-group row">
                    <label for="username" class="col-sm-2 col-form-label">Pseudo</label>
                    <div class="col-md-8">
                        <input type="text" name="username" placeholder="Entrez votre pseudo" class="form-control" value="<c:out value='${link.username}' />"/>

                        <br/>

                        <input type="submit" class="btn btn-primary" value="Enregistrer"/></div> 

                </div>

            </form>                 

    </body>
</html>
