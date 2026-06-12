package daw;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main3 {

    public static void main(String[] args) {

        // Construimos la ventana
        JFrame ventanaPrincipal = new JFrame ("Elena Cusac Ortigosa");

        // Establecemos tamaño y posición
        ventanaPrincipal.setSize(800, 600);
        ventanaPrincipal.setLocationRelativeTo(null);

        // La ventana no se puede redimensionar
        ventanaPrincipal.setResizable(false);

        // Establecemos el layout del JFrame
        ventanaPrincipal.setLayout(new BorderLayout());

        MiPanel norte = new MiPanel(Color.BLUE);
        norte.getEtiqueta().setText("Panel superior");

        MiPanel sur = new MiPanel(Color.ORANGE);
        sur.getEtiqueta().setText("Panel inferior");

        MiPanel centro = new MiPanel(Color.PINK);
        centro.getEtiqueta().setText("Panel central");

        MiPanel oeste = new MiPanel(Color.MAGENTA);
        oeste.getEtiqueta().setText("Panel izquierdo");

        MiPanel este = new MiPanel(Color.LIGHT_GRAY);
        este.getEtiqueta().setText("Panel derecho");

        ventanaPrincipal.add(norte, BorderLayout.NORTH);
        ventanaPrincipal.add(sur, BorderLayout.SOUTH);
        ventanaPrincipal.add(centro, BorderLayout.CENTER);
        ventanaPrincipal.add(oeste, BorderLayout.WEST);
        ventanaPrincipal.add(este, BorderLayout.EAST);

        // Hacemos visible la ventana
        ventanaPrincipal.setVisible(true);

        // Acción por defecto al pulsar el botón de cierre
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MiPanel extends JPanel {

    private JLabel etiqueta;

    public MiPanel(Color color){
        initComponents();
        cambiarColorFondo(color);
    }

    private void initComponents(){
        etiqueta = new JLabel("Etiqueta de MiPanel");
        this.add(etiqueta);
    }

    private void cambiarColorFondo(Color color){
        this.setBackground(color);
    }

    public JLabel getEtiqueta() {
        return etiqueta;
    }
}