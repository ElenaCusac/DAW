<?php

function es_todo_letras($numero) {
    $todo_letras = true;

    for ($i = 0; $i < strlen($numero); $i++) {
        $caracter = ord($numero[$i]);

        if (!(($caracter >= ord("A") && $caracter <= ord("Z")) ||
              ($caracter >= ord("a") && $caracter <= ord("z")) ||
              $caracter == ord(" "))) {

            $todo_letras = false;
            break;
        }
    }

    return $todo_letras;
}


if (isset($_POST["btnComparar"])) {

    $numero = $_POST["numero"];

    $error_numero = $numero == "" || !es_todo_letras($numero);

    $error_formulario = $error_numero;
}

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Números Romanos</title>

    <style>
        .celeste {
            background-color: lightblue;
        }

        .verdoso {
            background-color: lightgreen;
        }

        .cuadrado {
            border: 3px solid black;
            padding: 0.5em;
            margin-top: 1em;
        }

        .error {
            color: red;
        }

        .texto_centrado {
            text-align: center;
        }
    </style>
</head>

<body>

    <div class="cuadrado celeste">

        <form action="ejercicio4.php" method="post">

            <h2 class="texto_centrado">Romanos a Árabes - Formulario</h2>

            <p>
                Dime un número en números romanos y lo convertiré a cifras árabes.
            </p>

            <p>
                <label for="numero">Número: </label>

                <input type="text" name="numero" id="numero" value="<?php if (isset($_POST["numero"])) { echo $_POST["numero"];}?>">

                <?php

                if (isset($_POST["btnComparar"]) && $error_formulario) {

                    if ($_POST["numero"] == "") {
                        echo "<span class='error'>Campo obligatorio.</span>";

                    } else {
                        echo "<span class='error'>Debes teclear solo letras.</span>";
                    }
                }

                ?>

            </p>

            <p>
                <button type="submit" name="btnComparar" id="btnComparar"> Comparar </button>
            </p>

        </form>

    </div>

</body>

</html>