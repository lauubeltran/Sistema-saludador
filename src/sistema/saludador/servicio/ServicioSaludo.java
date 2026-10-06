package sistema.saludador.servicio;

import sistema.saludador.modelo.DatosEstudiante;
import sistema.saludador.modelo.PeriodoDia;

public class ServicioSaludo {

    public String generarSaludo(DatosEstudiante datos) {
        String saludoInicial = datos.getPeriodoDia() == PeriodoDia.AM
                ? "Buenos días"
                : "Buenas tardes";
        return saludoInicial + ", " + datos.getNombre()
                + ". Tienes " + datos.getEdad() + " años.";
    }
}
