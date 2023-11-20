package presentacion.ColsutarSaldo;

import logicaNegocio.CuentaBancaria;
import presentacion.RegistroUsuario.RegistroUsuarioForm;
import presentacion.VentanaPrincipal.VentanaPrincipalForms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColsutarSaldoForm  extends JFrame {
    private JPanel pnlPrincipal;
    private JTextField txtConsultarSaldo;
    private JButton btnConsultarSaldo;
    private JButton btnSalir;


    public  ColsutarSaldoForm() {

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


        btnConsultarSaldo.addActionListener(new ActionListener() {
            @Override
            /**
             * Evento click del botón btnGuardar
             *
             * Complejidad Temporal: O(1) Tiempo Constante.
             */
            public void actionPerformed(ActionEvent e) {
                 Double saldo= CuentaBancaria.getSaldo();
                String mensaje = "Tu saldo es de  " + saldo + " ";
                JOptionPane.showMessageDialog(btnConsultarSaldo, mensaje);
                dispose();
                VentanaPrincipalForms v = new VentanaPrincipalForms();

            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            /**
             * Evento click del botón btnGuardar
             *
             * Complejidad Temporal: O(1) Tiempo Constante.
             */
            public void actionPerformed(ActionEvent e) {


                dispose();
                VentanaPrincipalForms ventanaPrincipalForm = new VentanaPrincipalForms();
            }
        });


    }
}
