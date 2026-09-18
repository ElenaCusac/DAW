<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 1</title>
</head>
<body>

    <?php
        /*
         Almacena en un array los 10 primeros números pares. 
         Imprímelos cada uno en una línea.
        */

        const NUM_PARES = 10;

        for ($i=1; $i <= NUM_PARES; $i++) { 
            $pares[] = $i*2;
        }

        echo "<h1> Los " .NUM_PARES. " primeros números pares.</h1>";
        for ($i=0; $i < count($pares); $i++) { 
            echo "<p>" .$pares[$i]. "</p>";
        }

    ?>
    
</body>
</html>