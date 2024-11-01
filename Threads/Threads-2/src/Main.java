import java.util.Random;
public class Main {
    /**
     * Pre: ---
     * Post: crea 3 hilos distintos, cada uno con sus atributos
     * 		correspondientes y los ejecuta. Podemos observar
     * 		la ejecución entrelazada.
     */
    public static void main(String[] args) {
        Random rand = new Random();
        /*
         * Creación de los hilos con un retardo random entre 100 y 300 milisegundos
         * y las veces que se imprime tambien es aleatoria entre 5-9
         */
        Thread[] t = new Thread[10];
        t[0] = new Thread1("Soy A", 100 + rand.nextInt(201), 5 + rand.nextInt(9));
        t[1] = new Thread1("Soy B", 100 + rand.nextInt(201), 5 + rand.nextInt(9));
        t[2] = new Thread1("Soy C", 100 + rand.nextInt(201), 5 + rand.nextInt(9));
        t[3] = new Thread1("Soy D", 100 + rand.nextInt(201), 5 + rand.nextInt(9));
        t[4] = new Thread1("Soy E", 100 + rand.nextInt(201), 5 + rand.nextInt(9));
        t[5] = new Thread1("Soy F", 100 + rand.nextInt(201), 5 + rand.nextInt(9));
        t[6] = new Thread1("Soy G", 100 + rand.nextInt(201), 5 + rand.nextInt(9));
        t[7] = new Thread1("Soy H", 100 + rand.nextInt(201), 5 + rand.nextInt(9));
        t[8] = new Thread1("Soy I", 100 + rand.nextInt(201), 5 + rand.nextInt(9));
        t[9] = new Thread1("Soy J", 100 + rand.nextInt(201), 5 + rand.nextInt(9));
        /*
         * Inicialización de los hilos
         */
        t[0].start();
        t[1].start();
        t[2].start();
        t[3].start();
        t[4].start();
        t[5].start();
        t[6].start();
        t[7].start();
        t[8].start();
        t[9].start();
        /*
         * Esperamos a que terminen los hilos
         */
        try {
            t[0].join();
            t[1].join();
            t[2].join();
            t[3].join();
            t[4].join();
            t[5].join();
            t[6].join();
            t[7].join();
            t[8].join();
            t[9].join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /*
         * Saca Fin al terminar los procesos
         */
        System.out.println("Fin");
    }
}