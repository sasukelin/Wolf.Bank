package presentacion.Depositar;

import logicaNegocio.CuentaBancaria;
import presentacion.RegistroUsuario.RegistroUsuarioForm;
import presentacion.VentanaPrincipal.VentanaPrincipalForms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositarForm extends JFrame {
    private JPanel pnlPrincipal;
    private JTextField txtDeposito;
    private JButton btnGuardar;
    private JLabel lblDepositar;
    private JButton btnVolver;
    private JLabel lblWolf;

    public DepositarForm() {

        // Elimina el proceso cuando se cierra la ventana
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Se asigna el panel principal al JFrame
        this.setContentPane(pnlPrincipal);
        // Se asigna el tamaño por defecto
        this.setSize(500, 300);
        // Se asigna la posición por defecto
        this.setLocation(100, 100);
        // No se permite redimensionar la ventana
        this.setResizable(false);
        // Se muestra la ventana como visible
        this.setVisible(true);

        // Elimina el proceso cuando se cierra la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Se asigna el panel principal al JFrame
        this.setContentPane(pnlPrincipal);

        btnGuardar.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                String dinero = txtDeposito.getText();
                Double saldo = Double.parseDouble(dinero);

                CuentaBancaria.depositar(saldo);

                String mensaje ="El Deposito de " + saldo + " fue exitoso";




                JOptionPane.showMessageDialog(btnGuardar, mensaje);
                dispose();
                VentanaPrincipalForms v = new VentanaPrincipalForms();
            }
        });

        btnVolver.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {



                dispose();
                VentanaPrincipalForms v = new VentanaPrincipalForms();
            }
        });
    }
}

