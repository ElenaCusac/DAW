<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 19</title>
</head>
<body>
       
    <?php

        /*
        Crea una matriz para guardar a los amigos clasificados por 
        diferentes ciudades. Los valores serán los siguientes:

            En Madrid, nombre Pedro, edad 32, teléfono 91-999.99.99
            En Barcelona, nombre Susana, edad 34, teléfono 93-000.00.00
            En Toledo, nombre Sonia, edad 42, teléfono 925-09.09.09

        Haz un recorrido del array multidimensional mostrando los valores 
        de tal manera que nos muestre en cada ciudad qué amigos tiene.
            
        */

        $amigos["Madrid"]["Nombre"] = "Pedro";
        $amigos["Madrid"]["Edad"] = 32;
        $amigos["Madrid"]["Teléfono"] = "91-999.99.99";
        $amigos["Barcelona"]["Nombre"] = "Susana";
        $amigos["Barcelona"]["Edad"] = 34;
        $amigos["Barcelona"]["Teléfono"] = "93-000.00.00";
        $amigos["Toledo"]["Nombre"] = "Sonia";
        $amigos["Toledo"]["Edad"] = 42;
        $amigos["Toledo"]["Teléfono"] = "925-09.09.09";

        foreach ($amigos as $ciudad=>$datos) {
            echo "<h2>$ciudad</h2>";

            foreach ($datos as $valor => $info) {
                echo "<p>" .$valor. ": " .$info. "</p>" ;
            }

        }

    ?>

</body>
</html>