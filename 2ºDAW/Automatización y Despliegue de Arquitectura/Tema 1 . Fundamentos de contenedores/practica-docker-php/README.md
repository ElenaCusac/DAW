# Aplicación PHP con Docker y Nginx

## Descripción

Aplicación web desarrollada en PHP y desplegada mediante Docker utilizando Nginx como servidor web y PHP-FPM como procesador de PHP.

El proyecto ha sido desarrollado y probado utilizando Windows 11, WSL2, Ubuntu y Docker.

## Requisitos

- Windows 10/11
- WSL2
- Ubuntu
- Docker
- Navegador web

## Estructura del proyecto

practica-docker-php/
│
├── Dockerfile
├── nginx.conf
├── README.md
│
├── app/
│   └── index.php
│
└── documentos/

## Construcción de la imagen

Desde la carpeta del proyecto:

docker build -t practica-php .

## Ejecución

docker run -d -p 8080:80 --name practica-php practica-php

## Acceso a la aplicación

Abrir en el navegador:

http://localhost:8080

## Comprobar el contenedor

docker ps

## Ver los logs

docker logs practica-php

## Monitorizar el consumo

docker stats practica-php

## Detener el contenedor

docker stop practica-php

## Eliminar el contenedor

docker rm practica-php
