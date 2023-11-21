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
     * Método que inicializa el menú con las opciones para el usuario.
     *
     * Complejidad temporal: O(1) Complejidad Constante.
     */


    /**
     * Constructor de la clase EjemploGridLayout
     *
     * Complejidad Temporal: O(1) Tiempo Constante.
     */
    public VentanaPrincipalForms() {


        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Definir la dimensión deseada para la ventana
        int ventanaAncho = 700;
        int ventanaAlto = 1000;

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

        btnDeposit.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
               dispose();

                DepositarForm DepositarForm = new DepositarForm();
            }
        });
        btnTransferir.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                dispose();
                RealizarTransaccionForm TransferirForm = new RealizarTransaccionForm();
            }
        });

        btnRetirar.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                dispose();
                RetiroForm RetiroForm = new RetiroForm();
            }
        });

        btnGetSaldo.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                dispose();
                ColsutarSaldoForm ColsutarSaldoForm = new ColsutarSaldoForm();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginForm loginForm = new LoginForm();
            }
        });

    }
}
