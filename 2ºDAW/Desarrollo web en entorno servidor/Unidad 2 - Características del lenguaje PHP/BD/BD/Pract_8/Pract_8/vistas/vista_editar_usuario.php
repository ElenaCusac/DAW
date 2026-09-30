<h2>Editar usuario</h2>
<form action="index.php" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id_usuario" value="<?php echo (int)$usuario_editar["id_usuario"]; ?>">
    <input type="hidden" name="foto_actual" value="<?php echo htmlspecialchars($usuario_editar["foto"], ENT_QUOTES, "UTF-8"); ?>">
    <p>
        <label for="usuario">Usuario</label><br>
        <input type="text" id="usuario" name="usuario" value="<?php echo htmlspecialchars($val_usuario, ENT_QUOTES, "UTF-8"); ?>">
        <?php if (isset($_POST["btnContEditar"]) && $error_usuario) echo "<span class='error'> * Campo obligatorio o usuario ya en uso *</span>"; ?>
    </p>
    <p>
        <label for="clave">Contraseña</label><br>
        <input type="password" id="clave" name="clave">
        <?php if (isset($_POST["btnContEditar"]) && $error_clave) echo "<span class='error'> * Campo obligatorio *</span>"; ?>
    </p>
    <p>
        <label for="nombre">Nombre</label><br>
        <input type="text" id="nombre" name="nombre" value="<?php echo htmlspecialchars($val_nombre, ENT_QUOTES, "UTF-8"); ?>">
        <?php if (isset($_POST["btnContEditar"]) && $error_nombre) echo "<span class='error'> * Campo obligatorio *</span>"; ?>
    </p>
    <p>
        <label for="dni">DNI</label><br>
        <input type="text" id="dni" name="dni" value="<?php echo htmlspecialchars($val_dni, ENT_QUOTES, "UTF-8"); ?>">
        <?php
        if (isset($_POST["btnContEditar"]) && $error_dni) {
            if (!dni_bien_escrito($_POST["dni"])) echo "<span class='error'> * DNI no está bien escrito *</span>";
            elseif (!dni_valido($_POST["dni"])) echo "<span class='error'> * DNI no es válido *</span>";
            else echo "<span class='error'> * DNI repetido *</span>";
        }
        ?>
    </p>
    <p>
        <label>Sexo</label><br>
        <input type="radio" name="sexo" id="hombre" value="Hombre" <?php if ($val_sexo == "Hombre") echo "checked"; ?>>
        <label for="hombre">Hombre</label><br>
        <input type="radio" name="sexo" id="mujer" value="Mujer" <?php if ($val_sexo == "Mujer") echo "checked"; ?>>
        <label for="mujer">Mujer</label>
        <?php if (isset($_POST["btnContEditar"]) && $error_sexo) echo "<span class='error'> * Debes seleccionar un sexo *</span>"; ?>
    </p>
    <p>
        <label for="archivo">Cambiar foto (opcional, imagen de máximo 500KB)</label>
        <input type="file" id="archivo" name="foto" accept="image/*">
        <?php
        if (isset($_POST["btnContEditar"]) && $error_foto) {
            if ($_FILES["foto"]["error"]) echo "<span class='error'> * Error en la subida del fichero al servidor *</span>";
            elseif (!tiene_extension($_FILES["foto"]["name"])) echo "<span class='error'> * El fichero seleccionado no tiene extensión *</span>";
            elseif (!mi_getimagesize($_FILES["foto"])) echo "<span class='error'> * El archivo seleccionado no es una imagen *</span>";
            else echo "<span class='error'> * El archivo seleccionado supera los 500KB *</span>";
        }
        ?>
    </p>
    <p>
        <button type="submit" name="btnContEditar">Guardar Cambios</button>
        <button type="submit">Atrás</button>
    </p>
</form>