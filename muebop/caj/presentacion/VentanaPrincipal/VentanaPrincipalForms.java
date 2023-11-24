package presentacion.VentanaPrincipal;


import presentacion.ColsutarSaldo.ColsutarSaldoForm;
import presentacion.Depositar.DepositarForm;
import presentacion.Login.LoginForm;
import presentacion.RealizarTransaccion.RealizarTransaccionForm;
import presentacion.Retiro.RetiroForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase para la Venta Principal de la aplicación.
 */
public class VentanaPrincipalForms extends JFrame {
    private JPanel pnlPrincipal;
    private JButton btnDeposit;
    private JButton btnGetSaldo;
    private JButton btnRetirar;
    private JButton btnTransferir;
    private JButton btnSalir;

    /**
     * Constructor de la clase VentanaPrincipalForms
     *
     * Complejidad Temporal: O(1) Tiempo Constante.
     */
    public VentanaPrincipalForms() {


        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Definir la dimensión deseada para la ventana
        int ventanaAncho = 1920;
        int ventanaAlto = 1080;

        // Asegurarse de que la ventana no sea más grande que la pantalla
        ventanaAncho = Math.min(ventanaAncho, screenSize.width);
        ventanaAlto = Math.min(ventanaAlto, screenSize.height);

        // Asignar el tamaño de la ventana (JFrame actual) con la dimensión deseada
        this.setSize(ventanaAncho, ventanaAlto);


        // Elimina el proceso cuando se cierra la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Se asigna el panel principal al JFrame
        this.setContentPane(pnlPrincipal);


        // No se permite redimensionar la ventana
        this.setResizable(false);
        // Se muestra la ventana como visible
        this.setVisible(true);
        btnSalir.setBorderPainted(false);
        btnDeposit.setBorderPainted(false);
        btnTransferir.setBorderPainted(false);
        btnRetirar.setBorderPainted(false);
        btnGetSaldo.setBorderPainted(false);
        btnSalir.setBorderPainted(false);

        // Se muestra la ventana como visible
        this.setVisible(true);

        /**
         * Evento click del botón btnDeposit
         *
         * Complejidad Temporal: O(1) Tiempo Constante.
         */

        btnDeposit.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
               dispose();

                DepositarForm DepositarForm = new DepositarForm();
            }
        });

        /**
         * Evento click del botón btnTransferir
         *
         * Complejidad Temporal: O(1) Tiempo Constante.
         */
        btnTransferir.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                dispose();
                RealizarTransaccionForm TransferirForm = new RealizarTransaccionForm();
            }
        });

        /**
         * Evento click del botón btnRetirar
         *
         * Complejidad Temporal: O(1) Tiempo Constante.
         */
        btnRetirar.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                dispose();
                RetiroForm RetiroForm = new RetiroForm();
            }
        });

        /**
         * Evento click del botón btnSaldo
         *
         * Complejidad Temporal: O(1) Tiempo Constante.
         */
        btnGetSaldo.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                dispose();
                ColsutarSaldoForm ColsutarSaldoForm = new ColsutarSaldoForm();
            }
        });

        /**
         * Evento click del botón btnSalir
         *
         * Complejidad Temporal: O(1) Tiempo Constante.
         */

        btnSalir.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginForm loginForm = new LoginForm();
            }
        });

    }
}
