<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Práctica Docker PHP</title>
</head>
<body>

    <h1>Aplicación PHP funcionando con Docker</h1>

    <p>Esta página está siendo ejecutada dentro de un contenedor Docker.</p>

    <p><strong>Servidor:</strong> Nginx</p>

    <p><strong>Lenguaje:</strong> PHP</p>

    <p><strong>Entorno:</strong> WSL2 + Docker</p>

    <h2>Información de PHP</h2>

    <?php
        echo "<p>PHP está funcionando correctamente.</p>";
        echo "<p>Versión de PHP: " . phpversion() . "</p>";
        echo "<p>Fecha y hora del servidor: " . date("d/m/Y H:i:s") . "</p>";
    ?>

</body>
</html>
