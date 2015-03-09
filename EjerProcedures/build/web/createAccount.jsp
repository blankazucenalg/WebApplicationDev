<%-- 
    Document   : createAccount
    Created on : 09-ene-2015, 17:12:27
    Author     : azu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="styles.css">
        <title>Cuentas de usuario</title>
    </head>
    <body>
        <div id="content">
            <h1>Sistema de transacciones</h1>
            <form id="create" action="" method="post">
                <input type="number" name="balance" placeholder="Cantidad">   
                <input type="submit" name="crearCuenta" class="btn-success" value="Crear cuenta">
            </form>
        </div>
    </body>
</html>
