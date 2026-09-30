<?php
require "src/funciones_ctes.php";

try {
    @$conexion = mysqli_connect(SERVIDOR_BD, USUARIO_BD, CLAVE_BD, NOMBRE_BD);
    mysqli_set_charset($conexion, "utf8");
} catch (Exception $e) {
    die(error_page("Práctica 8", "<h1>Práctica 8</h1><p>Error al intentar conectarse a la BD: " . $e->getMessage() . "</p>"));
}


if (isset($_POST["btnContNuevo"])) {
    $error_nombre = $_POST["nombre"] == "";
    $error_usuario = $_POST["usuario"] == "";
    if (!$error_usuario) {
        $error_usuario = repetido($conexion, "usuarios", "usuario", $_POST["usuario"]);
        if (is_string($error_usuario)) {
            mysqli_close($conexion);
            die(error_page("Práctica 8", "<h1>Práctica 8</h1><p>Error al intentar realizar la consulta: " . $error_usuario . "</p>"));
        }
    }

    $error_clave = $_POST["clave"] == "";
    $error_dni = !dni_bien_escrito($_POST["dni"]) || !dni_valido($_POST["dni"]);
    if (!$error_dni) {
        $error_dni = repetido($conexion, "usuarios", "dni", strtoupper($_POST["dni"]));
        if (is_string($error_dni)) {
            mysqli_close($conexion);
            die(error_page("Práctica 8", "<h1>Práctica 8</h1><p>Error al intentar realizar la consulta: " . $error_dni . "</p>"));
        }
    }

    $error_sexo = !isset($_POST["sexo"]);
    $error_foto = $_FILES["foto"]["name"] == !"" && ($_FILES["foto"]["error"] || $_FILES["foto"]["size"] > 500 * 1024 || !tiene_extension($_FILES["foto"]["name"]) || !mi_getimagesize($_FILES["foto"]));

    $error_form = $error_nombre || $error_usuario || $error_clave || $error_dni || $error_sexo || $error_foto;

    if (!$error_form) {
        //Insertaría en la BD un nuevo usuario

        try {
            $consulta = "insert into usuarios (nombre, usuario, clave, dni, sexo) values('" . $_POST["nombre"] . "','" . $_POST["usuario"] . "','" . md5($_POST["clave"]) . "','" . strtoupper($_POST["dni"]) . "','" . $_POST["sexo"] . "')";
            mysqli_query($conexion, $consulta);
        } catch (Exception $e) {
            mysqli_close($conexion);
            die(error_page("Práctica 8", "<h1>Práctica 8</h1><p>Error al intentar realizar la consulta: " . $e->getMessage() . "</p>"));
        }

        $mensaje_accion = "¡¡Usuario creado correctamente!!";

        // Recupero el id que MySQL acaba de asignar al usuario.
        $ultm_id = mysqli_insert_id($conexion);

        // Si se ha subido una foto, la guardo en Img y almaceno su nombre en la BD.
        if (isset($_FILES["foto"]) && $_FILES["foto"]["name"] != "") {
            $extension = strtolower(pathinfo($_FILES["foto"]["name"], PATHINFO_EXTENSION));
            // La contraseña se guarda como MD5 en la BD; uso ese mismo valor en el nombre.
            $nombre_foto = $ultm_id . "_" . md5($_POST["clave"]) . "." . $extension;

            if (move_uploaded_file($_FILES["foto"]["tmp_name"], "Img/" . $nombre_foto)) {
                $nombre_foto_bd = mysqli_real_escape_string($conexion, $nombre_foto);
                $consulta = "update usuarios set foto='" . $nombre_foto_bd . "' where id_usuario=" . $ultm_id;
                mysqli_query($conexion, $consulta);
            } else {
                // El usuario se ha creado, pero no se ha podido guardar la foto.
                $mensaje_accion = "El usuario se ha creado, pero no se ha podido guardar la imagen.";
            }
        }
    }
}

// Borrar usuario
if (isset($_POST["btnBorrar"])) {
    try {
        $id_borrar = $_POST["btnBorrar"];
        $consulta = "select foto from usuarios where id_usuario=" . $id_borrar;
        $resultado_foto = mysqli_query($conexion, $consulta);
        $datos_foto = mysqli_fetch_assoc($resultado_foto);
        mysqli_free_result($resultado_foto);

        $consulta = "delete from usuarios where id_usuario=" . $id_borrar;
        mysqli_query($conexion, $consulta);

        if (mysqli_affected_rows($conexion) > 0) {
            if ($datos_foto && $datos_foto["foto"] != "" && $datos_foto["foto"] != "no_imagen.jpg" && file_exists("Img/" . $datos_foto["foto"]))
                unlink("Img/" .$datos_foto["foto"]);
            $mensaje_accion = "¡¡ Usuario borrado correctamente!!";
        } else
            $mensaje_accion = "No se ha podido borrar el usuario porque ya no existe.";
    } catch (Exception $e) {
        mysqli_close($conexion);
        die(error_page("Práctica 8", "<h1>Práctica 8</h1><p>Error al intentar borrar el usuario: " . $e->getMessage() . "</p>"));
    }
}

// Guardar cambios de un usuario editado
if (isset($_POST["btnContEditar"])) {
    $id_editar = $_POST["id_usuario"];
    $error_nombre = trim($_POST["nombre"]) == "";
    $error_usuario = trim($_POST["usuario"]) == "";
    if (!$error_usuario) {
        $error_usuario = repetido($conexion, "usuarios", "usuario", mysqli_real_escape_string($conexion, $_POST["usuario"]));
        if (!$error_usuario)
            $error_usuario = false;
        else {
            $consulta = "select id_usuario from usuarios where usuario='" . mysqli_real_escape_string($conexion, $_POST["usuario"]) . "' and id_usuario<>" . $id_editar;
            $resultado_repetido = mysqli_query($conexion, $consulta);
            $error_usuario = mysqli_num_rows($resultado_repetido) > 0;
            mysqli_free_result($resultado_repetido);
        }
    }

    $error_clave = trim($_POST["clave"]) == "";
    $error_dni = !dni_bien_escrito($_POST["dni"]) || !dni_valido($_POST["dni"]);
    if (!$error_dni) {
        $consulta = "select id_usuario from usuarios where dni='" . mysqli_real_escape_string($conexion, strtoupper($_POST["dni"])) . "' and id_usuario<>" . $id_editar;
        $resultado_repetido = mysqli_query($conexion, $consulta);
        $error_dni = mysqli_num_rows($resultado_repetido) > 0;
        mysqli_free_result($resultado_repetido);
    }
    $error_sexo = !isset($_POST["sexo"]);
    $error_foto = isset($_FILES["foto"]) && $_FILES["foto"]["name"] != "" && ($_FILES["foto"]["error"] || $_FILES["foto"]["size"] > 500 * 1024 || !tiene_extension($_FILES["foto"]["name"]) || !mi_getimagesize($_FILES["foto"]));
    $error_form = $error_nombre || $error_usuario || $error_clave || $error_dni || $error_sexo || $error_foto;

    if (!$error_form) {
        try {
            $nombre = mysqli_real_escape_string($conexion, trim($_POST["nombre"]));
            $usuario = mysqli_real_escape_string($conexion, trim($_POST["usuario"]));
            $dni = mysqli_real_escape_string($conexion, strtoupper(trim($_POST["dni"])));
            $sexo = mysqli_real_escape_string($conexion, $_POST["sexo"]);
            $clave = md5($_POST["clave"]);
            $foto_actual = mysqli_real_escape_string($conexion, $_POST["foto_actual"]);
            $consulta = "update usuarios set nombre='" . $nombre . "', usuario='" . $usuario . "', clave='" . $clave . "', dni='" . $dni . "', sexo='" . $sexo . "' where id_usuario=" . $id_editar;
            mysqli_query($conexion, $consulta);

            // El nombre de la foto sigue el formato id_usuario_contraseña.extensión.
            // Como la contraseña se almacena con MD5, se utiliza ese valor para no
            // guardar la contraseña original en el nombre del archivo.
            if (isset($_FILES["foto"]) && $_FILES["foto"]["name"] != "") {
                $extension = strtolower(pathinfo($_FILES["foto"]["name"], PATHINFO_EXTENSION));
                $nombre_foto = $id_editar . "_" . $clave . "." . $extension;
                if (move_uploaded_file($_FILES["foto"]["tmp_name"], "Img/" . $nombre_foto)) {
                    $nombre_foto_bd = mysqli_real_escape_string($conexion, $nombre_foto);
                    $consulta = "update usuarios set foto='" . $nombre_foto_bd . "' where id_usuario=" . $id_editar;
                    mysqli_query($conexion, $consulta);
                    if ($foto_actual != "" && $foto_actual != "no_imagen.jpg" && $foto_actual != $nombre_foto && file_exists("Img/" . $foto_actual))
                        unlink("Img/" . $foto_actual);
                } else
                    throw new Exception("No se ha podido guardar la imagen subida.");
            } elseif ($foto_actual != "" && $foto_actual != "no_imagen.jpg" && file_exists("Img/" . $foto_actual)) {
                // Si cambia la contraseña pero no sube otra foto, renombro la existente.
                $extension_actual = strtolower(pathinfo($foto_actual, PATHINFO_EXTENSION));
                $nuevo_nombre_foto = $id_editar . "_" . $clave . "." . $extension_actual;
                if ($foto_actual != $nuevo_nombre_foto && rename("Img/" . $foto_actual, "Img/" . $nuevo_nombre_foto)) {
                    $nuevo_nombre_foto_bd = mysqli_real_escape_string($conexion, $nuevo_nombre_foto);
                    $consulta = "update usuarios set foto='" . $nuevo_nombre_foto_bd . "' where id_usuario=" . $id_editar;
                    mysqli_query($conexion, $consulta);
                }
            }
            $mensaje_accion = "¡¡ Usuario editado correctamente!!";
        } catch (Exception $e) {
            mysqli_close($conexion);
            die(error_page("Práctica 8", "<h1>Práctica 8</h1><p>Error al intentar editar el usuario: " . $e->getMessage() . "</p>"));
        }
    }
}

// Cargar datos del usuario que se quiere editar
if (isset($_POST["btnEditar"])) {
    try {
        $id_editar = $_POST["btnEditar"];
        $consulta = "select * from usuarios where id_usuario=" . $id_editar;
        $resultado_editar = mysqli_query($conexion, $consulta);
        $usuario_editar = mysqli_fetch_assoc($resultado_editar);
        mysqli_free_result($resultado_editar);
    } catch (Exception $e) {
        mysqli_close($conexion);
        die(error_page("Práctica 8", "<h1>Práctica 8</h1><p>Error al intentar consultar el usuario: " . $e->getMessage() . "</p>"));
    }
}

if (isset($_POST["btnDetalles"])) {
    try {
        $consulta = "select * from usuarios where id_usuario='" . $_POST["btnDetalles"] . "'";
        $resultado_detalles_usuario = mysqli_query($conexion, $consulta);
    } catch (Exception $e) {
        mysqli_close($conexion);
        die(error_page("Práctica 8", "<h1>Práctica 8</h1><p>Error al intentar realizar la consulta: " . $e->getMessage() . "</p>"));
    }
}

if (isset($_POST["btnContEditar"]) && $error_form) {
    $id_editar = $_POST["id_usuario"];
    $consulta = "select * from usuarios where id_usuario=" . $id_editar;
    $resultado_editar = mysqli_query($conexion, $consulta);
    $usuario_editar = mysqli_fetch_assoc($resultado_editar);
    mysqli_free_result($resultado_editar);
}

// Consulta para mostrar tabla principal
// Se hace siempre
try {
    $consulta = "select * from usuarios";
    $resultado_usuarios = mysqli_query($conexion, $consulta);
} catch (Exception $e) {
    mysqli_close($conexion);
    die(error_page("Práctica 8", "<h1>Práctica 8</h1><p>Error al intentar realizar la consulta: " . $e->getMessage() . "</p>"));
}

mysqli_close($conexion);
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Práctica 8</title>
    <style>
        table, td, th {
            border: 1px solid black
        }

        table {
            border-collapse: collapse;
            width: 90%;
            margin: 0 auto;
            text-align: center
        }

        th {
            background-color: #CCC
        }

        img {
            height: 100px
        }

        .enlace {
            border: none;
            background: none;
            color: blue;
            text-decoration: underline;
            cursor: pointer
        }

        .error {
            color: red
        }

        .mensaje {
            color: blue;
            font-size: 1.5rem;
        }
    </style>
</head>

<body>
    <h1>Práctica 8</h1>
    <?php
    if (isset($mensaje_accion)) {
        echo "<p class='mensaje'>" . $mensaje_accion . "</p>";
    }

    if (isset($_POST["btnDetalles"])) {
        require "vistas/vista_detalles.php";
    }

    if (isset($_POST["btnEditar"]) || (isset($_POST["btnContEditar"]) && $error_form)) {
        if (isset($_POST["btnContEditar"]) && $error_form) {
            $val_nombre = $_POST["nombre"];
            $val_usuario = $_POST["usuario"];
            $val_dni = $_POST["dni"];
            $val_sexo = isset($_POST["sexo"]) ? $_POST["sexo"] : "";
        } else {
            $val_nombre = $usuario_editar["nombre"];
            $val_usuario = $usuario_editar["usuario"];
            $val_dni = $usuario_editar["dni"];
            $val_sexo = $usuario_editar["sexo"];
        }
        if (isset($usuario_editar) && $usuario_editar) {
            require "vistas/vista_editar_usuario.php";
        } else
            echo "<p class='error'>El usuario que quieres editar ya no existe.</p>";
    }

    if (isset($_POST["btnNuevo"]) || (isset($_POST["btnContNuevo"]) && $error_form)) {
        //Aquí formulario Nuevo Usuario
        require "vistas/vista_nuevo_usuario";
    }
    ?>

    <h3>Listado de los usuarios</h3>
    <table>
        <tr>
            <th>#</th>
            <th>Foto</th>
            <th>Nombre</th>
            <th>
                <form action="index.php" method="post"><button class="enlace" name="btnNuevo">Usuarios+</button></form>
            </th>
        </tr>
        <?php
        while ($tupla = mysqli_fetch_assoc($resultado_usuarios)) {
            echo "<tr>";
            echo "<td>" . $tupla["id_usuario"] . "</td>";
            echo "<td><img src='Img/" . $tupla["foto"] . "' alt='Foto de perfil' title='Foto de perfil'></td>";
            echo "<td><form action='index.php' method='post'><button title='Ver detalles' class='enlace' name='btnDetalles' value='" . $tupla["id_usuario"] . "'>" . $tupla["nombre"] . "</button></form></td>";
            echo "<td>";
            echo "<form action='index.php' method='post' style='display:inline' onsubmit=\"return confirm('¿Seguro que quieres borrar este usuario?');\"><button class='enlace' name='btnBorrar' value='" . $tupla["id_usuario"] . "'>Borrar</button></form> - ";
            echo "<form action='index.php' method='post' style='display:inline'><button class='enlace' name='btnEditar' value='" . $tupla["id_usuario"] . "'>Editar</button></form>";
            echo "</td>";
            echo "</tr>";
        }

        mysqli_free_result($resultado_usuarios);
        ?>
    </table>
</body>

</html>