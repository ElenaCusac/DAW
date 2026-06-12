use parqueatracciones;

-- Insertar datos en la tabla de parques
drop procedure if exists insertarParque;
delimiter $$

create procedure insertarParque(nombre varchar(40), in direccion varchar(40), in ciudad varchar(40), in metros int, in capacidad int)
begin
    insert into parques 
		(nombre, direccion, ciudad, metrosCuadrados, capacidadMaxima)
    values 
        (nombre, direccion, ciudad, metros, capacidad);
	
end$$

delimiter ;

call insertarParque('Parque Aventura', 'Calle 1', 'Madrid', 5000, 1000);
call insertarParque('Diversion Park', 'Calle 2', 'Barcelona', 6000, 1200);
call insertarParque('Magic World', 'Calle 3', 'Valencia', 7000, 1500);
call insertarParque('FunLand', 'Calle 4', 'Sevilla', 5500, 1100);
call insertarParque('AquaPark', 'Calle 5', 'Málaga', 8000, 2000);

-- Insertar datos en la tabla de clientes
drop procedure if exists insertarCliente;
delimiter $$

create procedure insertarCliente(nombre varchar(40), ape1 varchar(40), ape2 varchar(40), dni char(9), fecha date,  telefono char(9), email varchar(40), responsable int)
begin
    insert into clientes
        (nombre, ape1cli, ape2cli, dni, fechaNacimiento, telefono, email, codResponsable)
    values
        (nombre, ape1, ape2, dni, fecha, telefono, email, responsable);
end$$

delimiter ;

call insertarCliente('Juan', 'Perez', 'Lopez', '11111111A', '1990-01-01', '600000001', 'juan@mail.com', null);
call insertarCliente('Ana', 'Gomez', 'Ruiz', '22222222B', '1985-05-05', '600000002', 'ana@mail.com', null);
call insertarCliente('Luis', 'Diaz', 'Soto', '33333333C', '2015-03-10', '600000003', 'luis@mail.com', 1);
call insertarCliente('Maria', 'Lopez', 'Gil', '44444444D', '2012-07-20', '600000004', 'maria@mail.com', 2);
call insertarCliente('Carlos', 'Navarro', 'Rey', '55555555E', '2000-09-15', '600000005', 'carlos@mail.com', null);

delimiter $$

-- Insertar datos en la tabla de empleados
drop procedure if exists insertarEmpleado;
delimiter $$

create procedure insertarEmpleado(nombre varchar(40), ape1 varchar(40), ape2 varchar(40), rol varchar(40), horario varchar(40), sueldo decimal(10,2), dni char(9), email varchar(40), telefono char(9))
begin
    insert into empleados
        (nombre, ape1emp, ape2emp, rol, horario, sueldo, dni, email, telefono)
    values
        (nombre, ape1, ape2, rol, horario, sueldo, dni, email, telefono);
end$$

delimiter ;

call insertarEmpleado('Luis', 'Martinez', 'Lopez', 'Mantenimiento', 'Mañana', 1500, '11111111X', 'luis@emp.com', '600111111');
call insertarEmpleado('Sara', 'Perez', 'Diaz', 'Recepcion', 'Tarde', 1400, '22222222X', 'sara@emp.com', '600222222');
call insertarEmpleado('Carlos', 'Ruiz', 'Gil', 'Limpieza', 'Noche', 1200, '33333333X', 'carlos@emp.com', '600333333');
call insertarEmpleado('Ana', 'Sanchez', 'Lopez', 'Monitor', 'Mañana', 1300, '44444444X', 'ana@emp.com', '600444444');
call insertarEmpleado('Pedro', 'Navarro', 'Rey', 'Seguridad', 'Noche', 1600, '55555555X','pedro@emp.com', '600555555');

-- Insertar datos en la tabla de detalles empleado
drop procedure if exists insertarDetalleEmpleado;

delimiter $$
create procedure insertarDetalleEmpleado(codEmpleado int, codParque int, fechaInicio date, fechaFin date, observaciones varchar(100))
begin
    insert into detalleEmpleado
        (codEmpleado, codParque, fechaInicio, fechaFin, observaciones)
    values
        (codEmpleado, codParque, fechaInicio, fechaFin, observaciones);
end$$

delimiter ;
call insertarDetalleEmpleado(1, 1, '2024-01-01', null, null);
call insertarDetalleEmpleado(2, 2, '2024-02-01', null, null);
call insertarDetalleEmpleado(3, 3, '2024-03-01', null, null);
call insertarDetalleEmpleado(4, 4,'2024-04-01', null, null);
call insertarDetalleEmpleado(5, 5,'2024-05-01', null, null);

-- Insertar datos en la tabla de zonas
drop procedure if exists insertarZona;
delimiter $$

create procedure insertarZona(nombre varchar(40),  descripcion varchar(100),  codigoParque int)
begin

	declare nuevoCodZona int;
    
    select ifnull(max(codZona), 0) + 1
    into nuevoCodZona
    from zonas
    where codParque = codigoParque; 

    insert into zonas
        (codzona, nombre, descripcion, codParque)
    values
        (nuevoCodZona, nombre, descripcion, codigoParque);
end$$

delimiter ;
call insertarZona('Infantil', 'Zona niños', 1);
call insertarZona('Acuatica', 'Zona agua', 2);
call insertarZona('Extrema', 'Zona adrenalina', 3);
call insertarZona('Familiar', 'Zona familiar', 4);
call insertarZona('Relax', 'Zona tranquila', 5);

-- Insertar datos en la tabla de atracciones
drop procedure if exists insertarAtraccion;
delimiter $$

create procedure insertarAtraccion(nombre varchar(40), fecha date, descripcion varchar(100), capacidad int, edad int, codigoZona int, codigoParque int)
begin
    insert into atracciones
        (nombre, fechaInstalacion, descripcion, capacidadMaxima, edadMinima, codZona, codParque)
    values
        (nombre, fecha, descripcion, capacidad, edad, codigoZona, codigoParque);
end$$

delimiter ;
call insertarAtraccion('Montaña Rusa', '2020-01-01', 'Alta velocidad', 50, 12, 1, 1);
call insertarAtraccion('Tobogan', '2019-06-01', 'Agua', 30, 5, 1, 2);
call insertarAtraccion('Caida Libre', '2021-03-01', 'Extrema', 20, 16, 1, 3);
call insertarAtraccion('Carrusel', '2018-08-01', 'Infantil', 25, 3, 1, 4);
call insertarAtraccion('Rio Lento', '2022-05-01', 'Relax', 40, 0, 1, 5);

-- Insertar datos en la tabla de oficinas
drop procedure if exists insertarOficina;
delimiter $$

create procedure insertarOficina(direccion varchar(40), telefono char(9), codParque int)
begin
    insert into oficinas
        (direccion, telefono, codParque)
    values
        (direccion, telefono, codParque);
end$$

delimiter ;

call insertarOficina('Oficina 1', '111111111', 1);
call insertarOficina('Oficina 2', '222222222', 2);
call insertarOficina('Oficina 3', '333333333', 3);
call insertarOficina('Oficina 4', '444444444', 4);
call insertarOficina('Oficina 5', '555555555', 5);

-- Insertar datos en la tabla de entradas
drop procedure if exists insertarEntrada;
delimiter $$

create procedure insertarEntrada(fecha date, tipo varchar(20), codParque int, codCliente int)
begin

	if tipo not in('individual','grupal','cumpleaños') then
        SIGNAL SQLSTATE '45000'
        set message_text = 'Tipo de entrada no válido';
    end if;

    insert into entradas
        (fecha, tipoEntrada, codParque, codCliente)
    values
        (fecha, tipo, codParque, codCliente);
end$$

delimiter ;
call insertarEntrada('2025-06-01', 'individual', 1, 1);
call insertarEntrada('2025-06-01', 'cumpleaños', 1, 2);
call insertarEntrada('2025-06-02', 'grupal', 2, 3);
call insertarEntrada('2025-06-03', 'cumpleaños', 3, 4);
call insertarEntrada('2025-06-04', 'individual', 4, 5);

-- servicios
drop procedure if exists insertarServicio;
delimiter $$

create procedure insertarServicio(nombre varchar(40), descripcion varchar(100))
begin
    insert into servicios
        (nombre, descripcion)
    values
        (nombre, descripcion);
end$$

delimiter ;

call insertarServicio('Comida', 'Servicio de catering');
call insertarServicio('Taquilla', 'Guardar objetos');
call insertarServicio('Animacion', 'Espectaculos');
call insertarServicio('Fotografia', 'Fotos del evento');
call insertarServicio('VIP', 'Acceso exclusivo');

-- Insertar datos en la tabla de detalleServicios
drop procedure if exists insertarDetalleServicios;
delimiter $$

create procedure insertarDetalleServicios(codigoCliente int, codigoServicio int, cant tinyint, observ varchar(100))
begin 

	insert into detalleServicios
		(codCliente, codServicio, cantidad, observaciones)
	values 
		(codigoCliente, codigoServicio, cant, observ);

end $$

delimiter ;

call insertarDetalleServicios(1,1, 1, null);
call insertarDetalleServicios(1, 2, 2, "Una de las taquillas debe de ser una grande");
call insertarDetalleServicios(2, 3, 1, "La animación será para niños con necesidades especiales");
call insertarDetalleServicios(5, 5, 1, null);
call insertarDetalleServicios(5, 4, 1, null);