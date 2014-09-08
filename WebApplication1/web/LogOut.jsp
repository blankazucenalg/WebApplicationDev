<%-- 
    Document   : LogOut
    Created on : 8/09/2014, 12:11:32 AM
    Author     : azu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inicio de Sesión</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/principal.css" title="Estilo principal"/>
    </head>
    <body>
        <div id="menubar">
            <ul>
                <li><a href="Search.jsp">Búsqueda de usuarios</a></li>
                <li><a href="SignUp.jsp">Registrar nuevo usuario</a></li>
                <li><a href="LogOut.jsp">Cerrar sesión</a></li>
            </ul>
        </div>
        <div id="content">
            <h1>Inicio de sesi&oacute;n</h1>
            <form id="login" name="login" method="post" >
                <label for="username">Nombre de usuario</label>
                <input type="text" name="username" maxlength="40" required="required"><br>
                <label for="password">Contrase&ntilde;a</label>
                <input type="password" name="password" required="required"><br>
                <a href="Search.jsp"><button type="submit" class="button" name="send" value="Acceder">Acceder</button></a> <br>
            </form>
        </div>
    </body>
</html>
