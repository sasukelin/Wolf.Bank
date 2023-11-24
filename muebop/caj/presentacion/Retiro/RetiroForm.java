package presentacion.Retiro;

import logicaNegocio.CuentaBancaria;
import logicaNegocio.Sesiones;
import presentacion.RegistroUsuario.RegistroUsuarioForm;
import presentacion.VentanaPrincipal.VentanaPrincipalForms;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetiroForm extends JFrame{
    private JPanel pnlPrincipal;
    private JTextField txtDinero;
    private JButton btnRetiro;
    private JLabel lblRetiro;
    private JButton btnVolver;
    private JLabel lblWolf;

    /**
     * Constructor de la clase RetiroForm.
     *
     * Complejidad Temporal: O(1) Tiempo Constante.
     */

    public RetiroForm() {

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
        Color colorBordeNombre = new Color(233, 19, 52);
        txtDinero.setBorder(new LineBorder(colorBordeNombre));
        txtDinero.setPreferredSize(new Dimension(20, 35));
        btnRetiro.setBorder(new LineBorder(new Color(233, 19, 52)));
        btnVolver.setBorder(new LineBorder(new Color(233, 19, 52)));
        btnVolver.setPreferredSize(new Dimension(80, 30));
        btnRetiro.setPreferredSize(new Dimension(80, 30));

        /**
         * Evento click del botón btnRetiro
         *
         * Complejidad Temporal: O(1) Tiempo Constante.
         */

        btnRetiro.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                String dinero = txtDinero.getText();


                /**
                 * Condicional que verifica si lo que pone el usuario es un numero (no admite Strings).
                 *
                 * Complejidad Temporal: O(1) Tiempo Constante.
                 */
                if (!dinero.matches("\\d+(\\.\\d+)?")) {
                    JOptionPane.showMessageDialog(btnRetiro, "El saldo debe ser un número válido.");
                    return;  // Salir del método si el saldo no es válido
                }
                Double saldo = Double.parseDouble(dinero);
                Double balance= Sesiones.usuarioAutenticado.getSaldo();

                /**
                 * Condicional que verifica si el saldo del usuario autenticado sea mayor al monto a retirar.
                 *
                 * Complejidad Temporal: O(1) Tiempo Constante.
                 */
                if(balance>=saldo){
                    Sesiones.usuarioAutenticado.retirar(saldo);
                    String mensaje = "El retiro de  " + dinero + " ha sido  exitoso.";
                    JOptionPane.showMessageDialog(btnRetiro, mensaje);
                    dispose();
                    VentanaPrincipalForms v = new VentanaPrincipalForms();
                }else{
                    String mensaje = "Saldo insuficiente.";
                    JOptionPane.showMessageDialog(btnRetiro, mensaje);
                    dispose();
                    VentanaPrincipalForms v = new VentanaPrincipalForms();
                }

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

