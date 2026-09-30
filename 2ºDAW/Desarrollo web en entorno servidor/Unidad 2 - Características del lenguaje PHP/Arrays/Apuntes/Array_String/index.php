<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teoría Arrays - Strings</title>
</head>
<body>
    <h1>Teoría Arrays - Strings</h1>
    <?php
        $notas[0] = 1;
        $notas[1] = 67;
        $notas[2] = 32;

        $notas[] = 1;
        $notas[] = 67;
        $notas[] = 32;

        for ($i=0; $i < count($notas) ; $i++) { 
            echo "<p>" .$notas[$i]. "</p>"; 
        }

        if (in_array(45, $notas))
            echo "<p>El número 45 está en el array de notas</p>";
        else 
            echo "<p>El número 45 no está en el array de notas</p>";    
    
        echo "<p>El arrray 'notas' tiene " .count($notas). " elementos</p>"; 

        $valores[] = 18;
        $valores[] = true;
        $valores[] = "Una cadena";
        $valores["salario"] = 3000;
        $valores[7] = 78; 
        $valores[] =  90;
        $valores[] = "23/09/1876"; 

        echo "<ul>"; 
        foreach ($valores as $dato) {
            echo "<li>" .$dato. "</li>"; 
        }
        echo "</ul>"; 

        echo "<ul>"; 
        foreach ($valores as $indice => $dato) {
            echo "<li>Índice: " .$indice. " Valor: " .$dato. "</li>"; 
        }
        echo "</ul>"; 


        // Otra forma de escribir un array utilizando un constructor
        $valores = Array(18, true, "Una cadena", "salario"=>3000, 7=>78, 90, "fecha"=>"23/09/1876");

        // Array bidimensional
        $paises["España"]["Málaga"] = 1000000;   
        $paises["España"]["Granada"] = 900000;  
        $paises["España"]["Almería"] = 800000;       
        $paises["Francia"]["París"] = 2000000;  
        $paises["Francia"]["Lyon"] = 1800000;  
        $paises["Francia"]["Marsella"] = 1500000;  

        // Otra forma de hacer un array bidimensional
        $paises=array("España"=> array("Málaga"=>1000000, "Granada"=>900000, "Almería"=>800000), "Francia"=>array("París"=>2000000, "Lyon"=>1800000, "Marsella"=>1500000));

        echo "<h3>Habitantes de las principales ciudades de Europa por países</h3>";
        echo "<ol>";
        foreach ($paises as $pais => $ciudades) {
            echo "<li>";
                echo $pais;

                echo "<ul>";
                    foreach ($ciudades as $ciudad => $habitantes) {
                        echo "<li>".$ciudad.": " .$habitantes. " habitantes";
                    }
                echo "</ul>";

            echo "</li>";
        }
        echo "</ol>";
    ?>
</body>
</html>