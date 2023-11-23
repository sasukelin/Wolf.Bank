package presentacion.RegistroUsuario;

import logicaNegocio.Banco;
import logicaNegocio.CuentaBancaria;
import presentacion.Login.LoginForm;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegistroUsuarioForm extends JFrame {
    private JPanel JPanell;
    private JTextField txtNombre;
    private JTextField txtSaldo;
    private JTextField txtContraseña;
    private JButton btnGuardar;
    private JLabel lblNombre;
    private JLabel lblSaldo;
    private JLabel lblContraseña;
    private javax.swing.JPanel pnlPrincipal;
    private JButton btnVolver;
    private JTextField txtApellido;
    private JLabel lblApellido;
    private JTextField txtidentificacion;
    private JLabel lblidentificación;
    private JTextField txtEmail;
    private JLabel lblEmail;

    /**
     * Constructor de la clase RegistroUsuarioForm.
     *
     * Complejidad Temporal: O(1) Tiempo Constante.
     */
    public RegistroUsuarioForm() {

        // Elimina el proceso cuando se cierra la ventana
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Se asigna el panel principal al JFrame
        this.setContentPane(JPanell);
        // Se asigna el tamaño por defecto
        this.setSize(1200, 720);
        // Se asigna la posición por defecto
        this.setLocation(200, 200);
        // No se permite redimensionar la ventana
        this.setResizable(false);
        // Se muestra la ventana como visible
        this.setVisible(true);
        setContentPane(JPanell);

        // Elimina el proceso cuando se cierra la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Se asigna el panel principal al JFrame
        this.setContentPane(JPanell);

        /**
         * Evento click del botón btnGuardar
         *
         * Complejidad Temporal: O(1) Tiempo Constante.
         */
        btnGuardar.addActionListener(new ActionListener() {
            @Override

            // Obtiene los datos ingresados por el usuario
            public void actionPerformed(ActionEvent e) {

                String nombre = txtNombre.getText();
                String apellido= txtApellido.getText();
                String identificacion = txtidentificacion.getText();
                String dinero = txtSaldo.getText();
                String email= txtEmail.getText();
                String contraseña = txtContraseña.getText();

                /**
                 * Condicional que verifica si lo que pone el usuario es un numero valido(no sea String).
                 *
                 * Complejidad Temporal: O(1) Tiempo Constante.
                 */
                if (!identificacion.matches("\\d+")) {
                    JOptionPane.showMessageDialog(btnGuardar, "La identificación debe ser un número válido.");
                    return;
                }
                /**
                * Condicional que verifica si lo que pone el usuario es un numero valido(no sea String).
                *
                * Complejidad Temporal: O(1) Tiempo Constante.
                */
                if (!dinero.matches("\\d+(\\.\\d+)?")) {
                    JOptionPane.showMessageDialog(btnGuardar, "El saldo debe ser un número válido.");
                    return;  // Salir del método si el saldo no es válido
                }

                /**
                 * Condicional que verifica si lo que pone el usuario es un correo valido.
                 *
                 * Complejidad Temporal: O(1) Tiempo Constante.
                 */
                if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$")) {
                    JOptionPane.showMessageDialog(btnGuardar, "El correo electrónico no tiene un formato válido.");
                    return;
                }
                // Convertir las cadenas a valores numéricos
                int id = Integer.parseInt(identificacion);
                double saldo = Double.parseDouble(dinero);

                CuentaBancaria usuario = new CuentaBancaria(nombre, apellido,id, saldo, email,contraseña);
                /**
                * Condicional que verifica si el usuario ya existe.
                *
                * Complejidad Temporal: O(1) Tiempo Constante.
                */
               if(!Banco.registrar(usuario)) {
                   JOptionPane.showMessageDialog(btnGuardar, "El Usuario  ya existe. No se puede registrar nuevamente.");
               }
               else {
                   String mensaje = "El Usuario " + nombre + " ha sido registrado exitosamente.";
                   JOptionPane.showMessageDialog(btnGuardar, mensaje);
                   dispose();
                   // TODO: Llamar a la ventana de Login
                   LoginForm loginForm = new LoginForm();
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
                LoginForm loginForm = new LoginForm();
            }
        });
    }

}
