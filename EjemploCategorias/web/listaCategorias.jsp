<%-- 
    Document   : listaCategorias
    Created on : 19-ene-2015, 15:57:15
    Author     : azu
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejercicio Categorias</title>
    </head>
    <body>
        <h1>Lista de categorias</h1>
        <%
	List<Category> categorias = (List<Category>) request.getAttribute("lasCategorias");
	for(Category cat: categorias) { %>
            <h1><% cat.getIdCategory(); %></h1>
            <h2><% cat.getDescription(); %></h2>
        <% } %>
    </body>
</html>
