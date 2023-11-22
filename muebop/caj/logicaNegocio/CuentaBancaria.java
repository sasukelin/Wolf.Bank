package logicaNegocio;

/**
 * clase Usuario
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
     * @param saldo saldo del usuario
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
     * Método para obtener el nombre del usuario
     * @return Retorna el nombre del usuario
     *
     * Complejidad temporal: O(1) Tiempo constante
     */

    public double getSaldo() {

        return this.saldo;
    }

    /**
     * Método para  modificar el saldo del usuario
     * @set establece o modifica el saldo del usuario
     *
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

    public int getIdentificacion() {
        return identificacion;
    }

    public String getEmail() {
        return email;
    }

    public String getApellido() {
        return apellido;
    }

    public  void depositar(double cantidad) {

            double saldoActual = this.getSaldo();
            double nuevoSaldo = saldoActual + cantidad;
            this.setSaldo(nuevoSaldo);


    }


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