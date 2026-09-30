<?php

const SERVIDOR_BD = "localhost";
const USUARIO_BD = "jose";
const CLAVE_BD = "josefa";
const NOMBRE_BD = "bd_cv";

<<<<<<< HEAD
try {
    @$conection=mysqli_connect(SERVIDOR_BD, USUARIO_BD, CLAVE_BD, NOMBRE_BD);
    mysqli_set_charset($conection, "utf8");

} catch (Exception $e) {
    die("<p>Error: No se ha podido conectar a la Base de datos: " .$e->getMessage(). "</p></body></html>");
}

try {
    $consulta = "select id_usuario, usuario, nombre, foto from usuarios";
    $resultado = mysqli_query($conection, $consulta);

} catch (Exception $e) {
    mysqli_close($conection);
    die("<p>Error: No se ha podido realizar la consulta: " .$e->getMessage(). "</p></body></html>");
}


=======
function error_page($title, $body) {
    return '<!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>'.$title.'</title>
            </head>

            <body>
                '.$body.'
            </body>

            </html>';
}

>>>>>>> cf119f7 (Renombrar carpeta de PHP para compatibilidad con Windows)
?>