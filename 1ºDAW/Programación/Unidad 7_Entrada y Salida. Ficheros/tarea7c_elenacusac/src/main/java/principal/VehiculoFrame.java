package principal;

import modelos.Vehiculo;
import servicios.VehiculoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class VehiculoFrame extends JFrame {

    private JButton loadButton;
    private JTable vehicleTable;
    private DefaultTableModel tableModel;

    public VehiculoFrame() {
        setTitle("Vehículos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Button
        loadButton = new JButton("Cargar Vehículos");
        loadButton.addActionListener(new LoadButtonListener());
        add(loadButton, BorderLayout.NORTH);

        // Table
        String[] columnNames = {"Make", "Model", "Year", "VIN", "Color", "License Plate"};
        tableModel = new DefaultTableModel(columnNames, 0);
        vehicleTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(vehicleTable);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private class LoadButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                List<Vehiculo> vehiculos = VehiculoService.leerVehiculos();
                // Clear existing rows
                tableModel.setRowCount(0);
                // Add first 10 vehicles
                int count = Math.min(10, vehiculos.size());
                for (int i = 0; i < count; i++) {
                    Vehiculo v = vehiculos.get(i);
                    Object[] row = {
                        v.getVehicle_make(),
                        v.getVehicle_model(),
                        v.getVehicle_year(),
                        v.getVehicle_vin(),
                        v.getVehicle_color(),
                        v.getVehicle_license_plate()
                    };
                    tableModel.addRow(row);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(VehiculoFrame.this, "Error al leer el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VehiculoFrame());
    }
}