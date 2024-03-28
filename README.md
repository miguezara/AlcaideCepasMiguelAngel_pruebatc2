# AlcaideCepasMiguelAngel_pruebatc2

## Descripción
¡Bienvenido al Gestor de Turnos! Esta aplicación web ha sido diseñada para brindarte una solución completa y eficiente en la gestión de turnos para trámites administrativos. Con una interfaz amigable y funciones avanzadas, simplifica el proceso de organización y control de los ciudadanos que realizan trámites en su entidad, proporcionando una experiencia fluida tanto para los usuarios como para el personal ejecutivo.

## Contexto y Objetivos
El Gestor de Turnos surge como respuesta a la necesidad de mejorar la eficiencia y la experiencia del usuario en la gestión de trámites administrativos. El objetivo principal es proporcionar una herramienta que simplifique el proceso de asignación de turnos y brinde un seguimiento detallado de cada trámite, lo que permita una mejor planificación y atención al ciudadano.

### Características Destacadas
El Gestor de Turnos está equipado con una variedad de funciones diseñadas para satisfacer las necesidades específicas de tus trámites:

- **Optimización de Recursos:** Con el Gestor de Turnos, puedes asignar recursos de manera más efectiva al anticipar y programar la cantidad adecuada de personal en función de la demanda esperada de trámites.
- **Reducción de Tiempos de Espera:** Los ciudadanos pueden programar sus turnos de manera anticipada, lo que reduce significativamente los tiempos de espera y mejora su satisfacción.
- **Seguimiento Preciso:** El sistema proporciona un seguimiento detallado de cada trámite, desde el momento en que se programa el turno hasta que se completa, lo que facilita el análisis y la mejora continua de los procesos.
- **Experiencia Mejorada del Ciudadano:** Al ofrecer una plataforma intuitiva para programar turnos y recibir actualizaciones en tiempo real, el Gestor de Turnos mejora la experiencia del ciudadano y fortalece la relación con la entidad.
  
### Características principales
- Creación de turnos para diferentes trámites.
- Visualización de turnos por fecha.
- Cambio de estado de los turnos (en espera/atendido).
- Validación del formato de DNI antes de asignar un turno.
- Manejo de errores y mensajes de éxito.

## Instalación
1. **Clona el Repositorio:** Haz una copia del repositorio en tu máquina local utilizando el comando `git clone https://github.com/miguezara/AlcaideCepasMiguelAngel_pruebatc2.git.
2. **Configura la Base de Datos:** Crea una base de datos MySQL y ejecuta el script de creación de tablas proporcionado en `turno_ticado.sql`.
3. **Configura la Conexión a la Base de Datos:** Modifica los parámetros de conexión en `src/main/java/com/mycompany/turnoprueba/logica/Conexion.java` para que coincidan con tu entorno.
4. **Compila y Ejecuta el Proyecto:** Utiliza un IDE Java como Eclipse o IntelliJ IDEA para abrir el proyecto. Luego, compila y ejecuta la aplicación.
5. **Accede a la Aplicación:** Abre un navegador web y accede a `http://localhost:puerto/turnos.jsp` para comenzar a utilizar la aplicación.

## Contribuciones y Soporte
¡Tu contribución es valiosa! Si deseas mejorar esta aplicación, sigue estos pasos:

1.Haz un Fork del Repositorio.
2. Realiza tus cambios directamente en la rama `master`.
3. Haz commit de tus cambios (`git commit -am 'Agrega'`).
4. Haz push a la rama `master` de tu repositorio remoto (`git push origin master`).
5. Crea un nuevo Pull Request desde tu repositorio hacia el repositorio original.

Si necesitas ayuda o tienes alguna pregunta, no dudes en ponerte en contacto con el equipo de desarrollo en zara_migue@hotmail.com

## Créditos
Este proyecto fue desarrollado por Miguel Ángel Alcaide Cepas

## Licencia
Este proyecto está licenciado bajo la Licencia MIT, lo que significa que puedes utilizarlo, modificarlo y distribuirlo libremente.https://opensource.org/licenses/MIT.
