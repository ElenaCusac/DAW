<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teoría Ficheros de Texto</title>
</head>

<body>
    <h1>Teoría Ficheros de Texto</h1>

    <?php 
        // Modos de apertura: (r -> lectura, w -> escritura, a -> añadir)
        // Todos añaden lo que le falta si le ponemos el +
        /*
        if (file_exists("prueba2.txt")) {
            $fd = fopen("prueba2.txt", "w");
        } else if {
            die("<p>El fichero 'prueba2.txt' no existe</p></body></html>");
        }

        fclose($fd);
        */

        // Continuar teoría
        if (file_exists("prueba.txt")) {
            $fd = fopen("prueba.txt", "w");
        } else if {
            die("<p>El fichero 'prueba.txt' no existe</p></body></html>");
        }

        fclose($fd);

        // Escribir con fputs o fwrite
        // .PHP_EOL hace un salto de línea
        fputs($fd, "Esta es mi primera línea.".PHP_EOL);
        fputs($fd, "Esta es mi segunda línea.".PHP_EOL);

        fclose($fd);

        echo "<p>Fichero creado con 2 líneas.</p>"

        if (file_exists("prueba.txt")) {
            $fd = fopen("prueba.txt", "a");
        } else if {
            die("<p>El fichero 'prueba.txt' no existe</p></body></html>");
        }

        fclose($fd);

        // Escribir con fputs o fwrite
        // .PHP_EOL hace un salto de línea
        fputs($fd, "Esta es mi tercera línea.".PHP_EOL);
        fputs($fd, "Esta es mi cuarta línea.".PHP_EOL);

        fclose($fd);

        echo "<p>Fichero creado con 2 líneas.</p>";


        if (file_exists("prueba.txt")) {
            $fd = fopen("prueba.txt", "r");
        } else if {
            die("<p>El fichero 'prueba.txt' no existe</p></body></html>");
        }

        fclose($fd);

        // Vamos a utilizar fgets para leer el fichero y mostrarlo por pantalla
        echo "<h3>Lectura línea a línea del fichero.</h3>";
        $linea = fgets($fd);
        echo "<p>" .$linea. "<p>";
        $linea = fgets($fd);
        echo "<p>" .$linea. "<p>";
        $linea = fgets($fd);
        echo "<p>" .$linea. "<p>";
        $linea = fgets($fd);
        echo "<p>" .$linea. "<p>";

        echo "<h3>Nos vamos al principio del fichero con fseek(fd, 0).</h3>";
        fseek($fd, 0) // Hace que el 'puntero' se vaya al principio del fichero

        echo "<h3>Lectura línea a línea de nuevo del fichero<h3>";

        while($linea = fgets($fd)) {
            echo "<p>" .$linea. "</p>";
        }

        echo "<h3>Nos vamos al principio del fichero con fseek(fd, 0).</h3>";
        fseek($fd, 0) // Hace que el 'puntero' se vaya al principio del fichero

        echo "<h3>Lectura línea a línea de nuevo del fichero<h3>";

        while(!feof($fd)) {
            $linea = fgets($fd);
            echo "<p>" .$linea. "</p>";
        }

        $todo = file_get_contents("prueba.txt");
        file_put_contents("prueba2.txt", $todo);

        unlink("prueba.txt"); //borra el archivo en cuestión

        $web=file_get_contents("https://www.google.com");
    ?>

</body>

</html>