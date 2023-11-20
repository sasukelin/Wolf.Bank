/*package presentacion.MenuPrincipal;

import logicaNegocio.Banco;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal {
    private JPanel pnlPrincipal;
    private JButton btnSalir;
    private JButton btnConsultarSaldo;
    private JButton btnDepositar;
    private JButton btnRetirar;
    private JButton btnRealizarTransaccion;

    private Banco banco;

    public MenuPrincipal(Banco banco) {
        this.banco = banco;

        btnConsultarSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarSaldo();
            }
        });

        btnDepositar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositar();
            }
        });

        btnRetirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retirar();
            }
        });

        btnRealizarTransaccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarTransaccion();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void mostrarSaldo() {
        JOptionPane.showMessageDialog(null, "Tu saldo es de $" + banco.usuarioAutenticado.getSaldo());
    }

    private void depositar() {
        double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a depositar"));
        banco.usuarioAutentificado().depositar(cantidad);
        JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente");
    }

    private void retirar() {
        double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a retirar"));
        banco.usuarioAutentificado().retirar(cantidad);
        JOptionPane.showMessageDialog(null, "Retiro realizado exitosamente");
    }

    private void realizarTransaccion() {
        String usuarioDestinatario = JOptionPane.showInputDialog("Ingrese el usuario al que desea transferir");
        double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a transferir"));
        banco.transferir(usuarioDestinatario, cantidad);
        JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente");
    }

    public JPanel getPnlPrincipal() {
        return pnlPrincipal;
    }
}
*/