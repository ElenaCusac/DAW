<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 16</title>
</head>
<body>
      
    <?php

        /*
        Crea un array con los siguientes valores:
        5 => 1, 12 => 2, 13 => 56, x => 42.
        
        Muestra el contenido.
        Cuenta el número de elementos y muéstralo por pantalla.
        A continuación borra el elemento de la posición 5.
        Vuelve a mostrar el contenido.
        */

        $numeros = array(
            5 => 1,
            12 => 2,
            13 => 56,
            42 => 42
        );

        echo "<h3>Contenido del array:</h3>";

        foreach ($numeros as $indice => $valor) {
            echo "Índice: " . $indice . " - Valor: " . $valor . "<br>";
        }

        echo "<p>El número de elementos es: " . count($numeros) . "</p>";

        unset($numeros[5]);

        echo "<h3>Contenido después de eliminar la posición 5:</h3>";

        foreach ($numeros as $indice => $valor) {
            echo "Índice: " . $indice . " - Valor: " . $valor . "<br>";
        }

    ?>
 
</body>
</html>