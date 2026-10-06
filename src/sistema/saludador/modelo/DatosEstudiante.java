package sistema.saludador.modelo;

public class DatosEstudiante {
    private final String nombre;
    private final int edad;
    private final PeriodoDia periodoDia;

    public DatosEstudiante(String nombre, int edad, PeriodoDia periodoDia) {
        this.nombre = nombre;
        this.edad = edad;
        this.periodoDia = periodoDia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public PeriodoDia getPeriodoDia() {
        return periodoDia;
    }
}
