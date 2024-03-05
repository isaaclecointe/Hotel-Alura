# Challenge ONE | Java | Back-end | Hotel Alura

<p align="center" >
     <img width="300" heigth="300" src="https://user-images.githubusercontent.com/91544872/189419040-c093db78-c970-4960-8aca-ffcc11f7ffaf.png">
</p>

---

#### 🔹 ¡Visita la página del desafío haciendo clic aquí! [Link do Challenge](https://www.aluracursos.com/challenges/oracle-one-back-end/hotelalura) 📃
</br>

## 🖥️ Tecnologías Utilizadas:

- Java
- Eclipse
- Biblioteca JCalendar
- PostgreSQL
- Imagenes generadas por IA
- Plugin WindowBuilder </br>

---
 La interfaz contiene dos métodos importantes:
- setResizable(false): determina el tamaño de la ventana, y a través del parámetro <strong>false</strong>, la pantalla no se puede maximizar;
- setLocationRelativeTo(null): determina la ubicación de la ventana, y a través del parámetro <strong>null</strong> la mantiene centrada en la pantalla.
- 
---

## 🔍 ¡Analizando nuestro repositorio!

### Este es el repositorio de mi proyecto, en el encontrarás:
#### 🔹 src/views: carpeta con toda la interfaz gráfica de las pantallas necesarias para el programa;
#### 🔹 src/imagenes: carpeta con imágenes las imagenes que coforman el programa del hotel;
</br>




## 1 -Para la interfaz grafica usamos el plugin Window Builder y al correr el programa esta sera la primera ventana que veras.  </br>
####    🔹Contiene una Imagen generada por IA.
####    🔹Boton de Login que lleva a la ventana de Login.
####    🔹Boton de Salir con confirmacion si desea salir del programa.

<p align="center" >
     <img width="800" heigth="800" src="https://github.com/isaaclecointe/Hotel-Alura/assets/121967392/b331dd60-bfd4-43f8-aa4b-ee30c500d570">
</p>

## 1.1 - Ventana de Login para el usuario empleado del hotel. </br>
####    🔹Contiene  un campo para ingresar el nombre del usuario.
####    🔹Campo para ingresar la contraseña correspondiente.
####    🔹Boton en la esquina superior izquierda que lleva de regreso a la primera ventana de recepcion.
####    🔹Boton en la esquina superior derecha que cierra la aplicacion. 
####    🔹Boton para entrar "iniciar sesion" que lleva a la siguiente ventana del Menu de Usuario.
####    🔹Si la Contraseña o el usuario ingresado no son validos  lanzara un mensaje de error al usuario.

<p align="center" >
     <img width="800" heigth="800" src="https://github.com/isaaclecointe/Hotel-Alura/assets/121967392/83a362b0-78fb-4c34-ba54-eeef59eef2e5">
</p>

## 1.2 - Ventana de Menu de Usuario aqui controle y administre el flujo de reservas del hotel. </br>
####    🔹Contiene una barra con la fecha del dia de actual cuando ingrese, esto gracias a la libreria JCalendar.
####    🔹Contiene unas Instrucciones de como gestionar el sistema de forma optima y de las opciones que este ofrece.
####    🔹Un boton de registro de reservas que lleva a la ventana de reservas.
####    🔹Un boton de busqueda que lleva a la ventana de busqueda de las reservas y Huespedes.
####    🔹Un boton de cerrar sesion que nos lleva de regreso a la ventana de Login.

<p align="center" >
     <img width="800" heigth="800" src="https://github.com/isaaclecointe/Hotel-Alura/assets/121967392/71d5cc38-364d-485d-a782-a5cd178cfa63">
</p></br>

 ## 1.3 - Ventana de registro de reservas </br>
 ####    🔹Contiene el campo de fecha de entrada donde al dar click se abre un calendario desplegable donde se elije la fecha de inicio de la reserva.
 ####    🔹Campo de la fecha de salida  tambien con calendario desplegable para elejir la fecha que desees que finalize la reserva.
 ####    🔹Campo que muestra el valor de la reserva en funcion de la fecha de entrada  a la fecha de salida.
 ####    🔹Forma de pago campo desplegable con multiples opciones de pago: Tarjeta de Credito, Debito o efectivo.
 ####    🔹Boton "siguiente" que genera el id de la reserva y lanza un mensaje con el numero de id generado y que lleva a la siguiente ventana de registro de huesped.
 
<p align="center" >
     <img width="800" heigth="800" src="https://github.com/isaaclecointe/Hotel-Alura/assets/121967392/4670aa7e-d366-479f-bb55-e68d5d1f6825">
</p>

## 1.4 - Ventana de Registro Huesped. </br>
####    🔹Contiene campos para Nombre y Apellido.
####    🔹Campo para fecha de nacimiento con calendario desplegable para elijir el mes, año y dia.
####    🔹Campo desplegable para la nacionalidad con opcion de multitud de paises.
####    🔹Campo del numero de telefono del huesped.
####    🔹Campo que contiene el id unico generado de la reserva.
####    🔹Boton de guardar la reserva realizada.

<p align="center" >
     <img width="800" heigth="800" src="https://github.com/isaaclecointe/Hotel-Alura/assets/121967392/80e5126f-e89e-4015-ba45-3ac84632d3df">
</p>

## 1.5 - Ventana emergente de Datos guardados satisfactoriamente con opcion de cancelar la reserva. </br>

<p align="center" >
     <img width="800" heigth="800" src="https://github.com/isaaclecointe/Hotel-Alura/assets/121967392/da9b3d74-7fcb-4973-b829-43d7c56b16ab">
</p>

## 1.6 - Ventana de Busqueda y gestion de la reservas. </br>
####    🔹Contiene dos modelos de tablas, Reservas y Huespedes con solo un click en la pestaña de cada tabla puedes cambiar a la tabla que desees.
####    🔹Contiene un campo de busqueda y un boton que tiene como imagen una lupa para realizar la busqueda deseada.
####    🔹Contiene un boton de editar, para editar se da doble click en el campo que desea realizar el cambio y despues de hacer el cambio da click en el boton editar lanzara un mensaje si fue exitoso y tambien si ocurrio algun tipo de error.
####    🔹Contiene un boton de eliminar, para eliminar solo selecciona el registro o huesped que desea y da click en eliminar pedira una confimacion y tambien puede cancelar.
####    🔹En esta imagen se hace una busqueda de todos los registros sin ingresar nada en el campo de texto. Cuando no se ingresa nada en el campo de texto y se da click en la lupa  automaticamente traera todas las reservas y huespedes.

<p align="center" >
     <img width="800" heigth="800" src="https://github.com/isaaclecointe/Hotel-Alura/assets/121967392/7246da92-86ea-49b8-adef-b30b3521750f">
</p>

## 1.7 - Busqueda por ID. Cuando ingresa el id de la reserva traera esa reserva unicamente tanto a la tabla reservas como  el huesped correspondiente a la tabla huespedes. </br>

<p align="center" >
     <img width="800" heigth="800" src="https://github.com/isaaclecointe/Hotel-Alura/assets/121967392/2f60ee6a-d0a2-4509-9346-9980bdde8fac">
</p>

## 1.8 - Busqueda por apellido. Cuando se busca por el apellido del huesped traera unicamente a ese huesped a la tabla y su reserva correspondiente en la tabla Reservas. </br>

<p align="center" >
     <img width="800" heigth="800" src="https://github.com/isaaclecointe/Hotel-Alura/assets/121967392/dcbc942b-03ed-4107-b9c0-bf73cf11cbbf">
</p>

## 1.9 - Editar y Actualizar. Cuando se hace la edicion y se da click en el boton de editar lanza este mensaje de registro actualizado correctamente y tambien si algo salio mal. </br>

<p align="center" >
     <img width="800" heigth="800" src="https://github.com/isaaclecointe/Hotel-Alura/assets/121967392/e1a4e53e-ddc2-403e-b4c6-1b35b8e91204">
</p>

## 2 - Eliminar registro. Al eliminar el registro seleccionado lanzara un mensaje pidiendo una confirmacion. </br>

<p align="center" >
     <img width="800" heigth="800" src="https://github.com/isaaclecointe/Hotel-Alura/assets/121967392/eec3fcfe-cedd-4195-98fc-4e4853ef588a">     
</p>

## 2.1 - Eliminar registro. Despues de la confirmacion el registro sera eliminado. </br>

<p align="center" >
     <img width="800" heigth="800" src="https://github.com/isaaclecointe/Hotel-Alura/assets/121967392/c8b0d8da-6f01-4162-828d-01e41b5eb257">
</p>


## 📊 Base de Datos

##2.2 - Diagrama de la Base de Datos relacional en PostgreSQL. 

<p align="center" >
     <img width="800" heigth="800" src="https://github.com/isaaclecointe/Hotel-Alura/assets/121967392/c102b7a2-e95a-4b89-a94f-da4dda33c137">
</p>


## 🗔 Plugin WindowBuilder


🧡 <strong>Oracle</strong></br>
<a href="https://www.linkedin.com/company/oracle/" target="_blank">
<img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>

💙 <strong>Alura Latam</strong></br>
<a href="https://www.linkedin.com/company/alura-latam/mycompany/" target="_blank">
<img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>
