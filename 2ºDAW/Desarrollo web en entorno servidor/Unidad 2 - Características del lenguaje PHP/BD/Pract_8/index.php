<?php

require "src/funciones_cte.php";

<<<<<<< HEAD
?>

<!DOCTYPE html>
<html lang="en">
=======
$resultado = false;
$resultado_detalles = null;

try {
    $conexion = mysqli_connect(SERVIDOR_BD, USUARIO_BD, CLAVE_BD, NOMBRE_BD);
    mysqli_set_charset($conexion, "utf8mb4");
} catch (mysqli_sql_exception $e) {
    die("<p>Error: No se ha podido conectar a la base de datos: " . $e->getMessage() . "</p></body></html>");
}

$resultado = false;

if (isset($_POST["btnDetalles"])) {
    try {
        $consulta_detalles = "select * from usuarios where id_usuario='" . $_POST["btnDetalles"] . "'";
        $resultado_detalles = mysqli_query($conexion, $consulta_detalles);
    } catch (Exception $e) {
        mysqli_close($conexion);
        die(error_page("Práctica 8", "<h1>Práctica 8</h1><p>Error: No se ha podido realizar la consulta: " . $e->getMessage() . "</p>"));
    }
}

try {
    $consulta = "select * from usuarios";

    $resultado = mysqli_query($conexion, $consulta);
} catch (mysqli_sql_exception $e) {
    mysqli_close($conexion);

    die(error_page("Práctica 8", "<h1>Práctica 8</h1><p>Error: No se ha podido obtener el listado de usuarios: " . $e->getMessage() . "</p>"));
}

?>

<!DOCTYPE html>
<html lang="es">
>>>>>>> cf119f7 (Renombrar carpeta de PHP para compatibilidad con Windows)

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<<<<<<< HEAD
    <title>Práctica 8</title>
    <style>
        table, td, th {
=======

    <title>Práctica 8</title>

    <style>
        table,
        td,
        th {
>>>>>>> cf119f7 (Renombrar carpeta de PHP para compatibilidad con Windows)
            border: 1px solid black;
        }

        table {
            border-collapse: collapse;
            text-align: center;
<<<<<<< HEAD
        }

        td, th {
            padding: 5px 10px;
        }
    </style>
</head>

<body>
    <h1>Práctica 8</h1>

=======
            width: 90%;
            margin: 0 auto;
        }

        td,
        th {
            padding: 5px 10px;
        }

        img {
            height: 100px;
        }

        .enlace {
            border: none;
            background: none;
            color: blue;
            text-decoration: underline;
            cursor: pointer;
        }
    </style>

</head>

<body>

    <h1>Práctica 8</h1>

    <?php
    if (isset($_POST["btnDetalles"])) {
        echo "<h2>Detalles del usuario con id: " . $_POST["btnDetalles"] . "</h2>";

        if ($resultado_detalles && $tupla = mysqli_fetch_assoc($resultado_detalles)) {

            echo "<p><strong>Nombre: </strong>" . $tupla["nombre"] . "</p>";
            echo "<p><strong>Usuario: </strong>" . $tupla["usuario"] . "</p>";
            echo "<p><strong>Clave: </strong> *********</p>";
            echo "<p><strong>DNI: </strong>" . $tupla["dni"] . "</p>";
            echo "<p><strong>Sexo: </strong>"  . $tupla["sexo"] . "</p>";
            echo "<p><img src='Img/"  . $tupla["foto"] . "' alt='Foto de perfil' title='Foto de perfil'></p>";

            mysqli_free_result($resultado_detalles);
        } else {
            echo "<p>El usuario no se encuentra en la base de datos.</p>";
        }

        echo "<form action='index.php' method='post'><button type='submit'>Atrás</button></form>";
    }
    ?>

>>>>>>> cf119f7 (Renombrar carpeta de PHP para compatibilidad con Windows)
    <h3>Listado de usuarios</h3>

    <table>
        <tr>
            <th>#</th>
            <th>Foto</th>
            <th>Nombre</th>
            <th>Usuario</th>
        </tr>
<<<<<<< HEAD
        <?php 
        while ($tupla = mysqli_fetch_assoc($resultado)) {
            
        }
        ?>
    </table>
=======

        <?php

        while ($tupla = mysqli_fetch_assoc($resultado)) {

            echo "<tr>";

            echo "<td>" . htmlspecialchars($tupla["id_usuario"]) . "</td>";

            echo "<td><img src='Img/" . $tupla["foto"] . "' alt='Foto de perfil' title='Foto de perfil'></td>";

            echo "<td><form action='index.php' method='post'><button class='enlace' type='submit' name='btnDetalles' value='" . $tupla["id_usuario"] . "'>" . $tupla["nombre"] . "</button></form></td>";

            echo "<td>Borrar - Editar</td>";

            echo "</tr>";
        }

        mysqli_free_result($resultado);

        mysqli_close($conexion);

        ?>

    </table>

>>>>>>> cf119f7 (Renombrar carpeta de PHP para compatibilidad con Windows)
</body>

</html>