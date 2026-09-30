<?php

const MESES = array[1 => "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
const ANIOS = 25;

if (isset($_POST["btnCalcular"])) {

    $error_fecha1 = !checkdate($_POST("mes1"), $_POST("dia1"), $_POST("anio1"));
    $error_fecha2 = !checkdate($_POST("mes2"), $_POST("dia2"), $_POST("anio2"));

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

        <form action="fecha2.php" method="post">

            <h2 class="texto_centrado">Fechas - Formulario</h2>

            <p>Introduzca una fecha: </p>
            <p>
                <label for="dia1">Día: </label>
                <select name="dia1" id="dia1">
                <?php

                for ($i=0; $i < 31; $i++) { 
                    echo "<option value='".sprintf("%02d", $i)."'>".$i. "</option>";
                }

                ?>
                </select>

                <label for="mes1">Mes: </label>
                <select name="mes1" id="mes1">
                <?php

                for ($i=1; $i <= count(MESES); $i++) { 
                    if(isset($_POST["mes1"]) && $_POST["mes1"]==$i) {
                        echo "<option selected value='".$i."'>".MESES[$i]. "</option>";
                    } else {
                        echo "<option value='".$i."'>".MESES[$i]. "</option>";
                    }
                    
                }

                ?>
                </select>

                <label for="anio1">Año: </label>
                <select name="anio1" id="anio1">
                <?php

                $anio_actual = date["Y"];
                for ($i=$anio_actual-floor(ANIOS/2); $i <= $anio_actual + floor(ANIOS/2) ; $i++) { 
                    if(isset($_POST["anio1"]) && $_POST["anio1"]==$i) {
                        echo "<option selected value='".$i."'>".$i. "</option>";
                    } else {
                        echo "<option value='".$i."'>".$i. "</option>";
                    }
                }

                ?>
                </select>

                <?php

                if(isset($_POST["btnCalcular"]) && $error_formulario) {
                    echo "<span class='error'>Fehca no válida</span>"
                }

                ?>
            </p>
            <br>

            <p>Introduzca otra fecha: </p>
            <p>
                <label for="dia2">Día: </label>
                <select name="dia2" id="dia2">
                <?php

                for ($i=0; $i < 31; $i++) { 
                    echo "<option value='".sprintf("%02d", $i)."'>".$i. "</option>";
                }

                ?>
                </select>

                <label for="mes2">Mes: </label>
                <select name="mes2" id="mes2">
                <?php

                for ($i=1; $i <= count(MESES); $i++) { 
                    if(isset($_POST["mes2"]) && $_POST["mes2"]==$i) {
                        echo "<option selected value='".$i."'>".MESES[$i]. "</option>";
                    } else {
                        echo "<option value='".$i."'>".MESES[$i]. "</option>";
                    }
                    
                }

                ?>
                </select>

                <label for="anio2">Año: </label>
                <select name="anio2" id="anio2">
                <?php

                $anio_actual = date["Y"];
                for ($i=$anio_actual-floor(ANIOS/2); $i <= $anio_actual + floor(ANIOS/2) ; $i++) { 
                    if(isset($_POST["anio2"]) && $_POST["anio2"]==$i) {
                        echo "<option selected value='".$i."'>".$i. "</option>";
                    } else {
                        echo "<option value='".$i."'>".$i. "</option>";
                    }
                }

                ?>
                </select>

                <?php

                if(isset($_POST["btnCalcular"]) && $error_formulario) {
                    echo "<span class='error'>Fehca no válida</span>"
                }

                ?>
            </p>

            <p>
                <button type="submit" name="btnCalcular" id="btnCalcular">Calcular</button>
            </p>

        </form>

    </div>

    <?php

    if (isset($_POST["btnCalcular"]) && !$error_formulario) {

        $fecha_arr1 = explode("/", $_POST["fecha1"]);
        $fecha_arr2 = explode("/", $_POST["fecha2"]);

        $tiempo_segundos1 = mktime($_POST["anio1"], $_POST["mes1"], $_POST["dia1"]);
        $tiempo_segundos2 = mktime($_POST["anio2"], $_POST["mes2"], $_POST["dia2"]);
        

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