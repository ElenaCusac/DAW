create database parqueatracciones;
drop database parqueatracciones;

use parqueatracciones;

-- CREACIÓN DE LA ESTRUCTURA DE LA BASE DE DATOSS
-- Crear la tabla parque
drop table if exists parques;
create table parques (

	codParque int auto_increment not null,
	nombre varchar (40) not null,
	direccion varchar(40) not null,
	ciudad varchar(40) not null,
	metrosCuadrados int not null,
	capacidadMaxima int not null,
	constraint pk_parques primary key (codParque)

);

-- Crear la tabla oficina
drop table if exists oficinas;
create table oficinas (

	codOficina int auto_increment not null,
	direccion varchar (40) not null,
	telefono char(9) not null,
	codParque int not null,
	constraint pk_oficinas primary key (codOficina),
    constraint fk_parques foreign key (codParque) references parques(codParque)
    on delete no action on update cascade

);

-- Crear la tabla cliente
drop table if exists clientes;
create table clientes (

	codCliente int auto_increment not null,
    nombre varchar(40) not null,
    ape1cli varchar(40) not null,
    ape2cli varchar(40) null,
    dni char(9) not null unique,
    fechaNacimiento date not null,
    telefono char(9) not null unique,
    email varchar(40) not null unique,
    codResponsable int null,
    constraint pk_cliente primary key (codCliente),
    constraint fk_cliente foreign key (codResponsable) references clientes(codCliente)
	on delete no action on update cascade
    
);

-- Crear la tabla zonas
drop table if exists zonas;
create table zonas (

	codZona int not null,
    nombre varchar(40) not null,
    descripcion varchar(100) null,
    codParque int not null,
    constraint pk_zonas primary key (codZona, codParque),
    constraint fk_parque foreign key (codParque) references parques(codParque)
	on delete no action on update cascade
    
);

-- Crear la tabla atracciones
drop table if exists atracciones;
create table atracciones (
	codAtraccion int auto_increment not null,
    nombre varchar(40) not null,
    fechaInstalacion date not null,
    descripcion varchar(100) null,
    capacidadMaxima int not null,
    edadMinima int not null,
    codZona int not null,
    codParque int not null,
    constraint pk_atracciones primary key (codAtraccion),
    constraint fk_zona_atracciones foreign key (codZona, codParque) references zonas(codZona, codParque)
	on delete no action on update cascade
    
);

-- Crear la tabla empleados
drop table if exists empleados;
create table empleados (

    codEmpleado int auto_increment not null,
    nombre varchar(40) not null,
    ape1emp varchar(40) not null,
    ape2emp varchar(40) null,
    rol varchar(40) not null,
    horario varchar(40) not null,
    sueldo decimal(10,2) not null,
    dni char(9) not null unique,
    email varchar(40) not null,
    telefono char(9) not null,
    constraint pk_empleados primary key (codEmpleado)

);

-- Crear la tabla detalleEmpleado
drop table if exists detalleEmpleado;
create table detalleEmpleado (

    codDetalle int auto_increment not null,
    codEmpleado int not null,
    codParque int not null,
    fechaInicio date not null,
    fechaFin date null,
    observaciones varchar(100) null,
    constraint pk_detalle primary key (codDetalle),
    constraint fk_detalle_empleado foreign key (codEmpleado) references empleados(codEmpleado)
        on delete cascade on update cascade,
    constraint fk_detalle_parque foreign key (codParque) references parques(codParque)
        on delete cascade on update cascade

);

-- Crear la tabla servicios
drop table if exists servicios;
create table servicios (

    codServicio int auto_increment not null,
    nombre varchar(40) not null,
    descripcion varchar(100) null,
    constraint pk_servicios primary key (codServicio)

);

-- Crear la tabla detalleServicios
drop table if exists detalleServicios;
create table detalleServicios (

	codDetalleServicio int auto_increment not null,
    codCliente int not null,
    codServicio int not null,
    cantidad tinyint null,
    observaciones varchar(100) null,
    constraint pk_detalleServicio primary key (codDetalleServicio),
    constraint fk_detalleservicio_cliente foreign key (codCliente) references clientes(codCliente)
		on delete no action on update cascade,
	constraint fk_servicio foreign key (codServicio) references servicios(codServicio)
		on delete no action on update cascade

);

-- Crear la tabla entradas
drop table if exists entradas;
create table entradas (

    codEntrada int auto_increment not null,
    fecha date not null,
    tipoEntrada enum('individual','grupal','cumpleaños') not null,
    codParque int not null,
    codCliente int not null,
    constraint pk_entradas primary key (codEntrada),
    constraint fk_entrada_parque foreign key (codParque) references parques(codParque)
        on delete cascade on update cascade,
    constraint fk_entrada_cliente foreign key (codCliente) references clientes(codCliente)
        on delete cascade on update cascade

);

-- trigger para controlar que un menor siempre tenga un adulto responsable
delimiter $$

create trigger trg_cliente_menor
before insert on clientes
for each row
begin
    if timestampdiff(year, new.fechaNacimiento, CURDATE()) < 18 then
        if new.codResponsable is null then
            SIGNAL SQLSTATE '45000'
            set message_text = 'Menor sin responsable';
        end if;
    end if;
end$$

delimiter ;

-- Trigger para controlar que una oficina solo tenga a su cargo un único parque a su cargo
delimiter $$ 
create trigger trg_oficina_unica
before insert on oficinas
for each row
begin
    if exists (select 1 from oficinas where codParque = new.codParque) then
        SIGNAL SQLSTATE '45000'
        set message_text = 'Ya existe oficina para este parque';
    end if;
end$$
delimiter ; 

-- Trigger para controlar que la fecha de fin de contrato de un empleado sea correcta
delimiter $$

create trigger trg_fechas_empleado
before insert on detalleEmpleado
for each row
begin
    if new.fechaFin is not null and new.fechaFin < new.fechaInicio then
        SIGNAL SQLSTATE '45000'
        set message_text = 'Fecha fin incorrecta';
    end if;
end$$

delimiter ;