<?php
try {
    $id_borrar = $_POST["btnBorrar"];
    $consulta = "select foto from usuarios where id_usuario=" . $id_borrar;
    $resultado_foto = mysqli_query($conexion, $consulta);
    $datos_foto = mysqli_fetch_assoc($resultado_foto);
    mysqli_free_result($resultado_foto);

    $consulta = "delete from usuarios where id_usuario=" . $id_borrar;
    mysqli_query($conexion, $consulta);

    if ($datos_foto) {
        if ($datos_foto && $datos_foto["foto"] != "" && $datos_foto["foto"] != "no_imagen.jpg" && file_exists("Img/" . $datos_foto["foto"]))
            unlink("Img/" . $datos_foto["foto"]);
        $mensaje_accion = "¡¡ Usuario borrado correctamente!!";
    } else
        $mensaje_accion = "No se ha podido borrar el usuario porque ya no existe.";
} catch (Exception $e) {
    mysqli_close($conexion);
    die(error_page("Práctica 8", "<h1>Práctica 8</h1><p>Error al intentar borrar el usuario: " . $e->getMessage() . "</p>"));
}
