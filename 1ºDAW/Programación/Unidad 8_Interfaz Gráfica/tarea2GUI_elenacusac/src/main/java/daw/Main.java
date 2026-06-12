package daw;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JFrame;

// Se implementa la interfaz
public class Main extends JPanel implements ActionListener{

    private JButton botonNombre, botonApellidos;
    private JTextArea texto;

    public Main(){
        initComponents();
    }

    private void initComponents(){

        botonNombre = new JButton("Nombre");
        botonApellidos = new JButton("Apellidos");

        texto = new JTextArea(1,25);
        texto.setBackground(Color.ORANGE);

        this.setLayout(new FlowLayout());

        this.add(botonNombre);
        this.add(botonApellidos);
        this.add(texto);

        // Se le indica a los botones que escuchen eventos tipo click
        botonNombre.addActionListener(this);
        botonApellidos.addActionListener(this);

    }

    @Override
    // Sobrescribimos el método de la interfaz
    public void actionPerformed(ActionEvent ae) {

        // Si el botón pulsado es botonNombre
        if(ae.getSource() == botonNombre){
            texto.setBackground(Color.WHITE);
            texto.setText("Elena");
        } else {
            texto.setBackground(Color.GREEN);
            texto.setText("Cusac Ortigosa");
        }
    }

    public static void main(String[] args) {

        // Construimos la ventana
        JFrame frame = new JFrame("App");

        // La ventana no se puede redimensionar
        frame.setResizable(false);

        // Posición de la ventana
        frame.setLocationRelativeTo(null);

        // Incluimos el panel en la ventana
        frame.add(new Main());

        // Ajusta el frame al contenido
        frame.pack();

        // Hacemos visible la ventana
        frame.setVisible(true);

        // Acción por defecto al pulsar el botón de cierre de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}