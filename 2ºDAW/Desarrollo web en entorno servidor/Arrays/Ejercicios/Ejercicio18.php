<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 18</title>
</head>
<body>

    <?php

        /*
        Crea un array llamado deportes e introduce los siguientes valores:
        fútbol, baloncesto, natación y tenis.
        */

        $deportes = array("fútbol", "baloncesto", "natación", "tenis");

        // Recorrido del array con un for
        echo "<h3>Deportes:</h3>";

        for ($i = 0; $i < count($deportes); $i++) {
            echo $deportes[$i] . "<br>";
        }

        // Muestra el total de valores que contiene
        echo "<p>Total de valores: " . count($deportes) . "</p>";

        // Sitúa el puntero en el primer elemento
        reset($deportes);
        echo "<p>Primer elemento: " . current($deportes) . "</p>";

        // Avanza una posición
        next($deportes);
        echo "<p>Después de avanzar una posición: " . current($deportes) . "</p>";

        // Coloca el puntero en la última posición
        end($deportes);
        echo "<p>Último elemento: " . current($deportes) . "</p>";

        // Retrocede una posición
        prev($deportes);
        echo "<p>Después de retroceder una posición: " . current($deportes) . "</p>";

    ?>

</body>
</html>
