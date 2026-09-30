<?php

require "src/funciones_cte.php";

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Práctica 8</title>
    <style>
        table, td, th {
            border: 1px solid black;
        }

        table {
            border-collapse: collapse;
            text-align: center;
        }

        td, th {
            padding: 5px 10px;
        }
    </style>
</head>

<body>
    <h1>Práctica 8</h1>

    <h3>Listado de usuarios</h3>

    <table>
        <tr>
            <th>#</th>
            <th>Foto</th>
            <th>Nombre</th>
            <th>Usuario</th>
        </tr>
        <?php 
        while ($tupla = mysqli_fetch_assoc($resultado)) {
            
        }
        ?>
    </table>
</body>

</html>