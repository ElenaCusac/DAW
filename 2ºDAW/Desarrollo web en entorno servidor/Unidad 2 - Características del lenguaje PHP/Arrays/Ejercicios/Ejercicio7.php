<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 7</title>
</head>
<body>
      
    <?php

        /*
        Repite el ejercicio anterior, pero ahora sí se ha de crear índices.
        Ejemplo: 

            El índice del array que contiene como valor Madrid es MD.
        */

        $ciudades["MD"] =  "Madrid";
        $ciudades["BN"] =  "Barcelona";
        $ciudades["LN"] =  "Londres";
        $ciudades["NY"] =  "New York";
        $ciudades["LA"] =  "Los Ángeles";
        $ciudades["CH"] =  "Chicago";

        foreach ($ciudades as $siglas => $ciudad) {
            echo "<p>El índice del array que contiene como valor " .$ciudad. " es " .$siglas. "</p>";
        }

    ?>
 
</body>
</html>