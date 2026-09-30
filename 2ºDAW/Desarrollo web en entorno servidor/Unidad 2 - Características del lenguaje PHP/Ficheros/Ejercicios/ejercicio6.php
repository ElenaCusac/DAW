<?php

$url = "http://dwese.icarosproject.com/PHP/datos_ficheros.txt";

$contenido = @file_get_contents($url);

$error_pais = false;

if (isset($_POST["btnConsultar"])) {
    $error_pais = !isset($_POST["pais"]) || $_POST["pais"] == "";
}

?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 6</title>

    <style>
        table {
            border-collapse: collapse;
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

    <h1>Consultar PIB per cápita por país</h1>

    <?php

    if ($contenido === false) {
        die("<p>No se ha podido leer el fichero remoto.</p></body></html>");
    } else {

        $lineas = explode("\n", $contenido);
        $datos_paises = array();

        foreach ($lineas as $linea) {
            $linea = trim($linea);

            if ($linea != "") {
                $datos_paises[] = explode("\t", $linea);
            }
        }

        if (count($datos_paises) > 1) {

    ?>

    <form action="ejercicio6.php" method="post">

        <p>
            <label for="pais">Selecciona un país:</label>

            <select name="pais" id="pais">

                <option value="">-- Selecciona un país --</option>

                <?php

                for ($i = 1; $i < count($datos_paises); $i++) {

                    $pais = trim($datos_paises[$i][0]);

                    echo "<option value='" . $pais . "'";

                    if (isset($_POST["pais"]) && $_POST["pais"] == $pais) {
                        echo " selected";
                    }

                    echo ">" . $pais . "</option>";
                }

                ?>

            </select>
        </p>

        <p>
            <button type="submit" name="btnConsultar">Consultar PIB</button>
        </p>

    </form>

    <?php

            if (isset($_POST["btnConsultar"])) {

                if ($error_pais) {

                    echo "<p class='error'>* Selecciona un país.</p>";

                } else {

                    $pais_encontrado = false;

                    for ($i = 1; $i < count($datos_paises); $i++) {

                        if (trim($datos_paises[$i][0]) == $_POST["pais"]) {

                            $pais_encontrado = true;

                            echo "<h2>PIB per cápita: " . $_POST["pais"] . "</h2>";

                            echo "<table><tr>";

                            for ($j = 1; $j < count($datos_paises[0]); $j++) {
                                echo "<th>" . trim($datos_paises[0][$j]) . "</th>";
                            }

                            echo "</tr><tr>";

                            for ($j = 1; $j < count($datos_paises[$i]); $j++) {
                                echo "<td>" . trim($datos_paises[$i][$j]) . "</td>";
                            }

                            echo "</tr></table>";

                            break;
                        }
                    }

                    if (!$pais_encontrado) {
                        echo "<p class='error'>El país seleccionado no es válido.</p>";
                    }
                }
            }

        } else {

            echo "<p class='error'>El fichero no contiene datos suficientes.</p>";

        }
    }

    ?>

</body>

</html>