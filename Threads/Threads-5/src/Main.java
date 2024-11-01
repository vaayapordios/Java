import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    /**
     * Definicion de las constantes y estructuras de datos necesarias para multiplicar la matriz por el vector
     */
    private static final int SIZE = 512;
    private static final int THREAD_COUNT = 16;
    private static final float[][] matrix = new float[SIZE][SIZE];
    private static final float[] vector = new float[SIZE];
    private static final float[] result = new float[SIZE];
    private static final AtomicInteger tMax = new AtomicInteger(0);
    private static final AtomicInteger idMasLento = new AtomicInteger(-1);
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        /**
         * Inicializa la matriz y el vector y configura los indicadores de finalizacion para los hilos
         */
        initializeMatrixAndVector();

        /**
         * Crea un pool de hilos y distribuye la multiplicacion de la matriz po el vector entre los hilos
         */
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            int startRow = i * (SIZE / THREAD_COUNT);
            int endRow = (i + 1) * (SIZE / THREAD_COUNT);
            executor.execute(new MatrixMultiplier(i, startRow, endRow));
        }

        /**
         * Cierra el pool de hilos y espera a que todos los hilos completen su ejecucion
         */
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        /**
         * Calcula e imprime el modulo del vector resultante y el hilo mas lento
         */
        double modulo = calculateModulo();
        System.out.println("El modulo del vector resultante es: " + modulo);
        System.out.println("El thread mas lento fue el thread " + idMasLento.get() + " con un tiempo de " + tMax.get() + " ms");
    }

    /**
     * Inicializa la matriz y el vector con valores aleatorios.
     */
    private static void initializeMatrixAndVector() {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            vector[i] = random.nextFloat();
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = random.nextFloat();
            }
        }
    }

    /**
     * Clase interna que implementa Runnable para multiplicar una parte de la matriz por el vector.
     */
    static class MatrixMultiplier implements Runnable {
        private final int threadIndex;
        private final int startRow;
        private final int endRow;

        /**
         * Constructor para inicializar los datos del hilo.
         */
        public MatrixMultiplier(int threadIndex, int startRow, int endRow) {
            this.threadIndex = threadIndex;
            this.startRow = startRow;
            this.endRow = endRow;
        }

        /**
         * Realiza la multiplicacion de la parte de la matriz asignada y registra el tiempo de ejecucion.
         * Actualiza las variables de tiempo maximo e identificador del hilo mas lento en exclusion mutua.
         */
        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            for (int i = startRow; i < endRow; i++) {
                result[i] = 0;
                for (int j = 0; j < SIZE; j++) {
                    result[i] += matrix[i][j] * vector[j];
                }
            }
            long endTime = System.currentTimeMillis();
            int duration = (int) (endTime - startTime);

            lock.lock();
            try {
                if (duration > tMax.get()) {
                    tMax.set(duration);
                    idMasLento.set(threadIndex);
                }
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * Calcula el modulo del vector resultante.
     */
    private static double calculateModulo() {
        double sum = 0;
        for (float value : result) {
            sum += value * value;
        }
        return Math.sqrt(sum);
    }
}