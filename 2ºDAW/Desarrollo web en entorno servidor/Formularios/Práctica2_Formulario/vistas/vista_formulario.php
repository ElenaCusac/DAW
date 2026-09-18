<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mi primera página PHP</title>
    <style>
        .error{color:red}
    </style>
</head>
<body>
    <h1>Esta es mi super página</h1>
    <form action="index.php" method="post" enctype="multipart/form-data">
        <p>
            <label for="nombre">Nombre: </label>
            <input type="text" id="nombre" name="nombre" placeholder="Teclee un nombre" value="<?php if(isset($_POST["nombre"])) echo $_POST["nombre"];?>">
            <?php
            if(isset($_POST["btnEnviar"]) && $error_nombre)
                echo "<span class='error'> * Campo obligatorio *</span>";
            ?>
        </p>
        <p>
            <label for="nacido">Nacido en: </label>
            <select name="nacido" id="nacido">
                <option value="Málaga" <?php if(isset($_POST["nacido"]) && $_POST["nacido"]=="Málaga") echo "selected";?>>Málaga</option>
                <option value="Granada" <?php if(isset($_POST["nacido"]) && $_POST["nacido"]=="Granada") echo "selected";?>>Granada</option>
                <option value="Almería" <?php if(isset($_POST["nacido"]) && $_POST["nacido"]=="Almería") echo "selected";?>>Almería</option>
            </select>
        </p>
        <p>
            <label>Sexo: </label>
            <input type="radio" name="sexo" id="hombre" value="Hombre" <?php if(isset($_POST["sexo"]) && $_POST["sexo"]=="Hombre") echo "checked";?>>
            <label for="hombre">Hombre</label>
            <input type="radio" name="sexo" id="mujer" value="Mujer" <?php if(isset($_POST["sexo"]) && $_POST["sexo"]=="Mujer") echo "checked";?>>
            <label for="mujer">Mujer</label>
            <?php
            if(isset($_POST["btnEnviar"]) && $error_sexo)
                echo "<span class='error'> * Debes seleccionar un sexo *</span>";
            ?>
        </p>
        <p>
            <label for="aficiones[]">Aficiones: </label>
            <input type="checkbox" name="aficiones[]" value="deportes" <?php if(isset($_POST["aficiones"]) && in_array("deportes", $_POST["aficiones]"])) echo "checked";?>>Deportes
            <input type="checkbox" name="aficiones[]" value="lectura" <?php if(isset($_POST["aficiones"]) && in_array("lectura", $_POST["aficiones]"])) echo "checked";?>>Lectura
            <input type="checkbox" name="aficiones[]" value="otros" <?php if(isset($_POST["aficiones"]) && in_array("otros", $_POST["aficiones"])) echo "checked";?>>Otros
            <?php
            if(isset($_POST["btnEnviar"]) && $error_aficiones)
                echo "<span class='error'> * Debes seleccionar al menos una afición *</span>";
            ?>
        </p>
        <p>
            <label for="comentarios">Comentarios</label>
            <textarea name="comentarios" id="comentarios" cols="30" rows="4"><?php if(isset($_POST["comentarios"])) echo $_POST["comentarios"];?></textarea>
             <?php
            if(isset($_POST["btnEnviar"]) && $error_comentarios)
                echo "<span class='error'> * Campo Obligatorio*</span>";
            ?>
        </p>
        <p>
            <button type="submit" name="btnEnviar">Enviar</button>
            
        </p>
    </form>
</body>
</html>