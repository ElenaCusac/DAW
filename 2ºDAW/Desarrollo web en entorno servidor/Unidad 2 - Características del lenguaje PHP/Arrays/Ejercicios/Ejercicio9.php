<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 9</title>
</head>
<body>
      
    <?php

        /*
        Crea un array llamado "lenguaje_cliente" y otro "lenguaje_servidor",
        crea el mismo los valores, poniendo índices alfanuméricos a cada valor.
        Junta ambos arrays en uno llamado "lenguajes" y muéstralo por pantalla
        en una tabla.
        */

        $lenguaje_cliente["HTML"] = "HTML";
        $lenguaje_cliente["CSS"] = "CSS";
        $lenguaje_cliente["JS"] = "JavaScript";

        $lenguaje_servidor["PHP"] = "PHP";
        $lenguaje_servidor["JAVA"] = "Java";
        $lenguaje_servidor["PYTHON"] = "Python";

        $lenguajes = array_merge($lenguaje_cliente, $lenguaje_servidor);

        echo "<table border='1'>";
        echo "<tr>";
        echo "<th>Índice</th>";
        echo "<th>Lenguaje</th>";
        echo "</tr>";

        foreach ($lenguajes as $indice => $lenguaje) {
            echo "<tr>";
            echo "<td>" . $indice . "</td>";
            echo "<td>" . $lenguaje . "</td>";
            echo "</tr>";
        }

        echo "</table>";

    ?>
 
</body>
</html>