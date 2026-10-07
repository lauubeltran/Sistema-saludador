El software inicia su ejecución en la clase SistemaSaludadorApp, específicamente en el método main(), que funciona como punto de entrada de la aplicación. Al iniciar, el sistema configura la interfaz gráfica utilizando las herramientas de Java Swing y posteriormente crea una instancia de ServicioSaludo.

A continuación, se crea la ventana principal del sistema mediante la clase VentanaPrincipal, a la cual se le proporciona el servicio encargado de generar los saludos. Finalmente, la ventana se hace visible para permitir la interacción con el usuario.

Durante el funcionamiento del sistema, la información del estudiante se almacena en un objeto de la clase DatosEstudiante. Esta clase contiene el nombre, la edad y el periodo del día del estudiante. El periodo se representa mediante el enumerado PeriodoDia, que puede tomar los valores AM o PM.

Una vez que los datos del estudiante están disponibles, son enviados a la clase ServicioSaludo. Esta clase se encarga de procesar la información y determinar el saludo correspondiente según el periodo del día. Si el periodo es AM, el sistema genera el mensaje "Buenos días"; si es PM, genera "Buenas tardes".

Finalmente, el nombre y la edad del estudiante se agregan al saludo para generar un mensaje personalizado. 