<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 5</title>

    <style>
        table {
            border-collapse: collapse;
            width: 90%;
            margin: 0 auto;
            text-align: center;
        }

        th, td {
            border: 1px solid black;
            padding: 6px;
        }

        .error {
            color: red;
        }
    </style>
</head>

<body>

    <?php

    $url = "http://dwese.icarosproject.com/PHP/datos_ficheros.txt";

    $contenido = @fopen($url, "r");

    if (!$contenido) {
        die("<p>No se ha podido abrir el fichero: <em>'http://dwese.icarosproject.com/PHP/datos_ficheros.txt'</em></p></body></html>");
    }

    echo "<table>";
    echo "<caption>PIB per cápita de la Unión Europea</caption>";

    // Leer la primera línea del fichero
    $linea = fgets($contenido);

    // Separar los datos utilizando el tabulador
    $datos_linea = explode("\t", trim($linea));

    // Obtener el número de columnas
    $n_columnas = count($datos_linea);

    // Mostrar la cabecera de la tabla
    echo "<tr>";

    for ($i = 0; $i < $n_columnas; $i++) {
        echo "<th>" . htmlspecialchars(trim($datos_linea[$i])) . "</th>";
    }

    echo "</tr>";

    // Leer y mostrar el resto de las líneas
    while ($linea = fgets($contenido)) {

        $datos_linea = explode("\t", trim($linea));

        echo "<tr>";

        // Primera columna como encabezado de fila
        echo "<th>" . htmlspecialchars(trim($datos_linea[0])) . "</th>";

        // Resto de las columnas como celdas normales
        for ($i = 1; $i < count($datos_linea); $i++) {
            echo "<td>" . htmlspecialchars(trim($datos_linea[$i])) . "</td>";
        }

        echo "</tr>";
    }

    echo "</table>";

    // Cerrar el fichero
    fclose($contenido);

    ?>

</body>

</html>
