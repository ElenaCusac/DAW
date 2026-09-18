<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php 
        // Esto es un comentario de línea

        $valor1="Un texto";
        $valor2="Otro texto";
        echo "<h1>".$valor1."</h1>";
        echo "<p>".$valor2."</p>";

        $valor3=10;

        // La función isset() sirve para saber si la variable que tiene dentro existe o no
        // Devuelve un boolean 
        $creada = isset($p);
        echo isset($p);

        if ($creada) {
            echo "<p>La variable está creada</p>";
        } else {
            echo "<p>La variable NO está creada</p>";
        }

        // Dos formas de crear constantes en PHP
        const CONSTANTE = 6;
        define("CONST2", 8);

        $operaciones = 3 + 78 +7 / CONSTANTE * 8;
        $cadena = "<p> El resultado de la operación es " .$operaciones. "</p>";
        echo $cadena;

        $nota=5;

        if ($nota<5) {
            echo "<p>La nota es mala</p>"
        } elseif ($nota<7) {
            echo "<p>La nota es regulera</p>"
        } elseif ($nota<) {            
            echo "<p>La nota es buena</p>"
        }

        $cont=0;
        while($cont<=10){
            $cont++;
            echo "<p>" .$cont. "</p>"
        }

        for ($i=0; $i <= 10 ; $i++) { 
            echo "<p>" .$cont. "</p>"
        }

    ?>
</body>
</html>