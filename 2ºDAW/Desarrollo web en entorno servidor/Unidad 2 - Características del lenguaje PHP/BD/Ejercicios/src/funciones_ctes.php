<?php
const SERVIDOR_BD = "localhost";
const USUARIO_BD = "jose";
const CLAVE_BD = "josefa";
const NOMBRE_BD = "bd_teoria";

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

            </html>'
}

// Intentar hacer la conexión
try {
    $conexion = mysqli_connect(SERVIDOR_BD, USUARIO_BD, CLAVE_BD, NOMBRE_BD);
    mysqli_set_charset($conexion, "utf8mb4");

} catch (mysqli_sql_exception $e) {
    die (error_page("Práctica 1 - BD", "<h1>Práctica 1 - BD</h1><p>Error: No se ha podido conectar a la base de datos:" .$e->getMessage(). "</p>"))
    die("<p>");
}

// Intentar hacer una consulta a la tabla asignaturas
try {
    $consulta = "SELECT denominacion FROM asignaturas";
    $resultado = mysqli_query($conexion, $consulta);

} catch (mysqli_sql_exception $e) {
    mysqli_close($conexion);
    die("<p>Error: No se ha podido realizar la consulta.</p></body></html>");
}

mysqli_close($conexion);

?>