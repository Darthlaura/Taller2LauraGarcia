# Taller 2 de Programación Orientada a Objetos
Integrante

- Integrante 1: Laura García  
- RUT: 26.427.429-K  
- Usuario GitHub: Darthlaura  


Descripción del taller

El Taller 2 de Programación Orientada a Objetos consistía en desarrollar un juego por consola inspirado en Pokémon. La idea principal era crear una aplicación donde el jugador pudiera iniciar una nueva partida, salir a capturar Pokémon, formar un equipo, combatir contra líderes de gimnasio, desafiar al Alto Mando y guardar su progreso en un archivo `.txt`.

Al comenzar una nueva partida, el jugador inicia con cero medallas. A medida que derrota líderes de gimnasio, la cantidad de medallas va aumentando. Además, el jugador puede salir a capturar Pokémon en distintos hábitats. Dentro del hábitat seleccionado, aparece un Pokémon de forma aleatoria utilizando la clase `Random`.

En este taller se trabajó con Programación Orientada a Objetos, lectura y escritura de archivos, listas dinámicas, herencia, encapsulamiento y control de errores.


Librerías y clases importadas utilizadas

En el proyecto se utilizaron distintas clases de Java:

- ArrayList: se utilizó para crear listas dinámicas de objetos, como la lista de Pokémon, hábitats, gimnasios y miembros del Alto Mando.
- Scanner: se utilizó para pedir datos por teclado y también para leer archivos de texto.
- Random: se utilizó para generar un Pokémon aleatorio dentro del hábitat seleccionado por el jugador.
- File: se utilizó para representar y abrir archivos dentro del programa.
- FileNotFoundException: se utilizó para controlar errores cuando un archivo no existe o no puede abrirse correctamente.
- BufferedWriter: se utilizó para escribir texto dentro del archivo `Registros.txt`.
- FileWriter: se utilizó para abrir o crear el archivo donde se escriben los datos de la partida.
- IOException: se utilizó para controlar errores de entrada y salida de datos, especialmente al guardar información en archivos.



Uso de herencia

Para el desarrollo del taller se utilizó herencia, lo que permitió reutilizar atributos y comportamientos comunes entre distintas clases.

La clase padre es:

- Entrenador

Las clases hijas son:

- Jugador
- LiderGimnasio
- AltoMando

La clase `Entrenador` contiene atributos comunes, como el nombre y la lista de Pokémon. Luego, cada clase hija agrega sus propios atributos y métodos según su función dentro del juego.


-Clasificación de clases del proyecto
-Clases principales de objetos

- Pokemon: representa a cada Pokémon del juego, con sus estadísticas, tipo, hábitat, porcentaje de aparición y estado.
- Habitat: representa las zonas donde pueden aparecer Pokémon.

Clases relacionadas con entrenadores

- Entrenador: clase padre que representa características comunes de un entrenador.
- Jugador: representa al jugador principal y almacena su cantidad de medallas y Pokémon capturados.
- LiderGimnasio: representa a los líderes de gimnasio.
- AltoMando: representa a los miembros del Alto Mando.

Clases de control y apoyo

- Main: contiene el flujo principal del programa, los menús y las llamadas a las distintas funcionalidades.
- GestorArchivo: se encarga de leer y escribir archivos .txt.
- TablaTipos: contiene la matriz de efectividad de tipos Pokémon.



Archivos utilizados

El programa utiliza archivos .txt para cargar y guardar información.

pokedex.txt

Contiene todos los Pokémon disponibles en el juego, junto con sus estadísticas, hábitat, porcentaje de aparición y tipo.

habitat.txt

Contiene las zonas disponibles para salir a capturar Pokémon.

gimnasios.txt

Contiene la información de los líderes de gimnasio, su estado y los Pokémon que utilizan.

altoMando.txt

Contiene la información de los miembros del Alto Mando y sus Pokémon.

Registros.txt

Contiene la partida guardada del jugador. Aquí se almacena el nombre del jugador, la cantidad de medallas y los Pokémon capturados con su estado.



Funcionalidades implementadas

El programa permite realizar las siguientes acciones:

1. Continuar partida: carga los datos guardados desde `Registros.txt`.
2. Nueva partida: crea un nuevo jugador y sobrescribe el archivo de registros.
3. Revisar equipo: muestra los primeros 6 Pokémon del jugador.
4. Salir a capturar: permite elegir un hábitat y capturar un Pokémon aleatorio.
5. Acceso al PC: permite intercambiar posiciones entre Pokémon capturados.
6. Retar gimnasio: permite combatir contra líderes de gimnasio de forma progresiva.
7. Desafiar Alto Mando: permite combatir contra el Alto Mando si el jugador tiene las 8 medallas.
8. Curar Pokémon: cambia el estado de los Pokémon a `Vivo`.
9. Guardar partida: guarda el progreso en `Registros.txt`.
10. Guardar y salir: guarda el progreso y finaliza el programa.


Lógica de combate

La lógica de combate se basa en la suma de estadísticas de cada Pokémon.

Para cada combate se calcula:

- vida
- ataque
- defensa
- ataque especial
- defensa especial
- velocidad

Luego, esta suma se multiplica por la efectividad de tipo obtenida desde la clase `TablaTipos`.

La tabla de tipos permite determinar si un Pokémon tiene ventaja, desventaja o daño normal contra otro Pokémon.

Los valores utilizados son:

- `2.0`: ataque efectivo.
- `1.0`: ataque normal.
- `0.5`: ataque poco efectivo.
- `0.0`: ataque sin efecto.

El Pokémon con mayor puntaje gana el combate y el perdedor queda con estado `Debilitado`.



Validaciones implementadas

Durante el desarrollo se agregaron validaciones para evitar errores durante la ejecución del programa.

Algunas validaciones son:

- No permitir opciones fuera de rango en los menús.
- No permitir capturar Pokémon repetidos.
- No permitir usar Pokémon debilitados en combate.
- Permitir usar solo los primeros 6 Pokémon como equipo principal.
- No permitir retar gimnasios fuera de orden.
- No permitir obtener medallas infinitas del mismo gimnasio.
- No permitir desafiar al Alto Mando sin tener 8 medallas.
- Controlar errores si un archivo no existe.
- Validar que el usuario ingrese números en los menús mediante el método `leerEntero`.


 Métodos importantes agregados

`leerEntero`

Este método permite leer números desde teclado y evita que el programa se caiga si el usuario escribe letras.

`copiarPokemon`

Este método crea una copia independiente de un Pokémon. Se agregó para evitar modificar directamente los Pokémon originales de la Pokédex cuando el jugador captura uno o cuando se carga una partida guardada.

`marcarComoDerrotado`

Este método cambia el estado de un líder de gimnasio a `Derrotado` cuando el jugador gana el combate.

 `actualizarEstadosGimnasios`

Este método actualiza el estado de los gimnasios al cargar una partida guardada, según la cantidad de medallas del jugador.



Importancia del diagrama de clases

Al modelar este taller, el uso del diagrama de clases fue importante para entender cómo se conectaban las clases entre sí. El diagrama permitió identificar la herencia entre `Entrenador`, `Jugador`, `LiderGimnasio` y `AltoMando`, además de representar las relaciones entre las clases utilizadas en el sistema.

También fue útil para ordenar mejor la estructura del programa y comprender qué responsabilidad tenía cada clase.



Instrucciones de ejecución

1. Abrir el proyecto en Eclipse.
2. Verificar que los archivos `.txt` estén en la raíz del proyecto.
3. Ejecutar la clase `Main.java`.
4. Utilizar el menú por consola para interactuar con el juego.
5. Guardar la partida antes de salir si se desea conservar el progreso.



Consideraciones finales

Este taller permitió aplicar conceptos importantes de Programación Orientada a Objetos, como clases, objetos, atributos, métodos, herencia y encapsulamiento. También permitió practicar lectura y escritura de archivos, uso de `ArrayList`, manejo de excepciones y construcción de menús interactivos por consola.

El resultado final es un simulador básico de Pokémon que permite capturar, combatir, guardar partida y avanzar en el juego mediante gimnasios y Alto Mando.
