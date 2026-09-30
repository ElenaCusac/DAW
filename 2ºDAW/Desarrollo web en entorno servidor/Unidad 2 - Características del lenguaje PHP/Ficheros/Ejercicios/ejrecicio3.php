<?php

function todo_numeros($numero) {
    return is_numeric($numero);
}

function controlar_tamanio($numero) {
    $tamanio_correcto = true;

    if ($numero > 10 || $numero < 1) {
        $tamanio_correcto = false;
    }

    return $tamanio_correcto;
}

if (isset($_POST["btnConsultar"])) {
    $error_n = $_POST["n"] == "" || !todo_numeros($_POST["n"]) || !controlar_tamanio($_POST["n"]);

    $error_m = $_POST["m"] == "" || !todo_numeros($_POST["m"]) || !controlar_tamanio($_POST["m"]);
}

?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 3</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>

<body>
    <h1>Consultar una línea de la tabla</h1>

    <form action="ejercicio3.php" method="post">
        <p>
            <label for="n">Número de la tabla (1-10):</label>
            <input type="text" id="n" name="n" value="<?php if (isset($_POST["n"])) { echo $_POST["n"];} ?>">

            <?php
            if (isset($_POST["btnConsultar"]) && $error_n) {
                echo "<span class='error'>* El número de la tabla debe ser un entero del 1 al 10.</span>";
            }
            ?>
        </p>

        <p>
            <label for="m">Número de línea (1-10):</label>
            <input type="text" id="m" name="m" value="<?php if (isset($_POST["m"])) { echo $_POST["m"]; } ?>">

            <?php
            if (isset($_POST["btnConsultar"]) && $error_m) {  echo "<span class='error'>* La línea debe ser un entero del 1 al 10.</span>";}
            ?>
        </p>

        <p>
            <button type="submit" name="btnConsultar">Consultar línea</button>
        </p>

        <?php
        if (isset($_POST["btnConsultar"]) && !$error_n && !$error_m) {
            $nombre_archivo = "Tablas/tabla_" . $_POST["n"] . ".txt";

            if (file_exists($nombre_archivo)) {
                $fichero = fopen($nombre_archivo, "r");

                if ($fichero !== false) {
                    $contador = 1;

                    while (($linea = fgets($fichero)) !== false) {
                        if ($contador == $_POST["m"]) {
                            echo "<p>" . $linea . "</p>";
                            break;
                        }

                        $contador++;
                    }

                    fclose($fichero);
                } else {
                    echo "<p class='error'>No se pudo abrir el fichero.</p>";
                }
            } else {
                echo "<p class='error'>El fichero " . $nombre_archivo . " no existe.</p>";
            }
        }
        ?>
    </form>
</body>

</html>
