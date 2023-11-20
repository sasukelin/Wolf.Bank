package presentacion.RealizarTransaccion;

import logicaNegocio.Banco;
import presentacion.RegistroUsuario.RegistroUsuarioForm;
import presentacion.VentanaPrincipal.VentanaPrincipalForms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RealizarTransaccionForm extends JFrame{
    private JPanel pnlPrincipal;
    private JTextField txtNombreCuenta;
    private JTextField txtCantidadaEnviar;
    private JButton btnEnvio;
    private JLabel lblNombreCuenta;
    private JLabel lblCantida;
    private JButton btnVolver;
    private JLabel lblWolf;

    /**
         * Constructor de la clase EjemploGridLayout
         * <p>
         * Complejidad Temporal: O(1) Tiempo Constante.
         */
        public RealizarTransaccionForm() {

            // Elimina el proceso cuando se cierra la ventana
            // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            // Se asigna el panel principal al JFrame
            this.setContentPane(pnlPrincipal);
            // Se asigna el tamaño por defecto
            this.setSize(500, 300);
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


            btnEnvio.addActionListener(new ActionListener() {
                @Override
                /**
                 * Evento click del botón btnGuardar
                 *
                 * Complejidad Temporal: O(1) Tiempo Constante.
                 */
                public void actionPerformed(ActionEvent e) {

                    String nombre_de_usario = txtNombreCuenta.getText();
                    String dinero = txtCantidadaEnviar.getText();
                    Double saldo = Double.parseDouble(dinero);

                    Banco.transferir(nombre_de_usario, saldo);


                    String mensaje = "La transaccion " + dinero + " ha sido correctamente hecho.";




                    JOptionPane.showMessageDialog(btnEnvio, mensaje);
                    dispose();
                    VentanaPrincipalForms v = new VentanaPrincipalForms();
                }
            });

            btnVolver.addActionListener(new ActionListener() {
                @Override
                /**
                 * Evento click del botón btnGuardar
                 *
                 * Complejidad Temporal: O(1) Tiempo Constante.
                 */
                public void actionPerformed(ActionEvent e) {


                    dispose();
                    VentanaPrincipalForms v = new VentanaPrincipalForms();
                }
            });
        }
    

    }

