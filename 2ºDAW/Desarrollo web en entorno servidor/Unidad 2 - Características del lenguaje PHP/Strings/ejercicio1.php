<?php

function es_todo_letras($texto) {
    $todo_letras = true;

    for ($i = 0; $i < strlen($texto); $i++) { 
        if (!((ord($texto[$i]) >= ord("A") && ord($texto[$i]) <= ord("Z")) ||
            (ord($texto[$i]) >= ord("a") && ord($texto[$i]) <= ord("z")))) {

            $todo_letras = false;
            break;
        }
    }

    return $todo_letras;
}

if (isset($_POST["btnComparar"])) {

    $error_texto1 = $_POST["texto1"] == "" || strlen($_POST["texto1"]) < 3 || !es_todo_letras($_POST["texto1"]);
    $error_texto2 = $_POST["texto2"] == "" || strlen($_POST["texto2"]) < 3 || !es_todo_letras($_POST["texto2"]);

    $error_formulario = $error_texto1 || $error_texto2;
}

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rimas</title>

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

        <form action="ejercicio1.php" method="post">

            <h2 class="texto_centrado">Ripios - Formulario</h2>

            <p>Dime dos palabras y te diré si riman o no.</p>

            <p>
                <label for="texto1">Primera palabra: </label>

                <input type="text" name="texto1" id="texto1" value="<?php if (isset($_POST["texto1"])) echo $_POST["texto1"]; ?>">

                <?php

                if (isset($_POST["btnComparar"]) && $error_texto1) {

                    if ($_POST["texto1"] == "") {
                        echo "<span class='error'>Campo obligatorio.</span>";

                    } elseif (strlen($_POST["texto1"]) < 3) {
                        echo "<span class='error'>Debes teclear al menos tres letras.</span>";

                    } else {
                        echo "<span class='error'>Debes teclear solo letras permitidas.</span>";
                    }
                }

                ?>

            </p>

            <p>
                <label for="texto2">Segunda palabra: </label>

                <input type="text" name="texto2" id="texto2" value="<?php if (isset($_POST["texto2"])) echo $_POST["texto2"]; ?>">

                <?php

                if (isset($_POST["btnComparar"]) && $error_texto2) {

                    if ($_POST["texto2"] == "") {
                        echo "<span class='error'>Campo obligatorio.</span>";

                    } elseif (strlen($_POST["texto2"]) < 3) {
                        echo "<span class='error'>Debes teclear al menos tres letras.</span>";

                    } else {
                        echo "<span class='error'>Debes teclear solo letras permitidas.</span>";
                    }
                }

                ?>

            </p>

            <button type="submit" name="btnComparar" id="btnComparar">
                Comparar
            </button>

        </form>

    </div>


    <?php

    if (isset($_POST["btnComparar"]) && !$error_formulario) {

        $m_texto1 = strtoupper($_POST["texto1"]);
        $m_texto2 = strtoupper($_POST["texto2"]);

        $l_texto1 = strlen($_POST["texto1"]);
        $l_texto2 = strlen($_POST["texto2"]);

        $respuesta = "no riman";

        if ($m_texto1[$l_texto1 - 1] == $m_texto2[$l_texto2 - 1] && $m_texto1[$l_texto1 - 2] == $m_texto2[$l_texto2 - 2]) {

            $respuesta = "riman un poco";

            if ($m_texto1[$l_texto1 - 3] == $m_texto2[$l_texto2 - 3]) {
                $respuesta = "riman";
            }
        }

        echo "<div class='cuadrado verdoso'>";
        echo "<h2 class='texto_centrado'>Ripios - Respuesta</h2>";
        echo "<p>Las palabras <strong>" . $_POST["texto1"] . "</strong> y <strong>" . $_POST["texto2"] . "</strong> " . $respuesta . ".</p>";
        echo "</div>";
    }

    ?>

</body>

</html>
