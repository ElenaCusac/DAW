package daw;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Main extends JFrame {

    // Atributos
    private JLabel etiqueta1, etiqueta2;
    private JButton boton1, boton2;

    // Constructor
    public Main() {
        super("Ejercicio Eventos");

        // Layout FlowLayout
        this.setLayout(new FlowLayout());

        configurarVentana();
        inicializarComponentes();
        eventoAleatorio();
        eventoRaton();
        eventoBotonRaton();

        this.setVisible(true);
    }

    // Método para tamaño y centrado
    private void configurarVentana() {
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Método que inicializa componentes y los añade al JFrame
    private void inicializarComponentes() {

        etiqueta1 = new JLabel("etiqueta1");
        etiqueta2 = new JLabel("etiqueta2");

        boton1 = new JButton("Aleatorio");
        boton2 = new JButton("Raton");

        // Orden: boton1, etiqueta1, boton2, etiqueta2
        this.add(boton1);
        this.add(etiqueta1);
        this.add(boton2);
        this.add(etiqueta2);
    }

    // Evento botón Aleatorio
    private void eventoAleatorio() {

        boton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Random r = new Random();
                int numero = r.nextInt(11); // 0-10

                etiqueta1.setText(Integer.toString(numero));
            }
        });
    }

    // Evento MouseListener para el botón Ratón
    private void eventoRaton() {

        boton2.addMouseListener(new MouseListener() {

            @Override
            public void mouseEntered(MouseEvent e) {
                boton2.setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton2.setBackground(Color.GRAY);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });
    }

    // Método que abre JOptionPane
    private void pedirTexto() {

        String texto = JOptionPane.showInputDialog(
                this,
                "Introduce un texto:");

        if (texto != null) {
            etiqueta2.setText(texto);
        }
    }

    // Evento ActionListener para botón Ratón
    private void eventoBotonRaton() {

        boton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pedirTexto();
            }
        });
    }

    // main
    public static void main(String[] args) {
        new Main();
    }
}