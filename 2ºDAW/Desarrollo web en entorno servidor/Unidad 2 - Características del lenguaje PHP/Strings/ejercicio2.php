<?php

function es_todo_letras($palabra) {
    $todo_letras = true;

    for ($i = 0; $i < strlen($palabra); $i++) {
        $caracter = ord($palabra[$i]);

        if (!(($caracter >= ord("A") && $caracter <= ord("Z")) ||
              ($caracter >= ord("a") && $caracter <= ord("z")))) {
            $todo_letras = false;
            break;
        }
    }

    return $todo_letras;
}

function es_todo_numeros($palabra) {
    $todo_numeros = true;

    for ($i = 0; $i < strlen($palabra); $i++) {
        $caracter = ord($palabra[$i]);

        if (!($caracter >= ord("0") && $caracter <= ord("9"))) {
            $todo_numeros = false;
            break;
        }
    }

    return $todo_numeros;
}


if (isset($_POST["btnComparar"])) {

    $palabra = $_POST["palabra"];

    $error_palabra = $palabra == "" || strlen($palabra) < 3 || (!es_todo_letras($palabra) && !es_todo_numeros($palabra));

    $error_formulario = $error_palabra;
}

?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Palíndromo</title>

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

        <form action="ejercicio2.php" method="post">

            <h2 class="texto_centrado">Palíndromos/Capicúa - Formulario</h2>

            <p>
                Dime una palabra o un número y te diré si es un palíndromo
                o un número capicúa.
            </p>

            <p>
                <label for="palabra">Palabra o número: </label>

                <input type="text" name="palabra" id="palabra" value="<?php if (isset($_POST["palabra"])) { echo htmlspecialchars($_POST["palabra"]);}?>">

                <?php

                if (isset($_POST["btnComparar"]) && $error_formulario) {

                    if ($_POST["palabra"] == "") {
                        echo "<span class='error'>Campo obligatorio.</span>";

                    } elseif (strlen($_POST["palabra"]) < 3) {
                        echo "<span class='error'>Debes teclear al menos tres caracteres.</span>";

                    } else {
                        echo "<span class='error'>Debes teclear solo letras o números.</span>";
                    }
                }

                ?>

            </p>

            <p>
                <button type="submit" name="btnComparar" id="btnComparar">Comparar</button>
            </p>

        </form>

    </div>


    <?php

    if (isset($_POST["btnComparar"]) && !$error_formulario) {

        $palabra = strtoupper($_POST["palabra"]);
        $longitud = strlen($palabra);
        $resultado = "es palíndromo/capicúa";

        for ($i = 0, $j = $longitud - 1; $i < $j; $i++, $j--) {

            if ($palabra[$i] != $palabra[$j]) {
                $resultado = "no es palíndromo/capicúa";
                break;
            }
        }

        echo "<div class='cuadrado verdoso'>";
        echo "<h2 class='texto_centrado'>Palíndromos/Capicúa - Respuesta</h2>";
        echo "<p>La palabra <strong>" . htmlspecialchars($palabra) . "</strong> " . $resultado . ".</p>";
        echo "</div>";
    }

    ?>

</body>

</html>
