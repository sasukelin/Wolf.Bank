package logicaNegocio;

/**
 * clase Cuenta bancaria
 */
public class CuentaBancaria {

    private String nombre;
    private String apellido;
    private int  identificacion;
    private double saldo;

    private  String email;
    private String contraseña;



    /****************************************************************************************************/
    /******************************************* CONSTRUCTORES ******************************************/
    /****************************************************************************************************/

    /**
     * Método constuctor para inicializar los atributos de la clase usuario
     * @param nombre nombre del usuario
     * @param apellido
     * @param identificacion
     * @param saldo saldo del usuario
     * @param email
     * @param contraseña contraseña del usuario
     *
     * Complejidad temporal: O(1) Tiempo constante
     */

    public CuentaBancaria(String nombre, String apellido, int identificacion,  double saldo,String  email, String contraseña) {
        this.nombre = nombre;
        this.apellido=apellido;
        this.identificacion=identificacion;
        this.saldo = saldo;
        this.email= email;
        this.contraseña = contraseña;
    }

    /****************************************************************************************************/
    /*************************************** MÉTODOS MODIFICADORES **************************************/
    /****************************************************************************************************/

    /**
     * Método para obtener el nombre del usuario
     * @return Retorna el nombre del usuario
     *
     * Complejidad temporal: O(1) Tiempo constante
     */

    public String getNombre() {

        return nombre;
    }

    /**
     * Método para obtener el saldo del usuario
     * @return Retorna el saldo del usuario
     *Complejidad temporal: O(1) Tiempo constante
     */

    public double getSaldo() {

        return this.saldo;
    }

    /**
     * Método para  modificar el saldo del usuario
     * @set establece o modifica el saldo del usuario
     * @param saldo
     * Complejidad temporal: O(1) Tiempo constante
     */

    public void setSaldo(double saldo) {

        this.saldo = saldo;
    }

    /**
     * Método para obtener la contraseña del usuario
     * @return Retorna la contraseña del usuario
     *
     * Complejidad temporal: O(1) Tiempo constante
     */

    public String getContraseña() {

        return contraseña;
    }

    /**
     * Método para obtener el Identificacion del usuario
     * @return Retorna la identificacion del usuario
     *
     * Complejidad temporal: O(1) Tiempo constante
     */

    public int getIdentificacion() {

        return identificacion;
    }

    /**
     * Método para obtener el email del usuario
     * @return Retorna el email del usuario
     *
     * Complejidad temporal: O(1) Tiempo constante
     */
    public String getEmail() {

        return email;
    }

    /**
     * Método para obtener el apellido del usuario
     * @return Retorna el apellido del usuario
     *
     * Complejidad temporal: O(1) Tiempo constante
     */

    public String getApellido() {

        return apellido;
    }


    /**
     * Método que permite depositar a la cuenta del usuario autenticado.
     * @param cantidad
     *
     *
     * Complejidad temporal: O(1) Tiempo constante
     */
    public  void depositar(double cantidad) {

            double saldoActual = this.getSaldo();
            double nuevoSaldo = saldoActual + cantidad;
            this.setSaldo(nuevoSaldo);


    }

    /**
     * Método que permite retirar dinero de la cuenta del usario autenticado
     * @param cantidad2
     *
     * Complejidad temporal: O(1) Tiempo constante
     */

    public void retirar(double cantidad2) {

            double saldoActual2 = this.getSaldo();

            if (saldoActual2 >= cantidad2) {
                double nuevoSaldo2 = saldoActual2 - cantidad2;
                this.setSaldo(nuevoSaldo2);

            } else {
                System.out.println("Saldo insuficiente");
            }

    }


}