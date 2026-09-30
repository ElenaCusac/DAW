<?php

if (isset($_POST["btnContar"])) {
    $error_archivo = !isset($_FILES["archivo"]) || $_FILES["archivo"]["error"] != 0;

    if (!$error_archivo) {
        $extension = strtolower(
            pathinfo($_FILES["archivo"]["name"], PATHINFO_EXTENSION)
        );

        $error_extension = $extension != "txt";
        $error_tamanio = $_FILES["archivo"]["size"] > 2621440;
    }
}

?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 4</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>

<body>
    <h1>Contar palabras de un fichero</h1>

    <form action="ejercicio4.php" method="post" enctype="multipart/form-data">
        <p>
            <label for="archivo">Selecciona un fichero TXT (tamaño máx: 2,5Mb):</label>
            <input type="file" id="archivo" name="archivo" accept=".txt" required>
        </p>

        <p>
            <button type="submit" name="btnContar">Contar palabras</button>
        </p>

        <?php
        if (isset($_POST["btnContar"])) {
            if ($error_archivo) {
                echo "<p class='error'>* Debes seleccionar un fichero válido.</p>";

            } elseif ($error_extension) {
                echo "<p class='error'>* El fichero debe tener extensión TXT.</p>";

            } elseif ($error_tamanio) {
                echo "<p class='error'>* El tamaño máximo es de 2,5 MB.</p>";
                
            } else {
                $contenido = file_get_contents($_FILES["archivo"]["tmp_name"]);

                $palabras = str_word_count($contenido, 0, "áéíóúÁÉÍÓÚüÜñÑ");

                echo "<p>El fichero contiene " . $palabras . " palabras.</p>";
            }
        }
        ?>
    </form>
</body>

</html>