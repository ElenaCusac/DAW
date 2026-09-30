<?php

function es_todo_letras($frase) {
    $todo_letras = true;

    for ($i = 0; $i < strlen($frase); $i++) {
        $caracter = ord($frase[$i]);

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

    $frase = $_POST["frase"];

    $error_frase = $frase == "" || strlen($frase) < 3 || !es_todo_letras($frase);

    $error_formulario = $error_frase;
}

?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Frase Palíndroma</title>

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

        <form action="ejercicio3.php" method="post">

            <h2 class="texto_centrado">Frases Palíndromas - Formulario</h2>

            <p>
                Dime una frase sin tildes, números ni signos de puntuación
                y te diré si es una frase palíndroma.
            </p>

            <p>
                <label for="frase">Frase: </label>

                <input type="text" name="frase" id="frase" value="<?php if (isset($_POST["frase"])) { echo $_POST["frase"];}?>">

                <?php

                if (isset($_POST["btnComparar"]) && $error_formulario) {

                    if ($_POST["frase"] == "") {
                        echo "<span class='error'>Campo obligatorio.</span>";

                    } elseif (strlen($_POST["frase"]) < 3) {
                        echo "<span class='error'>Debes teclear al menos tres caracteres.</span>";

                    } else {
                        echo "<span class='error'>Debes teclear solo letras y espacios.</span>";
                    }
                }

                ?>

            </p>

            <p>
                <button type="submit" name="btnComparar" id="btnComparar"> Comparar </button>
            </p>

        </form>

    </div>

    <?php

    if (isset($_POST["btnComparar"]) && !$error_formulario) {

        $frase = trim(str_replace(" ", "", $_POST["frase"]));

        $longitud = strlen($frase);
        $resultado = "es palíndroma";

        for ($i = 0, $j = $longitud - 1; $i < $j; $i++, $j--) {

            if ($frase[$i] != $frase[$j]) {
                $resultado = "no es palíndroma";
                break;
            }
        }

        echo "<div class='cuadrado verdoso'>";
        echo "<h2 class='texto_centrado'>Frases Palíndromas - Respuesta</h2>";
        echo "<p>La frase <strong>" . htmlspecialchars($_POST["frase"]) . "</strong> " . $resultado  . ".</p>";
        echo "</div>";
    }

    ?>

</body>

</html>
