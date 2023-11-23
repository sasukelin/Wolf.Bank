package presentacion.Depositar;

import logicaNegocio.CuentaBancaria;
import logicaNegocio.Sesiones;
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

    /**
     * Constructor de la clase DepositarForm.
     *
     * Complejidad Temporal: O(1) Tiempo Constante.
     */

    public DepositarForm() {

        // Elimina el proceso cuando se cierra la ventana
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Se asigna el panel principal al JFrame
        this.setContentPane(pnlPrincipal);
        // Se asigna el tamaño por defecto
        this.setSize(500, 550);
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

        /**
         * Evento click del botón btnGuardar
         *
         * Complejidad Temporal: O(1) Tiempo Constante.
         */

        btnGuardar.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                // Obtiene el monto ingresado por el usuario
                String dinero = txtDeposito.getText();

                /**
                 * Condicional que verifica si lo que pone el usuario es un numero (no admite Strings).
                 *
                 * Complejidad Temporal: O(1) Tiempo Constante.
                 */


                if (!dinero.matches("\\d+(\\.\\d+)?")) {
                    JOptionPane.showMessageDialog( btnGuardar, "El saldo debe ser un número válido.");
                    return;  // Salir del método si el saldo no es válido
                }
                // Convierte el monto a un valor numérico
                Double saldo = Double.parseDouble(dinero);


                // Realiza el depósito en la cuenta del usuario autenticado
                Sesiones.usuarioAutenticado.depositar(saldo);
                // Muestra un mensaje de depósito exitoso
                String mensaje = "El Deposito de " + saldo + " fue exitoso";
                // Cierra la ventana actual de depósito y vuelve a la ventana principal
                JOptionPane.showMessageDialog(btnGuardar, mensaje);
                dispose();
                VentanaPrincipalForms v = new VentanaPrincipalForms();
            }
        });

        /**
         * Evento click del botón btnVolver
         *
         * Complejidad Temporal: O(1) Tiempo Constante.
         */
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaPrincipalForms v = new VentanaPrincipalForms();
            }
        });
    }
}

