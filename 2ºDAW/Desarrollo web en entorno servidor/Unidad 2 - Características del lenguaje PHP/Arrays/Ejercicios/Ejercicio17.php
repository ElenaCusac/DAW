<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 17</title>
</head>
<body>
      
    <?php

        /*
        Crea un array multidimensional para guardar los componentes de
        dos familias: "Los Simpson" y "Los Griffin".

        Muestra los valores de las dos familias en una lista no numerada.
        */

        $familias = array(
            "Los Simpson" => array(
                "padre" => "Homer",
                "madre" => "Marge",
                "hijos" => array("Bart", "Lisa", "Maggie")
            ),

            "Los Griffin" => array(
                "padre" => "Peter",
                "madre" => "Lois",
                "hijos" => array("Chris", "Meg", "Stewie")
            )
        );

        echo "<ul>";

        foreach ($familias as $familia => $datos) {

            echo "<li>";
            echo "<strong>" . $familia . "</strong>";

            echo "<ul>";

            echo "<li>Padre: " . $datos["padre"] . "</li>";
            echo "<li>Madre: " . $datos["madre"] . "</li>";

            echo "<li>Hijos:";
            echo "<ul>";

            foreach ($datos["hijos"] as $hijo) {
                echo "<li>" . $hijo . "</li>";
            }

            echo "</ul>";
            echo "</li>";

            echo "</ul>";
            echo "</li>";
        }

        echo "</ul>";

    ?>
 
</body>
</html>