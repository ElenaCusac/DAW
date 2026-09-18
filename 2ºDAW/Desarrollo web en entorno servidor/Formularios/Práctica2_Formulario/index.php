<?php
if(isset($_POST["btnEnviar"]))
{
    //cuando se hace submit compruebo errores formulario
    
    $error_nombre = $_POST["nombre"]=="";
    $error_nacido = !isset($_POST["nacido"]);
    $error_sexo = !isset($_POST["sexo"]);
    $error_aficiones = !isset($_POST["aficiones"]);
    $error_comentarios = $_POST["comentarios"]=="";
  

    $error_formulario = $error_nombre || $error_aficiones || $error_sexo || $error_comentarios;
}

if(isset($_POST["btnEnviar"]) && !$error_formulario)
{
    //Por aquí muestro una nueva de recogida de datos
    require "vistas/vista_recogida.php";
}
else
{
    require "vistas/vista_formulario.php";
}
?>