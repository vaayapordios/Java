public class Thread1 extends Thread {
    /**
     * @param mensaje
     * @param retardo
     * @param veces
     */
    private String mensaje;
    private int retardo;
    private int veces;
    /**
     Metodo constructor para realizar los threads
     */
    public Thread1(String mensaje, int retardo, int veces) {
        this.mensaje = mensaje;
        this.retardo = retardo;
        this.veces = veces;
    }
    /**
     * Pre: ---
     * Post: el metodo run() contiene el codigo a ejecutar por
     * 		parte del hilo.
     */
    public void run() {
        for(int i = 1; i <= veces; i++) {
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