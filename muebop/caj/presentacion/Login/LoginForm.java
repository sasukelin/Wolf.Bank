package presentacion.Login;


import logicaNegocio.Banco;
import logicaNegocio.CuentaBancaria;
import logicaNegocio.Sesiones;
import presentacion.RegistroUsuario.RegistroUsuarioForm;
import presentacion.VentanaPrincipal.VentanaPrincipalForms;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase IngresarPersonaForm.
 * Hereda de JFrame y utiliza el layout GridLayout (Por defecto en IntelliJ).
 */
public class LoginForm extends JFrame {
    private JPanel pnlPrincipal;
    private JTextField txtEmail;

    private JButton btnGuardar;

    private javax.swing.JPanel JPanel;
    private JButton btnRegister;

    private JRadioButton recuerdaLaContraseñaRadioButton;
    private JTextField txtContraseña;
    private JLabel lblimgLobo;
    private JLabel ImageLogo;

    private JLabel lblNombre;
    private JLabel lblContraseña;






    /**
     * Constructor de la clase EjemploGridLayout
     * <p>
     * Complejidad Temporal: O(1) Tiempo Constante.
     */
    public LoginForm() {
        // Elimina el proceso cuando se cierra la ventana
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Se asigna el panel principal al JFrame
        this.setContentPane(pnlPrincipal);
        // Se asigna el tamaño por defecto
        this.setSize(1200, 720);
        // Se asigna la posición por defecto
        this.setLocation(200, 200);
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
            /**
             * Evento click del botón btnGuardar
             *
             * Complejidad Temporal: O(1) Tiempo Constante.
             */
            public void actionPerformed(ActionEvent e) {

                String email = txtEmail.getText();
                // Validar que el email tenga un formato válido
                if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$")) {
                    JOptionPane.showMessageDialog(btnGuardar, "El correo electrónico no tiene un formato válido.");
                    return;  // Salir del método si el correo electrónico no es válido
                }
                String contraseña = new String(txtContraseña.getText());



                CuentaBancaria usuarioAutenticado= Banco.Autenticar(email, contraseña);
                if(usuarioAutenticado !=null ){
                    Sesiones.usuarioAutenticado=usuarioAutenticado;
                    String mensaje = "El Usuario " + email + " ha sido autenticado exitosamente.";
                    JOptionPane.showMessageDialog(btnGuardar, mensaje);
                    dispose();
                    VentanaPrincipalForms v = new VentanaPrincipalForms();
                }else{
                    String mensaje = "El Usuario " + email + " no autenticado exitosamente ";
                    JOptionPane.showMessageDialog(btnGuardar, mensaje);
                }
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            /**
             * Evento click del botón btnGuardar
             *
             * Complejidad Temporal: O(1) Tiempo Constante.
             */
            public void actionPerformed(ActionEvent e) {


                dispose();
                RegistroUsuarioForm v = new RegistroUsuarioForm();
            }
        });
    }



}
