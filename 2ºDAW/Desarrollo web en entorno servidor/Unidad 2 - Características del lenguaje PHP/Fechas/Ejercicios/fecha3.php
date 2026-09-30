<?php

$error_formulario = false;
$error_fecha1 = false;
$error_fecha2 = false;

if (isset($_POST["btnCalcular"])) {

    $fecha1 = $_POST["fecha1"];
    $fecha2 = $_POST["fecha2"];

    $fecha_arr1 = explode("-", $fecha1);
    $fecha_arr2 = explode("-", $fecha2);

    $error_fecha1 = !checkdate($fecha_arr1[1], $fecha_arr1[2], $fecha_arr1[0]);

    $error_fecha2 = !checkdate($fecha_arr2[1], $fecha_arr2[2], $fecha_arr2[0]);

    $error_formulario = $error_fecha1 || $error_fecha2;
}
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fechas 2</title>

    <style>
        .celeste {
            background-color: lightblue;
        }

        .verdoso {
            background-color: lightgreen;
        }

        .cuadrado {
            border: 2px solid black;
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

        <form action="fecha2.php" method="post">

            <h2 class="texto_centrado">Fechas - Formulario</h2>

            <p>
                <label for="fecha1">Introduzca una fecha:</label>
                <input type="date" name="fecha1" id="fecha1" value="<?php if(isset($_POST['fecha1'])){ echo $_POST['fecha1'];} ?>" required>
            </p>
            
            <p>
                <label for="fecha2">Introduzca otra fecha:</label>
                <input type="date" name="fecha2" id="fecha2" value="<?php if(isset($_POST['fecha2'])){ echo $_POST['fecha1'];} ?>" required>
            </p>
            
            <?php
                if (isset($_POST["btnCalcular"]) && $error_formulario) {
                    echo "<p class='error'>Fecha no válida</p>";
                }
            ?>

            <p>
                <button type="submit" name="btnCalcular" id="btnCalcular"> Calcular </button>
            </p>
        </form>

    </div>

    <?php

    if (isset($_POST["btnCalcular"]) && !$error_formulario) {

        $tiempo_segundos1 = strtotime($_POST["fecha1"]);
        $tiempo_segundos2 = strtotime($_POST["fecha2"]);

        $diferencia_segundos = abs($tiempo_segundos1 - $tiempo_segundos2);

        $dias_pasados = $diferencia_segundos / (60 * 60 * 24);

        echo "<div class='cuadrado verdoso'>";
        echo "<h2 class='texto_centrado'>Fechas - Respuesta</h2>";
        echo "<p>La diferencia en días entre las dos fechas es de: " . floor($dias_pasados) . "</p>";
        echo "</div>";
    }

    ?>

</body>

</html>