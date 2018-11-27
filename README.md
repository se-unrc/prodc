# EL JUEGO DEL PRODE - GRUPO 7

En este documento se encuentra la especificación de los requerimientos en la fase de Análisis (SRS),
en el branch master se encuentra el proyecto con los avances desarrollados y testados, el proyecto forma parte de la evaluación para el curso de "Análisis y Diseño de Algoritmos" del Departamento de Computación de la UNRC.

## Estructura

```
└── src
    ├── main
    │   ├── java
    │   │   ├── Controllers
    │   │   ├── prode
    │   │   └── Services
    │   ├── resources
    │   │   ├── public
    │   │   │   ├── css
    │   │   │   ├── images
    │   │   │   └── js
    │   │   └── templates
    │   │       └── Dashboard
    │   └── seeds
    ├── migrations
    └── test
        └── java
            └── prode
```

### Instalación --IMPORTANTE-- (REALIZAR PASO A PASO)
1) Cambiar las credenciales de Mysql (user y password)
2) Crear las tablas/resetear mvn db-migrator:reset
3) Ejecutar los scripts gamesSeeds y teamsSeeds que se encuentran en la carpeta Seeds/

### Ejecución
1) Ejecutar en consola el archivo ./run.sh
2) Ingresar a la dirección http://localhost:1112
3) Administrador: user->admin pass->123 (Fue insertado en los scripts del paso anterior)
4) Registrarse/Ingresar para poder jugar

### Consideraciones -- IMPORTANTE --
1) Los usuarios se registran antes de que el administrador empiece a completar los resultados, caso contrario no se contarán sus puntajes en la pestaña de resultados.

## Jugar
La manera de predecir es completando los partidos con los equipos que supones que van a jugar en el mismo, si resultan ser los que realmente juegan sumara puntos.

### Usuario
1) El usuario tiene que registrarse
2) El usuario tiene que loguearse
3) En la página principal se realizan las predicciones haciendo click en los botones de Octavos - Cuartos - Semifinales y Final
4) El usuario puede consultar los resultados inmediatamente después de que el administrador ingrese los datos de un juego.
5) El usuario puede consultar los equipos que juegan en el mundial.
6) El usuario puede consultar los juegos que fueron jugados hasta el momento (ingresados por el administrador).

### Administrador
1) El administrador debe de loguearse con las siguientes credenciales (user-> admin pass->123)
2) El administrador debe de ingresar los juegos que han sido jugados hasta el momento para poder actualizar los puntajes de los usuarios.
3) TODOS LOS USUARIOS DEBEN DE HABERSE REGISTRADO ANTES DE QUE EL ADMINISTRADOR COMIENCE CON LA CARGA DE LA DATA

Ambos usuarios pueden cerrar sesión.
