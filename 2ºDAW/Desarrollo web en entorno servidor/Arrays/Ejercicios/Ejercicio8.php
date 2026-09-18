<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 8</title>
</head>
<body>
       
    <?php

        /*
        Crea un array con los nombres Pedro, Ismael, Sonia, Clara, Susana, Alfonso
        y Teresa. Muestra el número de elementos que contiene y cada elemento en 
        una lista no numerada.
        */

        $nombres[] = "Pedro";
        $nombres[] = "Ismael";
        $nombres[] = "Sonia";
        $nombres[] = "Clara";
        $nombres[] = "Susana";
        $nombres[] = "Alfonso";
        $nombres[] = "Teresa";

        echo "<p>La lista de nombres tiene " .count($nombres). " elementos.</p>";

        echo "<ul>";
        for ($i=0; $i < count($nombres); $i++) { 
            
            echo "<li>" .$nombres[$i]. "</li>";
            
        }
        echo "</ul>";

    ?>

</body>
</html>