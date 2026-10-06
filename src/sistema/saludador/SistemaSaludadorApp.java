package sistema.saludador;

import sistema.saludador.servicio.ServicioSaludo;
import sistema.saludador.vista.VentanaPrincipal;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class SistemaSaludadorApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
            }
            VentanaPrincipal ventana = new VentanaPrincipal(new ServicioSaludo());
            ventana.setVisible(true);
        });
    }
}
