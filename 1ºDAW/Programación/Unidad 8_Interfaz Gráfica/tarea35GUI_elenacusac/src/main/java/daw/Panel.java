package daw;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup; // Para agrupar RadioButtons
import javax.swing.JButton;
import javax.swing.JComboBox; // Para el desplegable
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton; // Para los botones de opción
import javax.swing.JTextField;

public class Panel extends JPanel {

    public static final int ANCHO_PANEL = 600;
    // Aumento ligeramente el alto para los nuevos componentes
    public static final int ALTO_PANEL = 300; 

    private JButton btnGenerar, btnCerrar;
    private JLabel lblUrl, lblFichero, lblExtension;
    private JTextField tfUrl, tfFichero;

    // Nuevos componentes 
    private JComboBox<String> cbExtension; // Desplegable para extensiones
    private JRadioButton rbPng, rbJpg; // Botones de opción
    private ButtonGroup grupoExtensiones; // Grupo para exclusividad de RadioButtons

    public Panel() {
        this.setLayout(new FlowLayout());
        this.setBackground(Color.gray);
        this.setSize(ANCHO_PANEL, ALTO_PANEL);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // Label y Campo para Texto/URL
        lblUrl = new JLabel("Introduce el texto: ");
        this.add(lblUrl);
        tfUrl = new JTextField(40);
        this.add(tfUrl);

        // Label y Campo para Nombre de Fichero
        lblFichero = new JLabel("Nombre del fichero: ");
        this.add(lblFichero);
        tfFichero = new JTextField(30);
        this.add(tfFichero);

        // 1. AÑADIR JLABEL Y JCOMBOBOX
        lblExtension = new JLabel("Extensión del fichero: ");
        this.add(lblExtension);

        String[] opciones = { "png", "jpg" };
        cbExtension = new JComboBox<>(opciones);
        this.add(cbExtension);

        // 2. AÑADIR JRADIOBUTTONS Y BUTTONGROUP
        // Se crean los botones
        rbPng = new JRadioButton("png", true); // Marcado por defecto
        rbJpg = new JRadioButton("jpg");

        // Se añade al ButtonGroup para que sean excluyentes (solo uno seleccionado)
        grupoExtensiones = new ButtonGroup();
        grupoExtensiones.add(rbPng);
        grupoExtensiones.add(rbJpg);

        // Se añaden al panel para que sean visibles
        this.add(rbPng);
        this.add(rbJpg);

        // Botón generar
        btnGenerar = new JButton("Generar código QR");
        this.add(btnGenerar);

        btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!tfUrl.getText().isEmpty() && !tfFichero.getText().isEmpty()) {

                    // Lógica para determinar la extensión seleccionada en los RadioButtons
                    String extSeleccionada = rbPng.isSelected() ? "png" : "jpg";

                    /*
                     * Nota: Si quisieras usar el JComboBox en su lugar, sería:
                     * String extSeleccionada = cbExtension.getSelectedItem().toString();
                     */

                    // Concatenamos el nombre del fichero con el punto y la extensión
                    String nombreCompleto = tfFichero.getText() + "." + extSeleccionada;

                    // Genera el QR usando la extensión dinámica
                    QR.escribirQR(tfUrl.getText(), nombreCompleto, extSeleccionada);

                    // Muestra la ventana de resultado con el nombre completo
                    new VentanaResultado(nombreCompleto);
                } else {
                    JOptionPane.showMessageDialog(null, "No puede haber campos vacíos.");
                }
            }
        });

        btnCerrar = new JButton("Salir");
        this.add(btnCerrar);
        btnCerrar.addActionListener(e -> System.exit(0));
    }
}