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
    private javax.swing.JPanel pnlPrincipal;
    private JButton btnVolver;
    private JTextField txtApellido;
    private JLabel lblApellido;
    private JTextField txtidentificacion;
    private JLabel lblidentificación;
    private JTextField txtEmail;
    private JLabel lblEmail;

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

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            /**
             * Evento click del botón btnGuardar
             *
             * Complejidad Temporal: O(1) Tiempo Constante.
             */
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String apellido= txtApellido.getText();
                String identificacion = txtidentificacion.getText();
                String dinero = txtSaldo.getText();
                String email= txtEmail.getText();
                String contraseña = txtContraseña.getText();

                if (!identificacion.matches("\\d+")) {
                    JOptionPane.showMessageDialog(btnGuardar, "La identificación debe ser un número válido.");
                    return;
                }

                if (!dinero.matches("\\d+(\\.\\d+)?")) {
                    JOptionPane.showMessageDialog(btnGuardar, "El saldo debe ser un número válido.");
                    return;  // Salir del método si el saldo no es válido
                }
                // Validar que el email tenga un formato válido
                if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$")) {
                    JOptionPane.showMessageDialog(btnGuardar, "El correo electrónico no tiene un formato válido.");
                    return;
                }

                int id = Integer.parseInt(identificacion);
                double saldo = Double.parseDouble(dinero);

                CuentaBancaria usuario = new CuentaBancaria(nombre, apellido,id, saldo, email,contraseña);

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
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginForm loginForm = new LoginForm();
            }
        });
    }

}
