package presentacion.Retiro;

import logicaNegocio.CuentaBancaria;
import logicaNegocio.Sesiones;
import presentacion.RegistroUsuario.RegistroUsuarioForm;
import presentacion.VentanaPrincipal.VentanaPrincipalForms;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetiroForm extends JFrame{
    private JPanel pnlPrincipal;
    private JTextField txtDinero;
    private JButton btnRetiro;
    private JLabel lblRetiro;
    private JButton btnVolver;
    private JLabel lblWolf;

    public RetiroForm() {

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


        btnRetiro.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                String dinero = txtDinero.getText();
                Double saldo = Double.parseDouble(dinero);
                Double balance= Sesiones.usuarioAutenticado.getSaldo();
                if(balance>=saldo){
                    Sesiones.usuarioAutenticado.retirar(saldo);
                    String mensaje = "El retiro de  " + dinero + " ha sido  exitoso.";
                    JOptionPane.showMessageDialog(btnRetiro, mensaje);
                    dispose();
                    VentanaPrincipalForms v = new VentanaPrincipalForms();
                }else{
                    String mensaje = "Saldo insuficiente.";
                    JOptionPane.showMessageDialog(btnRetiro, mensaje);
                    dispose();
                    VentanaPrincipalForms v = new VentanaPrincipalForms();
                }

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

