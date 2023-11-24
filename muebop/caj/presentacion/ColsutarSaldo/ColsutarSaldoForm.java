package presentacion.ColsutarSaldo;

import logicaNegocio.CuentaBancaria;
import logicaNegocio.Sesiones;
import presentacion.RegistroUsuario.RegistroUsuarioForm;
import presentacion.VentanaPrincipal.VentanaPrincipalForms;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class    ColsutarSaldoForm  extends JFrame {
    private JPanel pnlPrincipal;
    private JButton btnConsultarSaldo;
    private JButton btnSalir;


    /**
     * Constructor de la clase ConsultarSaldoForm.
     *
     * Complejidad Temporal: O(1) Tiempo Constante.
     */
    public  ColsutarSaldoForm() {

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

        btnConsultarSaldo.setBorder(new LineBorder(new Color(233, 19, 52)));
        btnSalir.setBorder(new LineBorder(new Color(233, 19, 52)));
        btnConsultarSaldo.setPreferredSize(new Dimension(80, 30));
        btnSalir.setPreferredSize(new Dimension(80, 30));
        btnConsultarSaldo.addActionListener(new ActionListener() {
            @Override
            /**
             * Evento click del botón btnConsultarSaldo
             *
             * Complejidad Temporal: O(1) Tiempo Constante.
             */
            public void actionPerformed(ActionEvent e) {

                // Obtiene el saldo del usuario autenticado
                 Double saldo=  Sesiones.usuarioAutenticado.getSaldo();
                // Muestra un mensaje con el saldo
                String mensaje = "Tu saldo es de  " + saldo + " ";
                JOptionPane.showMessageDialog(btnConsultarSaldo, mensaje);
                // Cierra la ventana actual de consulta de saldo y vuelve a la ventana principal
                dispose();
                VentanaPrincipalForms v = new VentanaPrincipalForms();

            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            /**
             * Evento click del botón btnSalir
             *
             * Complejidad Temporal: O(1) Tiempo Constante.
             */
            public void actionPerformed(ActionEvent e) {

                dispose();
                VentanaPrincipalForms ventanaPrincipalForm = new VentanaPrincipalForms();
            }
        });


    }
}
