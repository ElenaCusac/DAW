<?php

    function todo_numeros($numero) {
        return is_numeric($numero);
    }

    function controlar_tamanio($numero) {
        $tamanio_correcto = true;

        if ($numero > 10 || $numero < 1 || $numero != (int)$numero) {
            $tamanio_correcto = false;
        }

        return $tamanio_correcto;
    }

    if (isset($_POST["btnConsultar"])) {
        $error_formulario = $_POST["numero"] == "" || !todo_numeros($_POST["numero"]) || !controlar_tamanio($_POST["numero"]);
    }

?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 2</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>

<body>
    <h1>Consultar tabla de multiplicar</h1>

    <form action="ejercicio2.php" method="post">
        <p>
            <label for="numero">Introduce un número del 1 al 10:</label>
            <input type="text" id="numero" name="numero" value="<?php if (isset($_POST["numero"])) {echo $_POST["numero"];} ?>">

            <?php
            if (isset($_POST["btnConsultar"]) && $error_formulario) {
                if ($_POST["numero"] == "") {
                    echo "<span class='error'>* Campo obligatorio.</span>";
                } elseif (!todo_numeros($_POST["numero"])) {
                    echo "<span class='error'>* No has introducido un número válido.</span>";
                } else {
                    echo "<span class='error'>* Introduce un entero del 1 al 10.</span>";
                }
            }
            ?>
        </p>

        <p>
            <button type="submit" name="btnConsultar">Consultar tabla</button>
        </p>

        <?php
        if (isset($_POST["btnConsultar"]) && !$error_formulario) {
            $nombre_archivo = "Tablas/tabla_" . $_POST["numero"] . ".txt";

            if (file_exists($nombre_archivo)) {
                $fichero = fopen($nombre_archivo, "r");

                if ($fichero !== false) {
                    echo "<h3>Tabla del " . $_POST["numero"] . "</h3>";

                    while (($linea = fgets($fichero)) !== false) {
                        echo "<p>" . $linea . "</p>";
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