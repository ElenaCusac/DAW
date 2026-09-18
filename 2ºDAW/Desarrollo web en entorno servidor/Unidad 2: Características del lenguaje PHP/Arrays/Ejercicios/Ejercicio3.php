<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 3</title>
</head>
<body>
    
    <?php

        /*
        Realizar un programa que muestre las películas que se han visto.
        Crear un array que contenga los meses de enero, febrero, marzo y 
        abril, asignando los valores 9, 12, 0 y 17 respectivamente.
        Si en alguno de los meses no se ha visto ninguna película, no ha 
        de mostrar la información de ese mes. 
        */

        $peliculas["enero"] = 9; 
        $peliculas["febrero"] = 12; 
        $peliculas["marzo"] = 0; 
        $peliculas["abril"] = 17;
        
        echo "<h1>Películas de cada mes.</h1>";

        foreach ($peliculas as $mes=>$cantidadPelis){
            if ($cantidadPelis > 0) {
                echo "<p>Mes: '" .$mes. "' Películas: " .$cantidadPelis. "</p>";
            }
        }

    ?>

</body>
</html>