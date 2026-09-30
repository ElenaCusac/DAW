<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teoría BD</title>
</head>

<body>
    <h1>Teoría Bases de datos</h1>
    <?php

    const SERVIDOR_BD="localhost";
    const USUARIO_BD = "jose";
    const CLAVE_BD = "josefa";
    const NOMBRE_BD = "bd_teoria";

    try {
        @$conection=mysqli_connect(SERVIDOR_BD, USUARIO_BD, CLAVE_BD, NOMBRE_BD);
        mysqli_set_charset($conection, "utf8");

    } catch (Exception $e) {
        die("<p>Error: No se ha podido conectar a la Base de datos: " .$e->getMessage(). "</p></body></html>");
    }


    echo "<h2>Conexión realizada con éxito<h2>";

    try {
        $consulta = "select * from alumnos";
        $resultado = mysqli_query($conection, $consulta);

    } catch (Exception $e) {
        mysqli_close($conection);
        die("<p>Error: No se ha podido realizar la consulta: " .$e->getMessage(). "</p></body></html>");
    }


    echo "<h2>La consulta: '" .$consulta. "' se ha realizado con éxito</h2>";
    
    $n_tuplas = mysqli_num_rows($resultado);
    echo "<p>El número de tuplas obtenidas en la consulta ha sido: " . $n_tuplas;

    $tupla = mysqli_fetch_assoc($resultado);

    echo "<h3>Leída la primera tupla. Estos son sus datos: </h3>";
    echo "<p><strong>cod_alu: </strong>" .$tupla["cod_alu"]. "</p>";
    echo "<p><strong>Nombre: </strong>" .$tupla["nombre"] ."</p>";
    echo "<p><strong>Teléfono: </strong>" .$tupla["telefono"]. "</p>";
    echo "<p><strong>Código postal: </strong>" .$tupla["cp"]. "</p>";

    $tupla = mysqli_fetch_object($resultado);

    echo "<h3>Leída la segunda tupla. Estos son sus datos: </h3>";
    echo "<p><strong>cod_alu: </strong>" .$tupla->cod_alu. "</p>";
    echo "<p><strong>Nombre: </strong>" .$tupla->nombre. "</p>";
    echo "<p><strong>Teléfono: </strong>" .$tupla->telefono. "</p>";
    echo "<p><strong>Código postal: </strong>" .$tupla->cp. "</p>";

    $tupla = mysqli_fetch_row($resultado);

    echo "<h3>Leída la tercera tubla tupla. Estos son sus datos: </h3>";
    echo "<p><strong>cod_alu: </strong>" .$tupla[0]. "</p>";
    echo "<p><strong>Nombre: </strong>" .$tupla[1] ."</p>";
    echo "<p><strong>Teléfono: </strong>" .$tupla[2]. "</p>";
    echo "<p><strong>Código postal: </strong>" .$tupla[3]. "</p>";

    mysqli_data_seek($resultado, 0);

    echo "<h3>Información de los alumnos en una tabla</h3>";
    echo "<table border='1'>";

    echo "<tr><th>Cod Alu</th><th>Nombre</th><th>Teléfono</th><th>Código Postal</th></tr>";

    while ($tupla = mysqli_fetch_assoc($resultado)) {
        echo "<tr>";

        echo "<td>" .$tupla["cod_alu"]. "</td>";
        echo "<td>" .$tupla["nombre"]. "</td>";
        echo "<td>" .$tupla["telefono"]. "</td>";
        echo "<td>" .$tupla["cp"]. "</td>";

        echo "</tr>";
    }

    echo "</table>";

    mysqli_free_result($resultado);

    mysqli_close($conection);

    ?>
</body>

</html>