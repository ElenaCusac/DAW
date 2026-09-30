<?php

function todo_numeros($numero){
    return is_numeric($numero);
}

function controlar_tamanio($numero) {
    $tamanio_correcto = true;

    if ($numero > 10 || $numero < 1) {
        $tamanio_correcto = false;
    }

    return $tamanio_correcto;
}

if (isset($_POST["btnCrear"])) {
    $error_formulario = $_POST["numero"] == "" || !todo_numeros($_POST["numero"]) || !controlar_tamanio($_POST["numero"]);
}

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 1</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>

<body>
    <h1>Tablas de multiplicar</h1>

    <form action="ejercicio1.php" method="post">
        <p>
            <label for="numero">Introduce un número del 1 al 10 de la tabla de multiplicar: </label>
            <input type="text" id="numero" name="numero" value="<?php if (isset($_POST["numero"])) { echo $_POST["numero"];}?>">
        
            <?php

            if (isset($_POST["btnCrear"]) && $error_formulario) {
                if ($_POST["numero"] == "") {
                    echo "<span class='error'>Campo obligatorio</span>";
                }
                    
            }

            ?>
        
        </p>
        <p>
            <button type="submit" id="btnCrear" name="btnCrear">Crear tabla</button>
        </p>
        

    </form>
</body>

</html>