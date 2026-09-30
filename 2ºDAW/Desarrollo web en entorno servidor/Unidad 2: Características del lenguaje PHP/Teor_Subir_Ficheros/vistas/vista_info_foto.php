<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teoría Subir Ficheros</title>
    <style>
        img{height:200px}
    </style>
</head>
<body>
    <h1>Información de la imagen subida</h1>
    <?php
    $nombre_imagen=uniqid("img_").".".tiene_extension($_FILES["foto"]["name"]);
    @$var=move_uploaded_file($_FILES["foto"]["tmp_name"],"images/".$nombre_imagen);
    if(!$var)
    {
        echo "<p>No se ha podido mover la imagen subida a la carpeta destino</p>";
    }
    else
    {
        echo "<p><strong>Nombre Original: </strong>".$_FILES["foto"]["name"]."</p>";
        echo "<p><strong>Tipo: </strong>".$_FILES["foto"]["type"]."</p>";
        echo "<p><strong>Tamaño: </strong>".$_FILES["foto"]["size"]."</p>";
        echo "<p><strong>Archivo subido temporalmente en: </strong>".$_FILES["foto"]["tmp_name"]."</p>";
        echo "<p><img src='images/".$nombre_imagen."' alt='Imagen Subida' title='Imagen Subida'></p>";
    }

    ?>
</body>
</html>