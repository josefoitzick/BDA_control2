# Laboratorio 2 - Bases de datos Avanzadas
## Este laboratorio fue desarrollado por el grupo n°2.
### Integrantes de grupo 2
* Jose Foitzick
* Fernando Iribarra
* Felipe Carrasco
* Gabriel Cabrera
* Ivan Misle

# Herramientas de desarrollo

## Base de datos
* Postgres SQL versión 12
* PgAdmin versión 4
* Visual Studio Code
  
## Backend
* IntelliJ IDEA Ultimate
* JDK versión 17
* Postman

## Frontend
* VUE versión 3
* Nuxt 3

# Guía de Instalación y Ejecución
Esta guía te ayudará a configurar tu entorno de desarrollo para trabajar con IntelliJ IDEA, PostgreSQL, pgAdmin, postgis y ejecutar un proyecto de Vue.js en la carpeta de Front.

## 1. Clonar el repositorio

git clone https://github.com/josefoitzick/BDA_control2.git

## 2. Instalación de IntelliJ IDEA

1. Descarga IntelliJ IDEA desde el sitio web oficial: [Descargar IntelliJ IDEA](https://www.jetbrains.com/idea/download/).

2. Instala IntelliJ IDEA siguiendo las instrucciones específicas para tu sistema operativo.

## 3. Instalación de PostgreSQL y pgAdmin

### 3.1 Instalación de PostgreSQL

1. Descarga PostgreSQL desde el sitio web oficial: [Descargar PostgreSQL](https://www.postgresql.org/download/).

2. Sigue las instrucciones de instalación para tu sistema operativo.

### 3.2 Instalación de pgAdmin

1. Descarga pgAdmin desde el sitio web oficial: [Descargar pgAdmin](https://www.pgadmin.org/download/).

2. Instala pgAdmin siguiendo las instrucciones para tu sistema operativo.

## 5. Crear base de datos y cargar información

### 5.1 Crear base de datos

1. Asegúrate de estar conectado a PostgreSQL con pgAdmin:
   Abre pgAdmin y conéctate a tu servidor PostgreSQL.
   Si aún no tienes una conexión configurada, puedes hacerlo siguiendo las instrucciones de pgAdmin.

2. Selecciona el servidor y la base de datos:
   En el panel izquierdo de pgAdmin, selecciona tu servidor PostgreSQL.
   Luego, selecciona la base de datos en la que deseas ejecutar el script SQL. Si no tienes una base de datos existente, puedes crear una haciendo clic derecho en "Databases" y seleccionando "Create" > "Database".

3. Ejecuta el Script SQL:
   Haz clic con el botón derecho en la base de datos seleccionada y elige "Query Tool" para abrir una ventana donde podrás ejecutar consultas SQL.

4. En la ventana del "Query Tool", abre el archivo SQL que contiene el script que deseas ejecutar. Puedes hacerlo seleccionando "File" > "Open" y navegando hasta el archivo, en este caso siendo "dbCreate.sql" dentro de la carpeta "Database".

5. Una vez abierto el archivo SQL, puedes ejecutarlo haciendo clic en el botón "Execute" o presionando la tecla F5.

6. Verifica la creación de la base de datos:
   Después de ejecutar el script, verifica que la base de datos y las tablas se hayan creado correctamente utilizando las funciones de pgAdmin.

### 5.2 Cargar la información

1. Abre pgAdmin y conéctate a tu servidor PostgreSQL.

2. Selecciona la base de datos en la que deseas cargar los datos.

3. Abre el "Query Tool" haciendo clic con el botón derecho en la base de datos seleccionada y elige "Query Tool".

4. Abre tu archivo SQL que contiene el script para cargar datos utilizando la opción "File" > "Open" en la ventana del "Query Tool", en este caso siendo "loadData.sql" dentro de la carpeta "Database".

5. Ejecuta el script SQL haciendo clic en el botón "Execute" o presionando la tecla `F5`.

### 5.3 Verificar la Carga de Datos

Después de ejecutar el script, verifica que los datos se hayan cargado correctamente en las tablas correspondientes. Puedes hacerlo consultando las tablas o ejecutando consultas SELECT para verificar que los datos estén presentes.

¡Listo! Ahora estás preparado para cargar datos en tu base de datos PostgreSQL desde un script SQL.


## 6. Ejecución de un Proyecto de Vue.js

Frontend:

1. Abre VSC -> open folder -> selecciona frontend
2. Ejecuta npm run dev
   Nota: En el front end las ventanas de login y register estan completas, lo demas no fue logrado.
   
## 7. Ejecución del Proyecto desde IntelliJ IDEA

1. Abre IntelliJ IDEA y abre tu proyecto de Nuxt.js en la carpeta de frontend.

2. Asegúrate de que todas las dependencias de tu proyecto estén instaladas. Puedes hacerlo ejecutando `npm install` desde la terminal en la carpeta de tu proyecto.

3. Inicia el servidor de desarrollo de Vue.js ejecutando `npm run dev` desde la terminal en la carpeta de tu proyecto.

4. Abre tu navegador web y accede a la URL proporcionada por el servidor de desarrollo (generalmente, [http://localhost:5173/](http://localhost:5173/)) para ver tu proyecto en funcionamiento.

¡Listo! Ahora estás preparado para cargar datos en tu base de datos PostgreSQL desde un script SQL y ejecutar tu proyecto Vue.js desde IntelliJ IDEA.
