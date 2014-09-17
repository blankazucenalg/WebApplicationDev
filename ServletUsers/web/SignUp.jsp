<%-- 
    Document   : SignUp
    Created on : 8/09/2014, 12:03:35 AM
    Author     : azu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registrar nuevo usuario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/principal.css" title="Estilo principal"/>
    </head>
    <body>
        <div id="menubar">
            <ul>
                <li><a href="ManageUsers">Búsqueda de usuarios</a></li>
                <li><a href="SignUp.jsp">Registrar nuevo usuario</a></li>
                <li><a href="index.jsp">Cerrar sesión</a></li>
            </ul>
        </div>
        <div id="content">
            <h1>Registro de usuario</h1>
            <form id="signup" name="signup" class="formulario" method="post" action="Register" accept-charset="ISO-8859-1 UTF-8">
                <label for="name">Nombre(s)</label>
                <input type="text" name="name" required="required"><br>
                <label for="lastname">Apellido paterno</label>
                <input type="text" name="lastname" required="required"><br>
                <label for="surname">Apellido materno</label>
                <input type="text" name="surname" required="required"><br>
                <label for="email">Correo electr&oacute;nico</label>
                <input type="email" name="email" required="required"><br>
                <label for="username">Nombre de usuario</label>
                <input type="text" name="username" maxlength="40" required="required"><br>
                <label for="password">Contrase&ntilde;a</label>
                <input type="password" name="password" required="required"><br>
                <label for="userType">Tipo de usuario</label>
                <select name="userType" required="required">
                    <option value="1">Administrador</option>
                    <option value="2" selected="selected">Est&aacute;ndar</option>
                </select><br><br>
                <input type="submit" class="button" name="send" value="Registrar"><br>
            </form>
        </div>
    </body>
</html>

