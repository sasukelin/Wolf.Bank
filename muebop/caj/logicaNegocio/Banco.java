package logicaNegocio;
import java.util.LinkedList;

/**
 * clase Banco
 */

public class Banco {
    private static LinkedList<CuentaBancaria> cuentasBancarias = new LinkedList<>();
    private static CuentaBancaria usuarioAutenticado;

    /**
     * Método para registrar una nueva cuenta bancaria.
     * @param usuario
     * Complejidad Temporal: O(n) - Lineal.
     */
    public static boolean registrar(CuentaBancaria usuario) {
        boolean existe = false;
        boolean existe2=false;

        // Verifica si ya existe una cuenta con el mismo email o identificación
        for (CuentaBancaria Usuario : cuentasBancarias) {
            if (Usuario.getEmail().equals(usuario.getEmail()) ) {
                existe = true;
            }
            if(Usuario.getIdentificacion()==(usuario.getIdentificacion())){
                existe2=true;
            }
        }

        // Registra la cuenta si no existe previamente
        if (!existe && !existe2) {
            cuentasBancarias.add(usuario);
            return true;
        } else {
            return false;
        }
    }

     /**
     * Método para autenticar un usuario por email y contraseña.
     * @param usuarioEmail
      *@param contraseña
     * Complejidad Temporal: O(n) - Lineal.
     */
    public static CuentaBancaria Autenticar(String usuarioEmail, String contraseña) {
        CuentaBancaria usuarioEncontrado = null;

        // Busca el usuario por email
        for (CuentaBancaria Usuario : cuentasBancarias) {
            if (Usuario.getEmail().equals(usuarioEmail)) {
                usuarioEncontrado = Usuario;
                break;
            }
        }

        // Verifica la contraseña si el usuario existe
        if (usuarioEncontrado != null) {
            if (usuarioEncontrado.getContraseña().equals(contraseña)) {
                usuarioAutenticado = usuarioEncontrado;
                return usuarioAutenticado;
            } else {
              return null; // Contraseña incorrecta

            }
        } else {
            System.out.println("El usuario no existe");
        }
        return usuarioEncontrado;
    }


    /**
     * Método para realizar una transferencia de saldo a otro usuario.
     * @param idDestinatario
     * @param cantidad
     * Complejidad Temporal: O(n) - Lineal
     */

    public static CuentaBancaria transferir(int idDestinatario, double cantidad) {

        // Busca al destinatario por identificación
        if (usuarioAutenticado != null) {
            CuentaBancaria destinatario = null;
            for (CuentaBancaria usuario : cuentasBancarias) {
                if (usuario.getIdentificacion()==(idDestinatario)) {
                    destinatario = usuario;
                    break;
                }
            }

            // Realiza la transferencia si el destinatario existe y hay saldo suficiente
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
