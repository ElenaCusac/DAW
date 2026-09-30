<?php
function buenos_separadores($fecha) {
    return substr($fecha, 2, 1) == "/" && substr($fecha, 5, 1) == "/";
}

function buenos_numeros($fecha) {
    return is_numeric(substr($fecha, 0, 2)) && is_numeric(substr($fecha, 3, 2)) && is_numeric(substr($fecha, 6, 4));
}

function fecha_valida($fecha) {
    return checkdate((int) substr($fecha, 3, 2), (int) substr($fecha, 0, 2), (int) substr($fecha, 6, 4));
}

if (isset($_POST["btnCalcular"])) {
    $fecha1 = $_POST["fecha1"];
    $fecha2 = $_POST["fecha2"];

    $error_fecha1 = $fecha1 == "" || strlen($fecha1) != 10 ||!buenos_separadores($fecha1) || !buenos_numeros($fecha1) || !fecha_valida($fecha1);
    $error_fecha2 = $fecha2 == "" || strlen($fecha2) != 10 || !buenos_separadores($fecha2) || !buenos_numeros($fecha2) || !fecha_valida($fecha2);

    $error_formulario = $error_fecha1 || $error_fecha2;
}
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fechas</title>

    <style>
        .celeste {
            background-color: lightblue;
        }

        .verdoso {
            background-color: lightgreen;
        }

        .cuadrado {
            border: 3px solid black;
            padding: 0.5em;
            margin-top: 1em;
        }

        .error {
            color: red;
        }

        .texto_centrado {
            text-align: center;
        }
    </style>
</head>

<body>

    <div class="cuadrado celeste">

        <form action="fecha1.php" method="post">

            <h2 class="texto_centrado">Fechas - Formulario</h2>

            <p>
                <label for="fecha1">Introduce una fecha (DD/MM/YYYY):</label>

                <input type="text" name="fecha1" id="fecha1" value="<?php echo htmlspecialchars($_POST["fecha1"] ?? ""); ?>">

                <?php
                if (isset($_POST["btnCalcular"]) && $error_fecha1) {
                    if ($_POST["fecha1"] == "") {
                        echo "<span class='error'> Campo obligatorio.</span>";
                    } else {
                        echo "<span class='error'> No has introducido el formato correcto de fecha.</span>";
                    }
                }
                ?>
            </p>

            <p>
                <label for="fecha2">Introduce una fecha (DD/MM/YYYY): </label>

                <input type="text" name="fecha2" id="fecha2" value="<?php echo htmlspecialchars($_POST["fecha2"] ?? ""); ?>">

                <?php
                if (isset($_POST["btnCalcular"]) && $error_fecha2) {
                    if ($_POST["fecha2"] == "") {
                        echo "<span class='error'> Campo obligatorio.</span>";
                    } else {
                        echo "<span class='error'> No has introducido el formato correcto de fecha.</span>";
                    }
                }
                ?>
            </p>

            <p>
                <button type="submit" name="btnCalcular" id="btnCalcular">
                    Calcular
                </button>
            </p>

        </form>

    </div>

    <?php

    if (isset($_POST["btnCalcular"]) && !$error_formulario) {

        $fecha_arr1 = explode("/", $_POST["fecha1"]);
        $fecha_arr2 = explode("/", $_POST["fecha2"]);

        $tiempo_segundos1 = mktime(0, 0, 0, $fecha_arr1[1], $fecha_arr1[0], $fecha_arr1[2]);
        $tiempo_segundos2 = mktime(0, 0, 0, $fecha_arr2[1], $fecha_arr2[0], $fecha_arr2[2]);

        $diferencia_segundos = abs($tiempo_segundos1 - $tiempo_segundos2);

        $dias_pasados = $diferencia_segundos / (60 * 60 * 24);

        echo "<div class='cuadrado verdoso'>";
        echo "<h2 class='texto_centrado'>Fechas - Respuestas</h2>";
        echo "<p>La diferencia en días entre las dos fechas introducidas es de: " . floor($dias_pasados) . "</p>";
        echo "</div>";
    }

    ?>

</body>

</html>