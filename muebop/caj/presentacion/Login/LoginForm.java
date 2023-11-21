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
    private JTextField txtNombre;

    private JButton btnGuardar;

    private javax.swing.JPanel JPanel;
    private JButton btnRegister;
    private JLabel lblWolf;

    private JRadioButton recuerdaLaContraseñaRadioButton;
    private JTextField txtContraseña;
    private JLabel ImageLogo;
    private JTextField txtSaldo;
    private JLabel lblSaldo;
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
        this.setSize(900, 600);
        // Se asigna la posición por defecto
        this.setLocation(0, 0);
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

                String nombre = txtNombre.getText();
                String contraseña = new String(txtContraseña.getText());
                CuentaBancaria usuarioAutenticado= Banco.Autenticar(nombre, contraseña);
                if(usuarioAutenticado !=null ){
                    Sesiones.usuarioAutenticado=usuarioAutenticado;
                    String mensaje = "El Usuario " + nombre + " ha sido autenticado exitosamente.";
                    JOptionPane.showMessageDialog(btnGuardar, mensaje);
                    dispose();
                    VentanaPrincipalForms v = new VentanaPrincipalForms();
                }else{
                    String mensaje = "El Usuario " + nombre + " no autenticado exitosamente ";
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
















































/*package presentacion.ColsultarUsuarios;

import logicaNegocio.BaseDeDatos;
import logicaNegocio.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class LoginForm
        extends JFrame {
    private JPanel pnlPrincipal;
    private JLabel lblUsuario;


    public LoginForm() {
        // Elimina el proceso cuando se cierra la ventana
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Se asigna el panel principal al JFrame
        this.setContentPane(pnlPrincipal);
        // Se asigna el tamaño por defecto
        this.setSize(600, 500);
        // Se asigna la posición por defecto
        this.setLocation(100, 100);
        // No se permite redimensionar la ventana
        this.setResizable(true);
        // Se muestra la ventana como visible
        this.setVisible(true);

        if (BaseDeDatos.getListaDeUsuarios().size() == 0) {
            this.lblUsuario.setText("No hay usuarios registrado");
        } else {
            this.lblUsuario.setText("Lista de usuarios registrados:");
            this.mostrarDatosUsuario();
        }
    }


    public void mostrarDatosUsuario() {
        String[] nombresDeColumnas = {"Nombre", "Saldo", "Contraseña"};

        // Crear un DefaultTableModel con columnas
        DefaultTableModel modelo = new DefaultTableModel();

        // Agregar columnas
        for(String nombreDeColumna : nombresDeColumnas) {
            modelo.addColumn(nombreDeColumna);
        }
        // Agregar filas
        for(Usuario usuario : BaseDeDatos.getListaDeUsuarios()) {
            Object[] fila = new Object[]{usuario.getNombre(), usuario.getSaldo(), usuario.getContraseña()};
            modelo.addRow(fila);
        }

        // Crear la JTable con el modelo
        JTable table = new JTable(modelo);

        // Agregar la JTable a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(500, 300);

        // Agregar el JScrollPane al JFrame
        this.add(scrollPane);
    }
}
*/