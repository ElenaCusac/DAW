<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 5</title>
</head>
<body>
    
    <?php

    /*
        Crea un array asociativo para introducir los datos de 
        una persona:
        
        Nombre: Pedro Torres
        Dirección: C/Mayor, 37
        Teléfono: 123456789
    */

    $personas["Nombre"] = "Pedro Torres";
    $personas["Dirección"] = "C/Mayor, 37";
    $personas["Teléfono"] = 123456789;

    foreach($personas as $indice=>$valor){
            echo "<p>" . $indice . ": " .$valor. "</p>";
        }

    ?>

</body>
</html>