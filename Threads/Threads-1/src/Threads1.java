public class Threads1 extends Thread {
    private String mensaje;
    private int retardo;
    private int veces;

    public Threads1(String mensaje, int retardo, int veces) {
        this.mensaje = mensaje;
        this.retardo = retardo;
        this.veces = veces;
    }

    /**
     * Pre: ---
     * Post: el metodo run() contiene el codigo a ejecutar por
     * parte del hilo.
     */
    public void run() {
        for (int i = 1; i <= veces; i++) {
            System.out.println(mensaje);
            try {
                /*
                 * Paraliza le ejecucion del hilo
                 * [retardo] milisegundos
                 */
                Thread.sleep(retardo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
/**
 * Creamos la clase y creamos las variables privadas: mensaje, retardo y veces.
 * <p>
 * Luego creamos el método Threads la cual va a crear un String donde ira el mensaje,un int para retardo y otro int para veces.
 * <p>
 * Indicamos que sean estas variables privadas las que vayamos a utilizar
 * <p>
 * Ahora crearemos el método run el cual con un bucle for se va a encargar de hacer un sout con los mensajes que hayamos puesto es decir A,B,C.
 * <p>
 * Utilizara tambien un .sleep para poder hacer el retardo que iba en el int y ya para terminar utilizamos el catch para la excepcion
 */