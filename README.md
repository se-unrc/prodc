EL JUEGO DEL PRODE - GRUPO 7
================

En este documento se encuentra la especificación de los requerimientos en la fase de Análisis (SRS),
en el branch master se encuentra el proyecto con los avances desarrollados y testados, el proyecto forma parte de la evaluación para el curso de "Análisis y Diseño de Algoritmos" del Departamento de Computación de la UNRC.

Documento de especificación de requerimientos
---------------

### Introducción
```Este documento es una especificación de requerimientos de software para el juego del prode. En este documento se definirá el alcance del sistema y una descripción específica de los requerimientos.
```
#### 1.1 Propósito
El presente documento describe una descripción detallada de la arquitectura y los requerimientos del sistema, el propósito del proyecto es la creación del juego del prode en el cual los usuarios podrán hacer predicciones para todos los partidos de una determinada liga.

#### 1.2 Alcance
El producto final es una aplicación que permite que un usuario se registre en el sistema para poder realizar predicciones para los partidos que se realizarán en una determinada liga, el sistema podrá mostrar el avance y el puntaje de los usuarios en las fechas en las que se realicen los partidos.
Especificación de requerimientos
Esta sección contiene la descripción detallada de los requerimientos funcionales del sistema.
2.1    Requerimientos Funcionales
2.1.1 Clase Usuario
2.1.1.1 Requerimiento funcional 1.1

ID:RF1
TÍTULO: Registro
DESC: El usuario deberá proporcionar un nombre, un correo, una contraseña y el tipo de usuario (administrador o usuario).
DEP: Ninguna


2.1.1.2 Requerimiento funcional 1.2

ID:RF2
TÍTULO: Inicio de sesión
DESC: Un usuario registrado deberá ser capaz de ingresar a la aplicación correctamente para empezar a jugar.
DEP: RF1

2.1.1.3 Requerimiento funcional 1.3

ID:RF3
TÍTULO: Recuperar contraseña
DESC: El usuario registrado deberá ser capaz de recuperar su contraseña utilizando el correo proporcionado en el registro.
DEP: RF1

2.1.1.4 Requerimiento funcional 1.4

ID:RF4
TÍTULO: Hacer predicciones
DESC: El usuario puede seleccionar las posiciones de los dos primeros puestos cada grupo (A,B,C,etc). Las predicciones además se realizan respondiendo el resultado por local, empate o visitante.
DEP: RF1, RF2

2.1.1.5 Requerimiento funcional 1.5

ID:RF5
TÍTULO: Consultar resultados
DESC: El usuario podrá visualizar la tabla de resultados que se irá actualizando en cada fecha que se haya jugado un partido.
DEP: RF1, RF2, RF4

2.1.1.6 Requerimiento funcional 1.6

ID:RF6
TÍTULO: Consultar Puntos acumulados
DESC: El usuario podrá visualizar la cantidad de puntos que tiene en un determinado momento.
DEP: RF1, RF2, RF4

2.1.1.7 Requerimiento funcional 1.7

ID:RF7
TÍTULO: Consultar ganadores
DESC: El usuario podrá visualizar la lista de usuarios ganadores del juego.
DEP: RF1, RF2, RF4.

2.1.1.8 Requerimiento funcional 1.8

ID:RF8
TÍTULO: Recibir notificaciones
DESC: El usuario recibirá una notificación si es ganador o si no lo es, una vez terminadas todas las fechas y sumando los puntos de los usuarios.
DEP: RF1, RF2, RF4.

2.1.2 Clase Administrador

2.1.2.1 Requerimiento funcional 2.1

ID:RF9
TÍTULO: Carga de lista de partidos
DESC: El administrador realiza la carga de los partidos que se llevan a cabo en una determinada liga.
DEP: RF1, RF2.
