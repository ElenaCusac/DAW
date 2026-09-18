<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recogida</title>
</head>
<body>

    <h1>Estos son los datos enviados</h1>

    <p>
        <strong>El nombre enviado ha sido: </strong>
        <?php echo $_POST["nombre"];?>
    </p>

    <p>
        <strong>Ha nacido en: </strong>
        <?php echo $_POST["nacido"];?>
    </p>

    <p>
        <strong>El sexo es: </strong>
        <?php echo $_POST["sexo"];?>
    </p>

    <p>
        <strong>La afición seleccionada ha sido: </strong>
        <?php
        foreach($_POST["aficiones"] as $aficion)
        {
            echo $aficion . " ";
        }
        ?>
    </p>

    <p>
        <strong>El comentario enviado ha sido: </strong>
        <?php echo $_POST["comentarios"];?>
    </p>

</body>
</html>