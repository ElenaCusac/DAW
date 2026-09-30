<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 15</title>
</head>
<body>
      
    <?php

        /*
        Implementa un array asociativo con los siguientes valores y ordénalo
        de menor a mayor.
        Muestra los valores en una tabla.
        */

        $numeros = array(
            3 => 2,
            8 => 1,
            23 => 5
        );

        asort($numeros);

        echo "<table border='1'>";
        echo "<tr>";
        echo "<th>Índice</th>";
        echo "<th>Valor</th>";
        echo "</tr>";

        foreach ($numeros as $indice => $valor) {
            echo "<tr>";
            echo "<td>" . $indice . "</td>";
            echo "<td>" . $valor . "</td>";
            echo "</tr>";
        }

        echo "</table>";

    ?>
 
</body>
</html>