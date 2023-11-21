package logicaNegocio;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Scanner;


public class Banco {
    private static LinkedList<CuentaBancaria> cuentasBancarias = new LinkedList<>();
    private static CuentaBancaria usuarioAutenticado;
    private static boolean usuarioRegistrado;
    static Scanner lector = new Scanner(System.in);
   



    public static boolean registrar(CuentaBancaria usuario) {
        boolean existe = false;
        for (CuentaBancaria Usuario : cuentasBancarias) {
            if (Usuario.getNombre().equals(usuario.getNombre())) {
                existe = true;
            }
        }

        if (!existe) {
            cuentasBancarias.add(usuario);
            return true;

        } else {

            return false;
        }

    }

    public static CuentaBancaria Autenticar(String nombreUsuario, String contraseña) {
        CuentaBancaria usuarioEncontrado = null;

        for (CuentaBancaria Usuario : cuentasBancarias) {
            if (Usuario.getNombre().equals(nombreUsuario)) {
                usuarioEncontrado = Usuario;
                break;
            }
        }
        if (usuarioEncontrado != null) {
            if (usuarioEncontrado.getContraseña().equals(contraseña)) {
                usuarioAutenticado = usuarioEncontrado;
                System.out.println("Autenticación exitosa para el usuario " + nombreUsuario);

                return usuarioAutenticado;
            } else {
                System.out.println("Contraseña incorrecta ");
            }
        } else {
            System.out.println("El usuario no existe");
        }
        return usuarioEncontrado;
    }
/*
    public static void userActions(){
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n");
            System.out.println("Por favor, elija una opción:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Realizar una transacción");
            System.out.println("0. Salir");
            System.out.println("\n");
            opcion = Integer.parseInt(lector.nextLine());

            switch (opcion) {
                case 1 -> System.out.println("Tu saldo es de " + usuarioAutenticado.getSaldo());
                case 2 -> {
                    System.out.println("Digite la cantidad a ingresar");
                    double cantidadIngresada = Double.parseDouble(lector.nextLine());
                    usuarioAutenticado.depositar(cantidadIngresada);
                }
                case 3 -> {
                    System.out.println("Digite la cantidad a retirar");
                    double cantidadRetirada = Double.parseDouble(lector.nextLine());
                    usuarioAutenticado.retirar(cantidadRetirada);
                }
                case 4 -> {
                    System.out.println("Ingrese el usuario al que desea enviar");
                    String usuarioDestinatario = lector.nextLine();
                    System.out.println("Ingrese la cantidad a enviar");
                    double cantidadEnviar = Double.parseDouble(lector.nextLine());
                    transferir(usuarioDestinatario, cantidadEnviar);
                }
                case 0 -> System.out.println("\nSaliendo de WolfBank. Hasta la próxima");
                default -> System.out.println("\nOpción no válida. Por favor, elija una opción válida.");
            }
        }
    }


*/

    public static CuentaBancaria transferir(String nombreDestinatario, double cantidad) {

        if (usuarioAutenticado != null) {
            CuentaBancaria destinatario = null;
            for (CuentaBancaria usuario : cuentasBancarias) {
                if (usuario.getNombre().equals(nombreDestinatario)) {
                    destinatario = usuario;
                    break;
                }
            }
            if (destinatario != null) {
                if (usuarioAutenticado.getSaldo() >= cantidad) {
                    double saldoOrigen = usuarioAutenticado.getSaldo();
                    double saldoDestinatario = destinatario.getSaldo();

                    usuarioAutenticado.setSaldo(saldoOrigen - cantidad);
                    destinatario.setSaldo(saldoDestinatario + cantidad);
                     return usuarioAutenticado;
                } else {
                    System.out.println("Saldo insuficiente");
                }
            }
        } else {
            System.out.println("El Destinatario " + nombreDestinatario + " no existe");
        }
        return null;
    }
}
