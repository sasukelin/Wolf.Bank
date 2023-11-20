package presentacion.RegistroUsuario;

import logicaNegocio.Banco;
import logicaNegocio.CuentaBancaria;
import presentacion.Login.LoginForm;
import presentacion.VentanaPrincipal.VentanaPrincipalForms;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase IngresarPersonaForm.
 * Hereda de JFrame y utiliza el layout GridLayout (Por defecto en IntelliJ).
 */
public class RegistroUsuarioForm extends JFrame {
    private JPanel pnlPrincipal;
    private JTextField txtNombre;
    private JTextField txtSaldo;
    private JTextField txtContraseña;
    private JButton btnGuardar;
    private JLabel lblNombre;
    private JLabel lblSaldo;
    private JLabel lblContraseña;
    private JLabel lblWolf;
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
        this.setContentPane(pnlPrincipal);
        // Se asigna el tamaño por defecto
        this.setSize(720, 520);
        // Se asigna la posición por defecto
        this.setLocation(100, 100);
        // No se permite redimensionar la ventana
        this.setResizable(false);
        // Se muestra la ventana como visible
        this.setVisible(true);
        setContentPane(pnlPrincipal);

        // Elimina el proceso cuando se cierra la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Se asigna el panel principal al JFrame
        this.setContentPane(pnlPrincipal);

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

                Banco.registrar(usuario);


                String mensaje = "El Usuario " + nombre + " ha sido registrado exitosamente.";

                JOptionPane.showMessageDialog(btnGuardar, mensaje);
                dispose();
                // TODO: Llamar a la ventana de Login
                LoginForm loginForm = new LoginForm();
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
