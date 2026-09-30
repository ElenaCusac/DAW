<?php

const SERVIDOR_BD = "localhost";
const USUARIO_BD = "jose";
const CLAVE_BD = "josefa";
const NOMBRE_BD = "bd_teoria";

function error_page($title, $body) {
    return '<!DOCTYPE html>
    <html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>' . $title . '</title>
    </head>
    <body>
        ' . $body . '
    </body>
    </html>';
}

// Intentar hacer la conexión
try {
    $conexion = mysqli_connect(SERVIDOR_BD, USUARIO_BD, CLAVE_BD, NOMBRE_BD);

    mysqli_set_charset($conexion, "utf8mb4");

} catch (mysqli_sql_exception $e) {
    die(error_page(
        "Práctica 1 - BD",
        "<h1>Práctica 1 - BD</h1>
        <p>Error: No se ha podido conectar a la base de datos.</p>"
    ));
}

// Consultar las asignaturas
try {
    $consulta = "SELECT cod_asig, denominacion FROM asignaturas";
    $resultado_asignaturas = mysqli_query($conexion, $consulta);

} catch (mysqli_sql_exception $e) {
    mysqli_close($conexion);
    die(error_page("Práctica 1 - BD", "<p>Error: No se ha podido realizar la consulta de asignaturas.</p>"));
}

// Inicializar variables
$resultado_alumno_nota = null;
$nombre_asignatura = "";

// Comprobar si se ha seleccionado una asignatura
if (isset($_POST["asignatura"])) {

    $cod_asig = filter_input(INPUT_POST, "asignatura", FILTER_VALIDATE_INT);

    if ($cod_asig !== false && $cod_asig !== null && $cod_asig > 0) {

        try {
            // Consultar el nombre de la asignatura seleccionada
            $consulta = "SELECT denominacion FROM asignaturas WHERE cod_asig = " . $cod_asig;

            $resultado_nombre = mysqli_query($conexion, $consulta);

            $fila_asignatura = mysqli_fetch_assoc($resultado_nombre);

            if ($fila_asignatura) {
                $nombre_asignatura = $fila_asignatura["denominacion"];
            }

            mysqli_free_result($resultado_nombre);

            // Consultar los alumnos y sus notas
            $consulta = "SELECT alumnos.nombre, notas.nota FROM alumnos INNER JOIN notas ON alumnos.cod_alu = notas.cod_alu WHERE notas.cod_asig = " . $cod_asig;

            $resultado_alumno_nota = mysqli_query($conexion, $consulta);

        } catch (mysqli_sql_exception $e) {
            mysqli_free_result($resultado_asignaturas);
            mysqli_close($conexion);

            die(error_page("Práctica 1 - BD", "<p>Error: No se ha podido realizar la consulta.</p>"));
        }
    }
}

?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Práctica 1 - BD</title>

    <style>
        table, td, th {
            border: 1px solid black;
        }

        table {
            border-collapse: collapse;
            text-align: center;
        }

        td, th {
            padding: 5px 10px;
        }
    </style>
</head>

<body>

    <h1>Práctica 1 BD</h1>

    <?php
    // Comprobar si existen asignaturas
    if (mysqli_num_rows($resultado_asignaturas) > 0) {
    ?>

        <form action="practica1.php" method="post">

            <label for="asignatura">Elija una asignatura:</label>

            <select id="asignatura" name="asignatura">

                <?php
                while ($tupla = mysqli_fetch_assoc($resultado_asignaturas)) {

                    $seleccionada = (isset($cod_asig) && $cod_asig == $tupla["cod_asig"]);

                    echo "<option value='" .$tupla["cod_asig"]. "'" . ($seleccionada ? " selected" : "") .">" . $tupla["denominacion"] . "</option>";
                }
                ?>

            </select>

            <button type="submit" id="verNotas">Ver notas</button>

        </form>

    <?php
    } else {
        echo "<p>Aún no existen asignaturas registradas en la BD.</p>";
    }

    // Mostrar las notas de los alumnos
    if ($resultado_alumno_nota !== null && $nombre_asignatura !== "") {

        echo "<h2>Notas de los alumnos en: " . $nombre_asignatura . "</h2>";

        if (mysqli_num_rows($resultado_alumno_nota) > 0) {

            echo "<table>";

            echo "<tr>
                    <th>Nombre</th>
                    <th>Nota</th>
                  </tr>";

            while ($tupla = mysqli_fetch_assoc($resultado_alumno_nota)) {

                echo "<tr>";

                echo "<td>" .$tupla["nombre"]. "</td>";
                echo "<td>" . $tupla["nota"] . "</td>";

                echo "</tr>";
            }

            echo "</table>";

        } else {
            echo "<p>No hay notas registradas para esta asignatura.</p>";
        }

        mysqli_free_result($resultado_alumno_nota);
    }

    // Liberar recursos y cerrar la conexión
    mysqli_free_result($resultado_asignaturas);
    mysqli_close($conexion);
    ?>

</body>
</html>


