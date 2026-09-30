<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 11</title>
</head>
<body>
      
    <?php

        /*
        Rellena tres arrays y júntalos en uno nuevo.
        Muéstralos por pantalla.
        Utiliza la función array_merge().
        */

        $animales = array("Lagartija", "Araña", "Perro", "Gato", "Ratón");

        $numeros = array("12", "34", "45", "52", "12");

        $comida = array("Sauce", "Pino", "Naranjo", "Chopo", "Perro", "34");

        $nuevo_array = array_merge($animales, $numeros, $comida);

        echo "<h3>Array resultante:</h3>";

        foreach ($nuevo_array as $valor) {
            echo $valor . "<br>";
        }

    ?>
 
</body>
</html>