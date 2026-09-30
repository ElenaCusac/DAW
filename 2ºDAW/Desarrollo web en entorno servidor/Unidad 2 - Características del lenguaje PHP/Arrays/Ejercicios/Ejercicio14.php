<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 14</title>
</head>
<body>
      
    <?php

        /*
        Implementa un array asociativo con los siguientes valores.
        Muestra los valores del array en una tabla, mostrando el índice y
        el valor asociado.
        Elimina el estado asociado al Real Madrid.
        Vuelve a mostrar los valores para comprobar que el valor ha sido
        eliminado, esta vez en una lista numerada.
        */

        $estadios_futbol = array(
            "Barcelona" => "Camp Nou",
            "Real Madrid" => "Santiago Bernabéu",
            "Valencia" => "Mestalla",
            "Real Sociedad" => "Anoeta"
        );

        echo "<h3>Estadios de fútbol:</h3>";

        echo "<table border='1'>";
        echo "<tr>";
        echo "<th>Equipo</th>";
        echo "<th>Estadio</th>";
        echo "</tr>";

        foreach ($estadios_futbol as $equipo => $estadio) {
            echo "<tr>";
            echo "<td>" . $equipo . "</td>";
            echo "<td>" . $estadio . "</td>";
            echo "</tr>";
        }

        echo "</table>";

        unset($estadios_futbol["Real Madrid"]);

        echo "<h3>Después de eliminar Real Madrid:</h3>";

        echo "<ol>";

        foreach ($estadios_futbol as $equipo => $estadio) {
            echo "<li>" . $equipo . " - " . $estadio . "</li>";
        }

        echo "</ol>";

    ?>
 
</body>
</html>