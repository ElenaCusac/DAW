package daw;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main2 {

    public static void main(String[] args) {

        // Construimos la ventana
        JFrame ventanaPrincipal = new JFrame("Aplicación");

        // Establecemos tamaño y posición
        ventanaPrincipal.setSize(800, 600);
        ventanaPrincipal.setLocationRelativeTo(null);

        // Establecemos el layout del JFrame
        ventanaPrincipal.setLayout(new BorderLayout());

        // Añadir panel amarillo en la posición superior (NORTH)
        ventanaPrincipal.add(new MiPanel(Color.yellow), BorderLayout.NORTH);

        // Añadir panel rojo en la posición inferior (SOUTH)
        ventanaPrincipal.add(new MiPanel(Color.red), BorderLayout.SOUTH);

        // Añadir panel gris en la posición central (CENTER)
        ventanaPrincipal.add(new MiPanel(Color.gray), BorderLayout.CENTER);

        // Añadir panel verde en la posición izquierda (WEST)
        ventanaPrincipal.add(new MiPanel(Color.green), BorderLayout.WEST);

        // Añadir panel cián en la posición derecha (EAST)
        ventanaPrincipal.add(new MiPanel(Color.cyan), BorderLayout.EAST);

        // Hacemos visible la ventana
        ventanaPrincipal.setVisible(true);

        // Acción por defecto al pulsar el botón de cierre
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MiPanel extends JPanel {

    // Añadimos un componente de tipo etiqueta (JLabel)
    private JLabel etiqueta;

    public MiPanel(Color color) {
        initComponents();
        cambiarColorFondo(color);
    }

    private void initComponents() {
        etiqueta = new JLabel("Etiqueta de MiPanel");
        this.add(etiqueta);
    }

    private void cambiarColorFondo(Color color) {
        this.setBackground(color);
    }

    public JLabel getEtiqueta() {
        return etiqueta;
    }
}
