<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="https://pbs.twimg.com/profile_images/1423089146/escom_normal.png">

        <title>Sistema de transacciones</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/navbar-static-top.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <script src="js/ie-emulation-modes-warning.js"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>

        <!-- Static navbar -->
        <nav class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">TransaBank</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#about">Acerca de nosotros</a></li>
                        <li><a href="#contact">Contacto</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Idioma <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">English</a></li>
                                <li><a href="#">Español</a></li>
                                <!-- <li class="divider"></li>
                                <li class="dropdown-header">Nav header</li>
                                <li><a href="#">Separated link</a></li>
                                <li><a href="#">One more separated link</a></li> -->
                            </ul>
                        </li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>


        <div class="container">
            <h1 class="col-lg-offset-1">Sistema de transacciones</h1>
            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron col-lg-6 col-lg-offset-1">
                <p>Realiza operaciones básicas de transacciones bancarias de una manera fácil</p>
                <p>Si aún no tienes una cuenta, ¡no lo dudes más! Disfruta de los beneficios que la
                banca en línea tiene para ti con solo un par de clics.  </p>
                <p>
                    <a class="btn btn-lg col-lg-5 btn-primary" href="Register.jsp" role="button">Registrate ahora</a>
                </p>
            </div>
            <div class="col-lg-4">
                <h2>Para continuar, inicia sesión</h2>
                <form action="Login.jsp" method="post" enctype="UTF-8">
                    <input name="email" type="email" class="form-control" placeholder="Correo electronico" aria-describedby="basic-addon1">
                    <input type="password" name="password" class="form-control" placeholder="Contraseña" aria-describedby="basic-addon1">
                    <input type="submit" class="btn col-lg-12 btn-success" value="Iniciar sesión">
                </form>
                <br><br>
                <a href="ForgottenPass.jsp"><p class="text-center">¿Olvidaste tu contraseña?</p></a>
            </div>

        </div> <!-- /container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="js/ie10-viewport-bug-workaround.js"></script>


    </body>
</html>
