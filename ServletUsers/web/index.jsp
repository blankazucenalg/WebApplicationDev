<%-- 
    Document   : index
    Created on : 8/09/2014, 12:11:03 AM
    Author     : azu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Inicio de sesi&oacute;n</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/principal.css" title="Estilo principal"/>
    </head>
    <body>
        <div id="menubar">
            
        </div>
        <div id="title">
            <h1>Sistema de administración de usuarios</h1>
        </div>
        <div id="content">
            <h1>Inicio de sesi&oacute;n</h1>
            <form id="login" name="login" method="post" action="login">
                <label for="username">Nombre de usuario</label>
                <input type="text" name="username" maxlength="40"><br>
                <label for="password">Contrase&ntilde;a</label>
                <input type="password" name="password"><br>
                <input id="enviar" type="submit" class="button" value="Iniciar sesión"/>
            </form>            
        </div>
    </body>
</html>