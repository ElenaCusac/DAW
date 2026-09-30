<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recogida</title>
</head>

<body>

    <h1>Estos son los datos enviados</h1>

    <p>
        <strong>El nombre enviado ha sido: </strong>
        <?php echo $_POST["nombre"]; ?>
    </p>

    <p>
        <strong>Ha nacido en: </strong>
        <?php echo $_POST["nacido"]; ?>
    </p>

    <p>
        <strong>El sexo es: </strong>
        <?php echo $_POST["sexo"]; ?>
    </p>

    <?php

    if (isset($_POST["aficiones"])) {

        echo "<p><strong>Las aficiones seleccionadas han sido:</strong></p>";

        echo "<ol>";

        foreach ($_POST["aficiones"] as $aficion) {
            echo "<li>" . $aficion . "</li>";
        }

        echo "</ol>";

    } else {

        echo "<p><strong>No has seleccionado ninguna afición.</strong></p>";

    }

    ?>

    <p>
        <?php
        if ($_POST["comentarios"]) {
            echo "<strong>El comentario enviado ha sido: </strong>" . $_POST["comentarios"];             
        } else {
            echo "No has escrito ningún comentario";
        }
        ?>

    </p>

</body>
</html>
