<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejemplo de forulario</title>
</head>
<body>
    <h1>Rellena tu CV</h1>
    <form action="index.php" method="get" enctype="multipart/form-data">
        <label for="nombre">Nombre</label><br>
        <input type="text" id="nombre" name="nombre" placeholder="Teclee el nombre"><br>

        <label for="apellidos">Apellidos</label><br>
        <input type="text" id="apellidos" name="apellidos" placeholder="Teclee los apellidos"><br>

        <label for="password">Contraseña</label><br>
        <input type="password" id="password" name="password"><br>

        <label for="dni">DNI</label><br>
        <input type="text" id="dni" name="dni"><br>

        <label>Sexo</label><br>
        <input type="radio" id="hombre" name="sexo" value="hombre">
        <label for="hombre">Hombre</label><br>

        <input type="radio" id="Mujer" name="sexo" value="mujer">
        <label for="mujer">Mujer</label><br><br>

        <label for="foto">Incluir mi foto: </label>
        <input type="file" id="foto" name="foto" accept="image/"><br><br>

        <label for="nombre">Nacido en: </label>
        <select id="nacido" name="nacido">
            <option selected value="MA">Málaga</option>
            <option value="GR">Granada</option>
            <option value="SE">Sevilla</option>
        </select><br><br>

        <label for="mensaje">Comentarios: </label>
        <textarea id="mensaje" name="mensaje" rows="4" cols="25"></textarea><br><br>

        <input type="checkbox" id="subscripcion" checked name="subscripcion">
        <label for="subscripcion">Subscribirse al boletín de Novedades</label><br><br>

        <button type="submit">Guardar cambios</button>
        <button type="reset">Borrar los datos introducidos</button>
    </form>
</body>
</html>