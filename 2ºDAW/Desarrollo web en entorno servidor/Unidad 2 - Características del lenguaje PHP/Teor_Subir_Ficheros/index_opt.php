<?php
require "src/funciones_ctes.php";



if(isset($_POST["btnEnviar"]))
{
    //Compruebo los errores


    $error_foto= $_FILES["foto"]["name"]==!"" && ( $_FILES["foto"]["error"] || $_FILES["foto"]["size"] >500*1024 || !tiene_extension($_FILES["foto"]["name"]) || !mi_getimagesize($_FILES["foto"]));

}

if(isset($_POST["btnEnviar"]) && $_FILES["foto"]["name"]==!"" && !$error_foto)
{
    require "vistas/vista_info_foto.php";
}
else
{
    require "vistas/vista_formulario_opt.php";

}
?>
