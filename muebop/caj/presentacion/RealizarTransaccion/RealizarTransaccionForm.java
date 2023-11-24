package presentacion.RealizarTransaccion;

import logicaNegocio.Banco;
import logicaNegocio.CuentaBancaria;
import logicaNegocio.Sesiones;
import presentacion.VentanaPrincipal.VentanaPrincipalForms;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RealizarTransaccionForm extends JFrame{
    private JPanel pnlPrincipal;
    private JTextField txtIdCuenta;
    private JTextField txtCantidadaEnviar;
    private JButton btnEnvio;
    private JLabel lblNombreCuenta;
    private JLabel lblCantida;
    private JButton btnVolver;


    /**
     * Constructor de la clase RealizarTransaccionForm.
     *
     * Complejidad Temporal: O(1) Tiempo Constante.
     */

        public RealizarTransaccionForm() {

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
            Color colorBorde = new Color(233, 19, 52);
            txtIdCuenta.setBorder(new LineBorder(colorBorde));
            txtCantidadaEnviar.setBorder(new LineBorder(colorBorde));
            btnEnvio.setBorder(new LineBorder(new Color(233, 19, 52)));
            btnVolver.setBorder(new LineBorder(new Color(233, 19, 52)));
            txtIdCuenta.setPreferredSize(new Dimension(20, 35));
            txtCantidadaEnviar.setPreferredSize(new Dimension(20, 35));
            btnVolver.setPreferredSize(new Dimension(80, 30));
            btnEnvio.setPreferredSize(new Dimension(80, 30));

            btnEnvio.addActionListener(new ActionListener() {
                @Override
                /**
                 * Evento click del botón btnGuardar
                 *
                 * Complejidad Temporal: O(1) Tiempo Constante.
                 */
                public void actionPerformed(ActionEvent e) {
                    // Obtiene la identificación del destinatario y la cantidad a enviar
                    String  cuentaDestinario = txtIdCuenta.getText();
                    String dinero = txtCantidadaEnviar.getText();

                    /**
                     * Condicional que verifica si lo que pone el usuario es un numero (no admite Strings).
                     *
                     * Complejidad Temporal: O(1) Tiempo Constante.
                     */
                    if (!cuentaDestinario.matches("\\d+")) {
                        JOptionPane.showMessageDialog( btnEnvio, "La identificación debe ser un número válido.");
                        return;
                    }

                    /**
                     * Condicional que verifica si lo que pone el usuario es un numero (no admite Strings).
                     *
                     * Complejidad Temporal: O(1) Tiempo Constante.
                     */

                    if (!dinero.matches("\\d+(\\.\\d+)?")) {
                        JOptionPane.showMessageDialog( btnEnvio, "El saldo debe ser un número válido.");
                        return;  // Salir del método si el saldo no es válido
                    }
                    // Convertir las cadenas a valores numéricos
                    int id = Integer.parseInt( cuentaDestinario);
                    Double saldo = Double.parseDouble(dinero);

                    // Realizar la transacción y obtener el destinatario
                    CuentaBancaria destinatario = Banco.transferir(id , saldo);

                    /**
                     * Condicional que verifica que la traccion haya sido corectamente enviada.
                     *
                     * Complejidad Temporal: O(1) Tiempo Constante.
                     */
                    if(destinatario !=null){
                        Sesiones.destinatario=destinatario;
                        String mensaje = "La transaccion " + dinero + " ha sido correctamente hecho.";
                        JOptionPane.showMessageDialog(btnEnvio, mensaje);
                        dispose();
                        VentanaPrincipalForms v = new VentanaPrincipalForms();
                    }else {
                        String mensaje = " Transaccion Fallida";
                        JOptionPane.showMessageDialog(btnEnvio, mensaje);
                    }


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

