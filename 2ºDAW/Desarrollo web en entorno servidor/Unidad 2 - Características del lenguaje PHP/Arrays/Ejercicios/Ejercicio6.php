<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 6</title>
</head>
<body>
   
    <?php

        /*
        Crea un array introduciendo las ciudades: Madrid, Barcelona, Londres, New York,
        Los Ángeles y Chicago, sin asignar índices al array. A continuación, muestra el
        contenido del array haciendo un recorrido diciendo el valor correspondiente a 
        cada índice. 
        Ejemplo: 

            La ciudad con el índice 0 tiene el nombre Madrid.
            
        */

        $ciudades[] =  "Madrid";
        $ciudades[] =  "Barcelona";
        $ciudades[] =  "Londres";
        $ciudades[] =  "New York";
        $ciudades[] =  "Los Ángeles";
        $ciudades[] =  "Chicago";

        for ($i=0; $i < count($ciudades); $i++) { 
            echo "<p>La ciudad con el índice " .$i. " tiene el nombre " .$ciudades[$i]. "</p>";
        }r

    ?>

</body>
</html>