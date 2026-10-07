package sistema.saludador.vista;

import sistema.saludador.modelo.DatosEstudiante;
import sistema.saludador.modelo.PeriodoDia;
import sistema.saludador.servicio.ServicioSaludo;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class VentanaPrincipal extends JFrame {
    private static final String PANTALLA_INICIO = "inicio";
    private static final String PANTALLA_DATOS = "datos";
    private static final String PANTALLA_SALUDO = "saludo";

    private final ServicioSaludo servicioSaludo;
    private final CardLayout tarjetas;
    private final JPanel contenedor;
    private final JTextField campoNombre;
    private final JTextField campoEdad;
    private final JRadioButton opcionAm;
    private final JRadioButton opcionPm;
    private final JLabel etiquetaSaludo;

    public VentanaPrincipal(ServicioSaludo servicioSaludo) {
        super("Sistema Saludador");
        this.servicioSaludo = servicioSaludo;
        this.tarjetas = new CardLayout();
        this.contenedor = new JPanel(tarjetas);
        this.campoNombre = new JTextField(20);
        this.campoEdad = new JTextField(20);
        this.opcionAm = new JRadioButton("AM", true);
        this.opcionPm = new JRadioButton("PM");
        this.etiquetaSaludo = new JLabel("", JLabel.CENTER);

        configurarVentana();
        contenedor.add(crearPantallaInicio(), PANTALLA_INICIO);
        contenedor.add(crearPantallaDatos(), PANTALLA_DATOS);
        contenedor.add(crearPantallaSaludo(), PANTALLA_SALUDO);
        add(contenedor);
    }

    private void configurarVentana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(520, 380));
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(245, 247, 250));
    }

    private JPanel crearPantallaInicio() {
        JPanel panel = crearPanelBase();
        JLabel titulo = crearTitulo("Sistema Saludador");
        JLabel descripcion = crearTexto(
                "Solicitar saludo permite que el estudiante sea saludado por su nombre, mencionando su edad.");
        descripcion.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton botonSolicitar = crearBotonPrincipal("Solicitar saludo");
        botonSolicitar.addActionListener(e -> {
            limpiarFormulario();
            tarjetas.show(contenedor, PANTALLA_DATOS);
        });

        panel.add(Box.createVerticalGlue());
        panel.add(titulo);
        panel.add(Box.createVerticalStrut(16));
        panel.add(descripcion);
        panel.add(Box.createVerticalStrut(28));
        panel.add(botonSolicitar);
        panel.add(Box.createVerticalGlue());
        return panel;
    }

    private JPanel crearPantallaDatos() {
        JPanel panel = crearPanelBase();
        JLabel titulo = crearTitulo("Pedir datos");

        ButtonGroup grupoHora = new ButtonGroup();
        grupoHora.add(opcionAm);
        grupoHora.add(opcionPm);

        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setOpaque(false);
        formulario.setMaximumSize(new Dimension(420, 220));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        formulario.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        formulario.add(campoNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        formulario.add(new JLabel("Edad:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        formulario.add(campoEdad, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        formulario.add(new JLabel("Hora:"), gbc);
        JPanel panelHora = new JPanel();
        panelHora.setOpaque(false);
        panelHora.add(opcionAm);
        panelHora.add(opcionPm);
        gbc.gridx = 1;
        formulario.add(panelHora, gbc);

        JButton botonSaludar = crearBotonPrincipal("Confirmar datos");
        botonSaludar.addActionListener(e -> procesarDatos());

        JButton botonVolver = crearBotonSecundario("Volver");
        botonVolver.addActionListener(e -> tarjetas.show(contenedor, PANTALLA_INICIO));

        JPanel acciones = new JPanel();
        acciones.setOpaque(false);
        acciones.add(botonVolver);
        acciones.add(botonSaludar);

        panel.add(titulo);
        panel.add(Box.createVerticalStrut(20));
        panel.add(formulario);
        panel.add(Box.createVerticalStrut(16));
        panel.add(acciones);
        return panel;
    }

    private JPanel crearPantallaSaludo() {
        JPanel panel = crearPanelBase();
        JLabel titulo = crearTitulo("Saludo");
        etiquetaSaludo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        etiquetaSaludo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton botonNuevo = crearBotonPrincipal("Nuevo saludo");
        botonNuevo.addActionListener(e -> {
            limpiarFormulario();
            tarjetas.show(contenedor, PANTALLA_DATOS);
        });

        JButton botonInicio = crearBotonSecundario("Inicio");
        botonInicio.addActionListener(e -> tarjetas.show(contenedor, PANTALLA_INICIO));

        JPanel acciones = new JPanel();
        acciones.setOpaque(false);
        acciones.add(botonInicio);
        acciones.add(botonNuevo);

        panel.add(Box.createVerticalGlue());
        panel.add(titulo);
        panel.add(Box.createVerticalStrut(24));
        panel.add(etiquetaSaludo);
        panel.add(Box.createVerticalStrut(28));
        panel.add(acciones);
        panel.add(Box.createVerticalGlue());
        return panel;
    }

    private void procesarDatos() {
        String nombre = campoNombre.getText().trim();
        String edadTexto = campoEdad.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre del estudiante.", "Dato requerido",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(edadTexto);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un número entero.", "Dato inválido",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (edad < 0 || edad > 120) {
            JOptionPane.showMessageDialog(this, "Ingrese una edad válida entre 0 y 120.", "Dato inválido",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        PeriodoDia periodo = opcionAm.isSelected() ? PeriodoDia.AM : PeriodoDia.PM;
        DatosEstudiante datos = new DatosEstudiante(nombre, edad, periodo);
        etiquetaSaludo.setText(servicioSaludo.generarSaludo(datos));
        tarjetas.show(contenedor, PANTALLA_SALUDO);
    }

    private void limpiarFormulario() {
        campoNombre.setText("");
        campoEdad.setText("");
        opcionAm.setSelected(true);
    }

    private JPanel crearPanelBase() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(245, 247, 250));
        panel.setBorder(BorderFactory.createEmptyBorder(28, 36, 28, 36));
        return panel;
    }

    private JLabel crearTitulo(String texto) {
        JLabel titulo = new JLabel(texto, JLabel.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        return titulo;
    }

    private JLabel crearTexto(String texto) {
        JLabel etiqueta = new JLabel("<html><div style='text-align:center;width:380px'>" + texto + "</div></html>");
        etiqueta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        return etiqueta;
    }

    private JButton crearBotonPrincipal(String texto) {
        JButton boton = new JButton(texto);
        boton.setUI(new BasicButtonUI());
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setBackground(new Color(25, 118, 210));
        boton.setForeground(Color.WHITE);
        boton.setOpaque(true);
        boton.setContentAreaFilled(true);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
        boton.setPreferredSize(new Dimension(200, 40));
        return boton;
    }

    private JButton crearBotonSecundario(String texto) {
        JButton boton = new JButton(texto);
        boton.setUI(new BasicButtonUI());
        boton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        boton.setBackground(new Color(232, 236, 241));
        boton.setForeground(new Color(33, 37, 41));
        boton.setOpaque(true);
        boton.setContentAreaFilled(true);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 186, 194)),
                BorderFactory.createEmptyBorder(8, 16, 8, 16)));
        boton.setPreferredSize(new Dimension(140, 40));
        return boton;
    }
}
