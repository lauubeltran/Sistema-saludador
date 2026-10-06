package sistema.saludador.modelo;

public enum PeriodoDia {
    AM("AM"),
    PM("PM");

    private final String etiqueta;

    PeriodoDia(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public String toString() {
        return etiqueta;
    }
}
