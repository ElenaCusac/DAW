<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 13</title>
</head>
<body>
      
    <?php

        /*
        Muestra la array del ejercicio anterior pero en orden inverso.
        */

        $animales = array("Lagartija", "Araña", "Perro", "Gato", "Ratón");

        $numeros = array("12", "34", "45", "52", "12");

        $comida = array("Sauce", "Pino", "Naranjo", "Chopo", "Perro", "34");

        $nuevo_array = array();

        array_push($nuevo_array, ...$animales);
        array_push($nuevo_array, ...$numeros);
        array_push($nuevo_array, ...$comida);

        $nuevo_array = array_reverse($nuevo_array);

        echo "<h3>Array en orden inverso:</h3>";

        foreach ($nuevo_array as $valor) {
            echo $valor . "<br>";
        }

    ?>
 
</body>
</html>