<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teoría de fechas</title>
</head>

<body>
    <h1>Teoría de Fechas</h1>

    <?php
    $tiempo=time();
    echo "<p>" .$tiempo. "</p>";

    $fecha = date("d-m-Y", $tiempo);
    echo "<p> Fecha actual del sistema: " .$fecha. "</p>";

    $fecha = date("d-m-Y", $tiempo);
    echo "<p> Fecha actual del sistema: " .$fecha. "</p>";

    $fecha = date("d-m-y H:i:s");
    echo "<p> Fecha actual del sistema: " .$fecha. "</p>";


    // checkdate(mes, día, año) - Función booleana

    if (checkdate(1, 33, 1986)) {
        echo "<p>La fecha existe</p>";
    } else {
        echo "<p>La fecha no existe</p>";
    }


    $segundos_pasados = 1234567893;
    $fecha=date("d-m-y H:i:s", $segundos_pasados);
    echo "<p> Fecha inventada: " .$fecha. "</p>";


    // mktime(hora, minutos, segundos, mes, dia, año) 
    // Tiempo en segundos desde el 1 de enero de 1970 hasta la fecha que indiques
    $segundos_Ailin=mktime(9, 40, 15, 8, 21, 2004);
    echo "<p> Segundos desde el nacimiento: " .$segundos_Ailin. "</p>";

    $fecha = date("d-m-y H:i:s", $segundos_Ailin);
    echo "<p> Fecha de invitación Ailin: " .$fecha. "</p>";

    //strtotime('m/d/a') o strtotime('a/m/d');
    $segundos_Ailin = strtotime("08/21/2004 09:40:15");
    echo "<p>" .$segundos_Ailin. "</p>";


    // Funciones para hacer los ejercicios planteados de fechas
    echo "<p>" .abs(-8). "</p>";
    echo "<p>" .floor(9.89). "</p>";
    echo "<p>" .ceil(12.45). "</p>";


    ?>

    
</body>

</html>