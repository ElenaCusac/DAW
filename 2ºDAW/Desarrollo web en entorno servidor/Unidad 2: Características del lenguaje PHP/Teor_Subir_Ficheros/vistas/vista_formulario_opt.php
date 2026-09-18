<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teoría Subir Ficheros</title>
    <style>
        .error{color:red}
    </style>
</head>
<body>
    <h1>Teoría Subir Ficheros</h1>
    <form action="index_opt.php" method="post" enctype="multipart/form-data">
        <p>
            <label for="foto">Seleccione un archivo imagen con extensión (Máx 500KB): </label>
            <input type="file" name="foto" id="foto" accept="image/*">
            <?php
            if(isset($_POST["btnEnviar"]) && $error_foto)
            {
                if($_FILES["foto"]["error"])
                    echo "<span class='error'> * Error en la subida del fichero al servidor </span>";
                elseif(!tiene_extension($_FILES["foto"]["name"]))
                    echo "<span class='error'> * El fichero seleccionado no tienen extensión </span>";
                elseif(!mi_getimagesize($_FILES["foto"]))
                    echo "<span class='error'> * El archivo seleccionado no es un archivo imagen </span>";
                else
                    echo "<span class='error'> * El archivo seleccionado supera los 500KB </span>";
            }
            ?>
        </p>
        <p>
            <button type="submit" name="btnEnviar">Enviar</button>
        </p>
    </form>
</body>
</html>