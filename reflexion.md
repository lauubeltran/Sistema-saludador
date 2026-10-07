### Retos encontrados

Uno de los principales retos fue entender cómo organizar el programa en diferentes clases. Al principio puede parecer más fácil poner toda la lógica en una sola clase, pero durante el desarrollo fue necesario separar las funciones para que cada una tuviera una responsabilidad específica. Por ejemplo, `DatosEstudiante` se encarga de guardar la información del estudiante, `PeriodoDia` permite indicar si es AM o PM y `ServicioSaludo` se encarga de generar el saludo.

Otro reto fue trabajar con la interfaz gráfica en Java Swing. Fue necesario entender cómo se debía iniciar la ventana desde la clase principal y cómo utilizar `SwingUtilities` para que la interfaz se ejecutara de la manera correcta.

### Descubrimientos

Durante el desarrollo pude entender mejor la importancia de organizar bien el código. Tener cada clase encargada de una función específica hace que el programa sea más fácil de entender y también facilita realizar cambios posteriormente

También aprendi a utilizar los enumerados (`enum`) por medio de la clase `PeriodoDia`. En este caso, fue útil porque solo se necesitaban dos opciones: AM y PM. De esta manera se evitan errores que podrían ocurrir si se manejaran estos valores simplemente como textos.

Además, pude conocer mejor el operador ternario utilizado en `ServicioSaludo`, que permite decidir de una forma sencilla si se debe mostrar "Buenos días" o "Buenas tardes"

### Sorpresas o aspectos interesantes

Algo que me pareció interesante fue ver cómo varias clases pueden trabajar juntas para realizar algo que parece tan sencillo como generar un saludo. Aunque el resultado final es bastante simple, detrás de este hay diferentes clases y componentes que cumplen funciones específicas

También me pareció interesante utilizar `UIManager` para adaptar la apariencia de la interfaz al sistema operativo y `SwingUtilities.invokeLater()` para iniciar correctamente la ventana gráfica.

### Comandos y librerías utilizados

Para realizar el proyecto se utilizo Java, principalmente la libreria Swing para construir la interfaz gráfica.

Algunos de los elementos utilizados fueron:

* `javax.swing.SwingUtilities`, para trabajar con la ejecución de la interfaz gráfica.
* `javax.swing.UIManager`, para configurar la apariencia de la aplicación.
* `SwingUtilities.invokeLater()`, para iniciar la interfaz en el hilo correspondiente.
* `UIManager.setLookAndFeel()`, para establecer la apariencia del sistema.
* `setVisible(true)`, para mostrar la ventana principal.

Además, durante el desarrollo se utilizaron comandos de Java y Git para compilar, ejecutar y llevar el control del código del proyecto.

### Componentes que podrían faltar

Aunque el programa cumple con su función principal de generar un saludo personalizado, creo que todavía se podrían agregar algunas cosas para mejorar su funcionamiento.

Por ejemplo, se podrían incluir validaciones para evitar que el usuario ingrese una edad negativa, deje algún campo vacío o introduzca datos que no sean válidos. También sería útil agregar un botón para limpiar los datos, una opción para cerrar el programa desde la misma interfaz o permitir generar otro saludo sin tener que reiniciar la aplicación.

### Reflexión final

La realización de este proyecto me ayudó a entender mejor cómo se organiza un programa utilizando programación orientada a objetos. Pude ver que dividir las responsabilidades entre diferentes clases hace que el código sea más ordenado y facilita entender qué función cumple cada parte.
También fue útil trabajar con una interfaz gráfica, ya que permitió conectar la logica del programa con lo que el usuario puede hacer directamente desde la aplicación.

