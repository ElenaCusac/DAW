<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 10</title>
</head>
<body>
      
    <?php

        /*
        Rellena un array de 10 enteros, con los 10 primeros números naturales.
        Calcula la media de los que están en posiciones pares y muestra los
        impares por pantalla.
        */

        $numeros = array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        $suma = 0;
        $cantidad = 0;

        echo "<h3>Números impares:</h3>";

        foreach ($numeros as $indice => $numero) {

            if ($indice % 2 == 0) {
                $suma = $suma + $numero;
                $cantidad++;
            }

            if ($numero % 2 != 0) {
                echo $numero . "<br>";
            }
        }

        $media = $suma / $cantidad;

        echo "<p>La media de los números que están en posiciones pares es: " . $media . "</p>";

    ?>
 
</body>
</html>