# Tarea: Biblioteca IES Al-Ã�ndalus
## Profesor: JosÃ© RamÃ³n JimÃ©nez Reyes
## Alumno: Enrique Octavio Fernández Chacón

Desde el IES Al-Ã�ndalus nos acaban de comentar que por favor aÃ±adamos persistencia a los datos introducidos, ya que tal y como estÃ¡ ahora la aplicaciÃ³n no es funcional. Por tanto, en este **cuarto spring** aÃ±adiremos persistencia a los datos utilizando para ello ficheros de objetos, para lo que sustituiremos el modelo que tenÃ­amos de memoria, por un modelo de ficheros.

El diagrama de clases queda como te muestro a continuaciÃ³n y poco a poco te irÃ© explicando los diferentes pasos a realizar:

![Diagrama de clases para tutorias](src/main/resources/biblioteca.png)

En este repositorio de GitHub hay un esqueleto de proyecto gradle que ya lleva incluidos todos los test necesarios que el programa debe pasar.

Por tanto, tu tarea va a consistir en completar los siguientes apartados:

1. Lo primero que debes hacer es realizar un **fork** del repositorio donde he colocado el proyecto gradle con la estructura del proyecto y todos los test necesarios. Clona tu repositorio remoto reciÃ©n copiado en github a un repositorio local que serÃ¡ donde irÃ¡s realizando lo que a continuaciÃ³n se te pide. AÃ±ade tu nombre al fichero `README.md` en el apartado "Alumno". Copia los ficheros del directorio `src/main/java` de tu tarea anterior al repositorio local. Realiza tu primer commit.
2. Refactoriza para adecuar el proyecto al diagrama de clases. El paquete para las clases de negocio sea `ficheros`, la fuente de datos sea `FICHEROS`, etc.
3. Haz que las clases de dominio (para las que sea necesario) sean serializables para que se puedan leer y escribir de ficheros de objetos. Realiza un commit.
4. Implementa los mÃ©todos `comenzar` y `terminar` para la clase de negocio `Alumnos`. AÃ±Ã¡delos tambiÃ©n al interfaz correspondiente. El fichero de alumnos (al que debes referirte de forma relativa) se denominarÃ¡ `alumnos.dat` y estarÃ¡ situado en una carpeta denominada `datos` que se encontrarÃ¡ en la raÃ­z del proyecto. Realiza un commit.
5. Implementa los mÃ©todos `comenzar` y `terminar` para la clase de negocio `Libros`. AÃ±Ã¡delos tambiÃ©n al interfaz correspondiente. El fichero de libros (al que debes referirte de forma relativa) se denominarÃ¡ `libros.dat` y estarÃ¡ situado en una carpeta denominada `datos` que se encontrarÃ¡ en la raÃ­z del proyecto. Realiza un commit.
6. Implementa los mÃ©todos `comenzar` y `terminar` para la clase de negocio `Prestamos`. AÃ±Ã¡delos tambiÃ©n al interfaz correspondiente. El fichero de prÃ©stamos (al que debes referirte de forma relativa) se denominarÃ¡ `prestamos.dat` y estarÃ¡ situado en una carpeta denominada `datos` que se encontrarÃ¡ en la raÃ­z del proyecto. Realiza un commit.
7. Modifica la clase `Modelo` y la interfaz `IModelo` para que contemple estos mÃ©todos y su implementaciÃ³n. Realiza un commit.
8. Haz las modificaciones oportunas en la clase `Controlador` para que al comenzar se lean los diferentes ficheros y al salir se escriban los mismos. Realiza un commit y sÃºbelo a tu repositorio remoto.


###### Se valorarÃ¡:
- La indentaciÃ³n debe ser correcta en todas las clases.
- El nombre de las variables debe ser adecuado.
- Se debe utilizar la clase `Entrada` para realizar la entrada por teclado.
- El proyecto debe pasar todas las pruebas que van en el esqueleto del mismo y toda entrada del programa serÃ¡ validada para evitar que el programa termine abruptamente debido a una excepciÃ³n.
- Se deben utilizar los comentarios adecuados.
- Se valorarÃ¡ la correcciÃ³n ortogrÃ¡fica tanto en los comentarios como en los mensajes que se muestren al usuario.

