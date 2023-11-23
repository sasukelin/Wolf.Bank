package logicaNegocio;
import java.util.LinkedList;



public class Banco {
    private static LinkedList<CuentaBancaria> cuentasBancarias = new LinkedList<>();
    private static CuentaBancaria usuarioAutenticado;

    public static boolean registrar(CuentaBancaria usuario) {
        boolean existe = false;
        boolean existe2=false;
        for (CuentaBancaria Usuario : cuentasBancarias) {
            if (Usuario.getEmail().equals(usuario.getEmail()) ) {
                existe = true;
            }
            if(Usuario.getIdentificacion()==(usuario.getIdentificacion())){
                existe2=true;
            }
        }
        if (!existe && !existe2) {
            cuentasBancarias.add(usuario);
            return true;
        } else {
            return false;
        }
    }

    public static CuentaBancaria Autenticar(String usuarioEmail, String contraseña) {
        CuentaBancaria usuarioEncontrado = null;

        for (CuentaBancaria Usuario : cuentasBancarias) {
            if (Usuario.getEmail().equals(usuarioEmail)) {
                usuarioEncontrado = Usuario;
                break;
            }
        }
        if (usuarioEncontrado != null) {
            if (usuarioEncontrado.getContraseña().equals(contraseña)) {
                usuarioAutenticado = usuarioEncontrado;


                return usuarioAutenticado;
            } else {
              return null;

            }
        } else {
            System.out.println("El usuario no existe");
        }
        return usuarioEncontrado;
    }


    public static CuentaBancaria transferir(int idDestinatario, double cantidad) {

        if (usuarioAutenticado != null) {
            CuentaBancaria destinatario = null;
            for (CuentaBancaria usuario : cuentasBancarias) {
                if (usuario.getIdentificacion()==(idDestinatario)) {
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

        }
        return null;
    }
}
