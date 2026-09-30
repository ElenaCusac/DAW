<?php
$id_editar = $_POST["id_usuario"];
$error_nombre = $_POST["nombre"] == "";
$error_usuario = $_POST["usuario"] == "";
if (!$error_usuario) {
    $error_usuario = repetido($conexion, "usuarios", "usuario", $_POST["usuario"]);
    if (!$error_usuario)
        $error_usuario = false;
    else {
        $consulta = "select id_usuario from usuarios where usuario='" . $_POST["usuario"] . "' and id_usuario<>" . $id_editar;
        $resultado_repetido = mysqli_query($conexion, $consulta);
        $error_usuario = mysqli_num_rows($resultado_repetido) > 0;
        mysqli_free_result($resultado_repetido);
    }
}

$error_clave = $_POST["clave"] == "";
$error_dni = !dni_bien_escrito($_POST["dni"]) || !dni_valido($_POST["dni"]);
if (!$error_dni) {
    $consulta = "select id_usuario from usuarios where dni='" . strtoupper($_POST["dni"]) . "' and id_usuario<>" . $id_editar;
    $resultado_repetido = mysqli_query($conexion, $consulta);
    $error_dni = mysqli_num_rows($resultado_repetido) > 0;
    mysqli_free_result($resultado_repetido);
}
$error_sexo = !isset($_POST["sexo"]);
$error_foto = isset($_FILES["foto"]) && $_FILES["foto"]["name"] != "" && ($_FILES["foto"]["error"] || $_FILES["foto"]["size"] > 500 * 1024 || !tiene_extension($_FILES["foto"]["name"]) || !mi_getimagesize($_FILES["foto"]));
$error_form = $error_nombre || $error_usuario || $error_clave || $error_dni || $error_sexo || $error_foto;

if (!$error_form) {
    try {
        $nombre = $_POST["nombre"];
        $usuario = $_POST["usuario"];
        $dni = strtoupper($_POST["dni"]);
        $sexo = $_POST["sexo"];
        $clave = md5($_POST["clave"]);
        $foto_actual = $_POST["foto_actual"];
        $consulta = "update usuarios set nombre='" . $nombre . "', usuario='" . $usuario . "', clave='" . $clave . "', dni='" . $dni . "', sexo='" . $sexo . "' where id_usuario=" . $id_editar;
        mysqli_query($conexion, $consulta);

        // El nombre de la foto sigue el formato id_usuario_contraseña.extensión.
        // Como la contraseña se almacena con MD5, se utiliza ese valor para no
        // guardar la contraseña original en el nombre del archivo.
        if (isset($_FILES["foto"]) && $_FILES["foto"]["name"] != "") {
            $array_nombre = explode(".", $_FILES["foto"]["name"]);
            $extension = end($array_nombre);
            $nombre_foto = $id_editar . "_" . $clave . "." . $extension;
            if (move_uploaded_file($_FILES["foto"]["tmp_name"], "Img/" . $nombre_foto)) {
                $nombre_foto_bd = $nombre_foto;
                $consulta = "update usuarios set foto='" . $nombre_foto_bd . "' where id_usuario=" . $id_editar;
                mysqli_query($conexion, $consulta);
                if ($foto_actual != "" && $foto_actual != "no_imagen.jpg" && $foto_actual != $nombre_foto && file_exists("Img/" . $foto_actual))
                    unlink("Img/" . $foto_actual);
            } else
                throw new Exception("No se ha podido guardar la imagen subida.");
        }
        $mensaje_accion = "¡¡ Usuario editado correctamente!!";
    } catch (Exception $e) {
        mysqli_close($conexion);
        die(error_page("Práctica 8", "<h1>Práctica 8</h1><p>Error al intentar editar el usuario: " . $e->getMessage() . "</p>"));
    }
}
