package presentacion.RegistroUsuario;

import logicaNegocio.Banco;
import logicaNegocio.CuentaBancaria;
import presentacion.Login.LoginForm;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase IngresarPersonaForm.
 * Hereda de JFrame y utiliza el layout GridLayout (Por defecto en IntelliJ).
 */
public class RegistroUsuarioForm extends JFrame {
    private JPanel JPanell;
    private JTextField txtNombre;
    private JTextField txtSaldo;
    private JTextField txtContraseña;
    private JButton btnGuardar;
    private JLabel lblNombre;
    private JLabel lblSaldo;
    private JLabel lblContraseña;
    private JLabel lblWolf;
    private javax.swing.JPanel pnlPrincipal;
    private JButton btnVolver;

    /**
     * Constructor de la clase EjemploGridLayout
     * <p>
     * Complejidad Temporal: O(1) Tiempo Constante.
     */
    public RegistroUsuarioForm() {

        // Elimina el proceso cuando se cierra la ventana
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Se asigna el panel principal al JFrame
        this.setContentPane(JPanell);
        // Se asigna el tamaño por defecto
        this.setSize(900, 600);
        // Se asigna la posición por defecto
        this.setLocation(100, 100);
        // No se permite redimensionar la ventana
        this.setResizable(false);
        // Se muestra la ventana como visible
        this.setVisible(true);
        setContentPane(JPanell);

        // Elimina el proceso cuando se cierra la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Se asigna el panel principal al JFrame
        this.setContentPane(JPanell);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            /**
             * Evento click del botón btnGuardar
             *
             * Complejidad Temporal: O(1) Tiempo Constante.
             */
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String dinero = txtSaldo.getText();
                String contraseña = txtContraseña.getText();
                double saldo = Double.parseDouble(dinero);
                CuentaBancaria usuario = new CuentaBancaria(nombre, saldo, contraseña);

               if(!Banco.registrar(usuario)) {
                   JOptionPane.showMessageDialog(btnGuardar, "El Usuario " + usuario.getNombre()
                           + " ya existe. No se puede registrar nuevamente.");
               }
               else {
                   String mensaje = "El Usuario " + nombre + " ha sido registrado exitosamente.";

                   JOptionPane.showMessageDialog(btnGuardar, mensaje);
                   dispose();
                   // TODO: Llamar a la ventana de Login
                   LoginForm loginForm = new LoginForm();
               }

               /* if( usuarioRegistrado!=null){
                   */

               /* }else {
                    String mensaje = "Registro Fallido ";
                    JOptionPane.showMessageDialog(btnGuardar, mensaje);
                }
*/






            }
        });

        btnVolver.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {



                dispose();
                LoginForm loginForm = new LoginForm();
            }
        });
    }

}
