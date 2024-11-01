public class Main {
    /**
     * Pre: ---
     * Post: crea 3 hilos distintos, cada uno con sus atributos
     * 		correspondientes y los ejecuta. Podemos observar
     * 		la ejecución entrelazada.
     */
    public static void main(String[] args) {
        /*
         * Creación de los hilos
         */
        Threads1 t1 = new Threads1("Soy A", 100, 1);
        Threads1 t2 = new Threads1("Soy B", 150, 2);
        Threads1 t3 = new Threads1("Soy C", 250, 1);
        /*
         * Inicialización de los hilos
         */
        t1.start();
        t2.start();
        t3.start();
        /*
         * Esperamos a que terminen los hilos
         */
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Fin");
    }
}
/**
 * El programa basicamente crea 3 hilos llamados t1 t2 y t3, t1=A t2=B t3=C, luego ponemos el retardo que queremos que tenga es decir el tiempo en milisegundos
 * que determina cuánto tiempo espera antes de ejecutar cada iteracion, y por ultimo el numero de veces que queremos que se ejecute cada hilo.
 *
 * Luego iniciamos cada hilo con el .start() y alli se ejecutan en las condiciones que les hemos asignado al crearse.
 *
 * Despues de inicializarlos el .join se asegura de que todos esos hilos hayan terminado su procesamiento.
 *
 * Catch se encarga de las excepciones la cual saltara si se interrumpe la ejecucion.
 *
 * Al final del proceso se ejecuta un sout el cual te indica que se ha terminado el programa con un "Fin".
 */