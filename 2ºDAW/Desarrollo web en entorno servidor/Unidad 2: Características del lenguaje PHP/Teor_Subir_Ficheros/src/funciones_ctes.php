<?php

function tiene_extension($name)
{
    $extension=false;
    $array=explode(".", $name);
    if(count($array)>1)
        $extension=end($array);

    return $extension;
}

function mi_getimagesize($info_foto)
{
    $respuesta=false;
    if($info_foto["size"]>0)
        $respuesta=getimagesize($info_foto["tmp_name"]);

    return $respuesta;
}
?>