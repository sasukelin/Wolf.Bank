package presentacion.VentanaPrincipal;


import presentacion.Login.LoginForm;
import presentacion.RealizarTransaccion.RealizarTransaccionForm;
import presentacion.RegistroUsuario.RegistroUsuarioForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase para la Venta Principal de la aplicación.
 */
public class VentanaPrincipalForms extends JFrame {
    private JPanel pnlPrincipal;

    /**
     * Método que inicializa el menú con las opciones para el usuario.
     *
     * Complejidad temporal: O(1) Complejidad Constante.
     */
    private void inicializarMenu() {
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu usuarioMenu = new JMenu("Inicio");
        menuBar.add(usuarioMenu);

        JMenuItem LoginFormItem = new JMenuItem("Login");
        usuarioMenu.add(LoginFormItem);

        JMenuItem RealizarTransaccionFormItem= new JMenuItem("Consultar saldo");
        usuarioMenu.add(RealizarTransaccionFormItem);

        JMenuItem RegistroDePersonaFormItem = new JMenuItem("Registro De cuenta");
        usuarioMenu.add(RegistroDePersonaFormItem);

        RegistroDePersonaFormItem.addActionListener(new ActionListener() {
            @Override
            /**
             * Evento click en el menú "Ingresar Persona".
             *
             * Complejidad temporal: O(1) Complejidad Constante.
             */
            public void actionPerformed(ActionEvent e) {
                RegistroUsuarioForm registroDeUsuarioForm = new RegistroUsuarioForm();
            }
        });

        LoginFormItem.addActionListener(new ActionListener() {
            @Override
            /**
             * Evento click en el menú "Consultar Personas".
             *
             * Complejidad temporal: O(1) Complejidad Constante.
             */
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(consultarPersonasItem, "Opción seleccionada: Consultar Personas");
                LoginForm Form = new LoginForm();
            }
        });

        RealizarTransaccionFormItem.addActionListener(new ActionListener() {
            @Override
            /**
             * Evento click en el menú "Ingresar Persona".
             *
             * Complejidad temporal: O(1) Complejidad Constante.
             */
            public void actionPerformed(ActionEvent e) {
                RealizarTransaccionForm registroDeUsuarioForm = new RealizarTransaccionForm ();
            }
        });
    }

    /**
     * Constructor de la clase EjemploGridLayout
     *
     * Complejidad Temporal: O(1) Tiempo Constante.
     */
    public VentanaPrincipalForms() {
        this.inicializarMenu();

        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Definir la dimensión deseada para la ventana
        int ventanaAncho = 100;
        int ventanaAlto = 100;

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
    }
}
